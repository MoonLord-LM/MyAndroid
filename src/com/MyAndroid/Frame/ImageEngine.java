package com.MyAndroid.Frame;

import com.MyAndroid.Http;
import com.MyAndroid.IO;

// 图片加载引擎
//
// 注意：
// 需要保证不同图片的URL中的文件名不同
// 需要保证所有请求图片的Activity在同一<package name>中
// 
// 提示：
// 网络访问使用com.MyAndroid.Http执行（默认30秒超时）
// 图片本地保存路径为/sdcard/Android/data/<package name>/cache，SD卡不可用时无法加载图片
// 为了解决图片加载顺序错乱的问题，对ImageView/View进行了setTag和getTag的操作
// 建议只在一个项目中使用一种图片引擎，防止内存、线程、网络访问的冲突
// 
public class ImageEngine {
	// 缓存图片型引擎
	// 适用于图片像素较小，内存空间较大，重复访问较多的场景（非透明图片）
	public static class BitmapCacheImageEngine {
		// 内存软引用缓存
		private static java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> BitmapCache = new java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>>();
		// 正在执行网络下载任务的URL
		private static java.util.ArrayList<java.lang.String> DownLoadingFileName = new java.util.ArrayList<java.lang.String>();
		// 线程池
		private static java.util.concurrent.ExecutorService ThreadPool;
		private static java.util.concurrent.ExecutorService ThreadPool() {
			if (ThreadPool == null) {
				ThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
			}
			return ThreadPool;
		}
		// 显示图片
		private static void ShowImage(android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final android.graphics.Bitmap Image) {
			if (Activity != null) {
				Activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (ImageView != null && (Integer) ImageView.getTag() == ImagePositon) {
							ImageView.setImageBitmap(Image);
						}
					}
				});
			}
		}
		private static void ShowImage(android.app.Activity Activity, final android.view.View View, final int ImagePositon, final android.graphics.Bitmap Image) {
			if (Activity != null) {
				Activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (View != null && (Integer) View.getTag() == ImagePositon) {
							View.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(Image));
						}
					}
				});
			}
		}
		// 加载图片（主要函数，可在UI线程调用）
		public static void Load(final android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final java.lang.String URL) {
			ImageView.setTag(ImagePositon);
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<android.graphics.Bitmap> BitmapReference = BitmapCache.get(FileName);
					if (BitmapReference != null) {
						TempImage = BitmapReference.get();
						if (TempImage != null) {
							ShowImage(Activity, ImageView, ImagePositon, TempImage);
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempImage = IO.SDCard.AppCacheReadBitmap(Activity, FileName);
						if (TempImage != null) {
							ShowImage(Activity, ImageView, ImagePositon, TempImage);
							BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						byte[] TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void Load(final android.app.Activity Activity, final android.view.View View, final int ImagePositon, final java.lang.String URL) {
			View.setTag(ImagePositon);
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<android.graphics.Bitmap> BitmapReference = BitmapCache.get(FileName);
					if (BitmapReference != null) {
						TempImage = BitmapReference.get();
						if (TempImage != null) {
							ShowImage(Activity, View, ImagePositon, TempImage);
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempImage = IO.SDCard.AppCacheReadBitmap(Activity, FileName);
						if (TempImage != null) {
							ShowImage(Activity, View, ImagePositon, TempImage);
							BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						byte[] TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void LoadLowQuality(final android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final java.lang.String URL) {
			ImageView.setTag(ImagePositon);
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<android.graphics.Bitmap> BitmapReference = BitmapCache.get(FileName);
					if (BitmapReference != null) {
						TempImage = BitmapReference.get();
						if (TempImage != null) {
							ShowImage(Activity, ImageView, ImagePositon, TempImage);
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempImage = IO.SDCard.AppCacheReadBitmapLowQuality(Activity, FileName);
						if (TempImage != null) {
							ShowImage(Activity, ImageView, ImagePositon, TempImage);
							BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						byte[] TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void LoadLowQuality(final android.app.Activity Activity, final android.view.View View, final int ImagePositon, final java.lang.String URL) {
			View.setTag(ImagePositon);
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<android.graphics.Bitmap> BitmapReference = BitmapCache.get(FileName);
					if (BitmapReference != null) {
						TempImage = BitmapReference.get();
						if (TempImage != null) {
							ShowImage(Activity, View, ImagePositon, TempImage);
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempImage = IO.SDCard.AppCacheReadBitmapLowQuality(Activity, FileName);
						if (TempImage != null) {
							ShowImage(Activity, View, ImagePositon, TempImage);
							BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
							DownLoadingFileName.remove(FileName);
							return;
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						byte[] TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								BitmapCache.put(FileName, new java.lang.ref.SoftReference<android.graphics.Bitmap>(TempImage));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
	}
	// 缓存文件型引擎
	// 适用于图片像素较大，内存空间较小，重复访问较少的场景（非透明图片）
	public static class FileCacheImageEngine {
		// 内存软引用缓存
		private static java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<byte[]>> FileCache = new java.util.HashMap<java.lang.String, java.lang.ref.SoftReference<byte[]>>();
		// 正在执行网络下载任务的URL
		private static java.util.ArrayList<java.lang.String> DownLoadingFileName = new java.util.ArrayList<java.lang.String>();
		// 线程池
		private static java.util.concurrent.ExecutorService ThreadPool;
		private static java.util.concurrent.ExecutorService ThreadPool() {
			if (ThreadPool == null) {
				ThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
			}
			return ThreadPool;
		}
		// 显示图片
		private static void ShowImage(android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final android.graphics.Bitmap Image) {
			if (Activity != null) {
				Activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (ImageView != null && (Integer) ImageView.getTag() == ImagePositon) {
							ImageView.setImageBitmap(Image);
						}
					}
				});
			}
		}
		private static void ShowImage(android.app.Activity Activity, final android.view.View View, final int ImagePositon, final android.graphics.Bitmap Image) {
			if (Activity != null) {
				Activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (View != null && (Integer) View.getTag() == ImagePositon) {
							View.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(Image));
						}
					}
				});
			}
		}
		// 加载图片（主要函数，可在UI线程调用）
		public static void Load(final android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final java.lang.String URL) {
			ImageView.setTag(ImagePositon);
			final android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
			options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					byte[] TempByte;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<byte[]> FileReference = FileCache.get(FileName);
					if (FileReference != null) {
						TempByte = FileReference.get();
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempByte = IO.SDCard.AppCacheReadByteArray(Activity, FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void Load(final android.app.Activity Activity, final android.view.View View, final int ImagePositon, final java.lang.String URL) {
			View.setTag(ImagePositon);
			final android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
			options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					byte[] TempByte;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<byte[]> FileReference = FileCache.get(FileName);
					if (FileReference != null) {
						TempByte = FileReference.get();
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempByte = IO.SDCard.AppCacheReadByteArray(Activity, FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void LoadLowQuality(final android.app.Activity Activity, final android.widget.ImageView ImageView, final int ImagePositon, final java.lang.String URL) {
			ImageView.setTag(ImagePositon);
			final android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
			options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					byte[] TempByte;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<byte[]> FileReference = FileCache.get(FileName);
					if (FileReference != null) {
						TempByte = FileReference.get();
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempByte = IO.SDCard.AppCacheReadByteArray(Activity, FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, ImageView, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
		public static void LoadLowQuality(final android.app.Activity Activity, final android.view.View View, final int ImagePositon, final java.lang.String URL) {
			View.setTag(ImagePositon);
			final android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
			options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
			ThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					android.graphics.Bitmap TempImage;
					byte[] TempByte;
					java.lang.String FileName = URL.substring(URL.lastIndexOf("/") + 1);
					// 多个线程同时请求同一个图片（等待30秒）
					int WaitingTime = 0;
					while (DownLoadingFileName.indexOf(FileName) != -1) {
						try {
							Thread.sleep(100);
							WaitingTime += 100;
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (WaitingTime > 30000) {
							break;
						}
					}
					DownLoadingFileName.add(FileName);
					// 尝试从内存软引用里加载
					java.lang.ref.SoftReference<byte[]> FileReference = FileCache.get(FileName);
					if (FileReference != null) {
						TempByte = FileReference.get();
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从文件里加载
					if (IO.SDCard.IsReady() == true) {
						TempByte = IO.SDCard.AppCacheReadByteArray(Activity, FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 尝试从网络中获取
					if (IO.SDCard.IsReady() == true) {
						TempByte = Http.DownLoadByteArray(URL, IO.SDCard.CachePath(Activity) + "/" + FileName);
						if (TempByte != null) {
							TempImage = IO.ReadBitmapLowQualityFromInputStream(new java.io.ByteArrayInputStream(TempByte));
							if (TempImage != null) {
								ShowImage(Activity, View, ImagePositon, TempImage);
								FileCache.put(FileName, new java.lang.ref.SoftReference<byte[]>(TempByte));
								DownLoadingFileName.remove(FileName);
								return;
							}
						}
					}
					// 获取失败
					DownLoadingFileName.remove(FileName);
					return;
				}
			});
		}
	}
}
