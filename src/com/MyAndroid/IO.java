package com.MyAndroid;

// 文件IO操作
//（动态类+静态函数库）
// 需要权限：<uses-permissionandroid:name="android.permission.WRITE_EXTERNAL_STORAGE"/> 
public class IO {
	private android.app.Activity MyActivity;
	public IO(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 将一个java.io.InputStream输入流读取为Byte数组
	public static byte[] ReadByteArrayFromInputStream(java.io.InputStream InputStream) throws java.io.IOException {
		java.io.ByteArrayOutputStream ByteStream = null;
		try {
			// 以4KB的缓冲区读取
			ByteStream = new java.io.ByteArrayOutputStream(4096);
			byte[] buffer = new byte[4096];
			int size;
			while ((size = InputStream.read(buffer, 0, 4096)) > -1) {
				ByteStream.write(buffer, 0, size);
			}
			return ByteStream.toByteArray();
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
			try {
				ByteStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 将一个java.io.InputStream输入流读取为字符串
	public static java.lang.String ReadStringFromInputStream(java.io.InputStream InputStream) throws java.io.IOException {
		java.lang.StringBuffer temp = new java.lang.StringBuffer("");
		java.io.InputStreamReader in = null;
		try {
			in = new java.io.InputStreamReader(InputStream, Setting.Charset);// 以4KB的缓冲区读取
			char[] buffer = new char[4096];
			int size;
			while ((size = in.read(buffer, 0, 4096)) > -1) {
				temp.append(buffer, 0, size);
			}
			return temp.toString();
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				in.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 将一个java.io.InputStream输入流读取为图片（高质量，透明抗锯齿）
	public static android.graphics.Bitmap ReadBitmapFromInputStream(java.io.InputStream InputStream) {
		android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
		try {
			options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
			return android.graphics.BitmapFactory.decodeStream(InputStream, null, options);
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 将一个java.io.InputStream输入流读取为图片（低质量，不透明不抗锯齿）
	public static android.graphics.Bitmap ReadBitmapLowQualityFromInputStream(java.io.InputStream InputStream) {
		android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
		try {
			options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
			return android.graphics.BitmapFactory.decodeStream(InputStream, null, options);
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 向一个java.io.OutputStream输出流中写入Byte数组
	public static boolean WriteByteArrayToOutputStream(java.io.OutputStream OutputStream, byte[] Data) throws java.io.IOException {
		try {
			OutputStream.write(Data);
			OutputStream.flush();
			return true;
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				OutputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 向一个java.io.OutputStream输出流中写入字符串
	public static boolean WriteStringToOutputStream(java.io.OutputStream OutputStream, java.lang.String Data) throws java.io.IOException {
		try {
			OutputStream.write(Data.getBytes(Setting.Charset));
			OutputStream.flush();
			return true;
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				OutputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 向一个java.io.OutputStream输出流中写入图片（100%质量的PNG）
	public static boolean WriteBitmapToOutputStream(java.io.OutputStream OutputStream, android.graphics.Bitmap Data) throws java.io.IOException {
		try {
			Data.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, OutputStream);
			OutputStream.flush();
			return true;
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				OutputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// 向一个java.io.OutputStream输出流中写入图片（100%质量的JPG）
	public static boolean WriteBitmapLowQualityToOutputStream(java.io.OutputStream OutputStream, android.graphics.Bitmap Data) throws java.io.IOException {
		try {
			Data.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, OutputStream);
			OutputStream.flush();
			return true;
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				OutputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	// IO基本设置
	public static class Setting {
		private static java.lang.String Charset = "UTF-8";// 字符编码：UTF-8
		public static void SetCharset(java.lang.String Value) {
			if (Value != null) {
				Charset = Value;
			}
		}
	}
	// 项目res文件夹中的资源（比如R.drawable.ic_launcher）
	public Resource Resource() {
		return new Resource(MyActivity);
	}
	public static class Resource {
		private android.app.Activity MyActivity;
		public Resource(android.app.Activity Activity) {
			MyActivity = Activity;
		}
		// 读取字符串（出现异常则返回null值）
		public static byte[] ReadByteArray(android.app.Activity Activity, int ResourceId) {
			try {
				return ReadByteArrayFromInputStream(Activity.getResources().openRawResource(ResourceId));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取字符串（出现异常则返回null值）
		public static java.lang.String ReadString(android.app.Activity Activity, int ResourceId) {
			try {
				return ReadStringFromInputStream(Activity.getResources().openRawResource(ResourceId));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取图片（出现异常则返回null值）
		public static android.graphics.Bitmap ReadBitmap(android.app.Activity Activity, int ResourceId) {
			try {
				return ReadBitmapFromInputStream(Activity.getResources().openRawResource(ResourceId));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public static android.graphics.Bitmap ReadBitmapLowQuality(android.app.Activity Activity, int ResourceId) {
			try {
				return ReadBitmapLowQualityFromInputStream(Activity.getResources().openRawResource(ResourceId));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] ReadByteArray(int ResourceId) {
			return ReadByteArray(MyActivity, ResourceId);
		}
		public java.lang.String ReadString(int ResourceId) {
			return ReadString(MyActivity, ResourceId);
		}
		public android.graphics.Bitmap ReadBitmap(int ResourceId) {
			return ReadBitmap(MyActivity, ResourceId);
		}
		public android.graphics.Bitmap ReadBitmapLowQuality(int ResourceId) {
			return ReadBitmapLowQuality(MyActivity, ResourceId);
		}
	}
	// 项目assets文件夹中的资源（比如"ic_launcher.png"）
	public Assets Assets() {
		return new Assets(MyActivity);
	}
	public static class Assets {
		private android.app.Activity MyActivity;
		public Assets(android.app.Activity Activity) {
			MyActivity = Activity;
		}
		// 读取字节数组（出现异常则返回null值）
		public static byte[] ReadByteArray(android.app.Activity Activity, java.lang.String FilePath) {
			try {
				return ReadByteArrayFromInputStream(Activity.getResources().getAssets().open(FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取字符串（出现异常则返回null值）
		public static java.lang.String ReadString(android.app.Activity Activity, java.lang.String FilePath) {
			try {
				return ReadStringFromInputStream(Activity.getResources().getAssets().open(FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取图片（出现异常则返回null值）
		public static android.graphics.Bitmap ReadBitmap(android.app.Activity Activity, java.lang.String FilePath) {
			try {
				return ReadBitmapFromInputStream(Activity.getResources().getAssets().open(FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public static android.graphics.Bitmap ReadBitmapLowQuality(android.app.Activity Activity, java.lang.String FilePath) {
			try {
				return ReadBitmapLowQualityFromInputStream(Activity.getResources().getAssets().open(FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] ReadByteArray(java.lang.String FilePath) {
			return ReadByteArray(MyActivity, FilePath);
		}
		public java.lang.String ReadString(java.lang.String FilePath) {
			return ReadString(MyActivity, FilePath);
		}
		public android.graphics.Bitmap ReadBitmap(java.lang.String FilePath) {
			return ReadBitmap(MyActivity, FilePath);
		}
		public android.graphics.Bitmap ReadBitmapLowQuality(java.lang.String FilePath) {
			return ReadBitmapLowQuality(MyActivity, FilePath);
		}
	}
	// 手机上的文件（使用绝对路径访问，注意有些目录需要root权限才能访问）
	// 以下为常用的APP文件保存路径（注意Cache目录的文件可能会被清理）：
	// getCacheDir().getAbsolutePath()：/data/data/<package name>/cache
	// getFilesDir().getAbsolutePath()：/data/data/<package name>/files
	// getDir("files", 0).getAbsolutePath()：/data/data/<package name>/app_files
	public FileSystem FileSystem() {
		return new FileSystem();
	}
	public static class FileSystem {
		// 读取字节数组（出现异常则返回null值）
		public static byte[] ReadByteArray(java.lang.String FilePath) {
			try {
				return ReadByteArrayFromInputStream(new java.io.FileInputStream("/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取字符串（出现异常则返回null值）
		public static java.lang.String ReadString(java.lang.String FilePath) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream("/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 读取图片（出现异常则返回null值）
		public static android.graphics.Bitmap ReadBitmap(java.lang.String FilePath) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream("/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public static android.graphics.Bitmap ReadBitmapLowQuality(java.lang.String FilePath) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream("/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 写入字符串（返回是否写入成功）
		public static boolean WriteString(java.lang.String FilePath, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream("/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 写入字节数组（返回是否写入成功）
		public static boolean WriteByteArray(java.lang.String FilePath, byte[] Data) {
			try {
				return WriteByteArrayToOutputStream(new java.io.FileOutputStream("/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 写入图片（返回是否写入成功）
		public static boolean WriteBitmap(java.lang.String FilePath, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream("/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean WriteBitmapLowQuality(java.lang.String FilePath, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream("/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 删除指定的文件或目录（无限递归删除，返回是否删除成功）
		public static boolean DeleteFileOrDirectory(java.io.File FileOrDirectory) {
			if (FileOrDirectory.exists()) {
				if (FileOrDirectory.isFile()) {
					FileOrDirectory.delete();
				}
				else if (FileOrDirectory.isDirectory()) {
					java.io.File files[] = FileOrDirectory.listFiles();
					for (int i = 0; i < files.length; i++) {
						DeleteFileOrDirectory(files[i]);
					}
				}
			}
			return FileOrDirectory.exists();
		}
	}
	// 手机内置存储空间
	public InternalStorage InternalStorage() {
		return new InternalStorage(MyActivity);
	}
	public static class InternalStorage {
		private android.app.Activity MyActivity;
		public InternalStorage(android.app.Activity Activity) {
			MyActivity = Activity;
		}
		// 总容量（Byte）
		public static long TotalSize() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount();
		}
		// 可用容量（Byte）
		public static long AvailableSize() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks();
		}
		// 总容量（KB）
		public static long TotalSizeKB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount() / 1024;
		}
		// 可用容量（KB）
		public static long AvailableSizeKB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024;
		}
		// 总容量（MB）
		public static long TotalSizeMB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount() / 1024 / 1024;
		}
		// 可用容量（MB）
		public static long AvailableSizeMB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024 / 1024;
		}
		// 总容量（实测结果：1.48GB）
		public static java.lang.String TotalSizeString(android.app.Activity Activity) {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(Activity, stat.getBlockSize() * (long) stat.getBlockCount());
		}
		public java.lang.String TotalSizeString() {
			return TotalSizeString(MyActivity);
		}
		// 可用容量（实测结果：292MB）
		public static java.lang.String AvailableSizeString(android.app.Activity Activity) {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(Activity, stat.getBlockSize() * (long) stat.getAvailableBlocks());
		}
		public java.lang.String AvailableSizeString() {
			return AvailableSizeString(MyActivity);
		}
		// APP文件目录（/data/data/<package name>/files）
		public static java.lang.String AppFilesPath(android.app.Activity Activity) {
			return Activity.getFilesDir().getAbsolutePath();
		}
		public java.lang.String AppFilesPath() {
			return MyActivity.getFilesDir().getAbsolutePath();
		}
		// APP缓存目录（/data/data/<package name>/cache）
		public static java.lang.String AppCachePath(android.app.Activity Activity) {
			return Activity.getCacheDir().getAbsolutePath();
		}
		public java.lang.String AppCachePath() {
			return MyActivity.getCacheDir().getAbsolutePath();
		}
		// 从APP数据目录，读取字节数组（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static byte[] AppFilesReadByteArray(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadByteArrayFromInputStream(new java.io.FileInputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] AppFilesReadByteArray(java.lang.String FileName) {
			return AppFilesReadByteArray(MyActivity, FileName);
		}
		public static byte[] AppCacheReadByteArray(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadByteArrayFromInputStream(new java.io.FileInputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] AppCacheReadByteArray(java.lang.String FileName) {
			return AppCacheReadByteArray(MyActivity, FileName);
		}
		// 从APP数据目录，读取字符串（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static java.lang.String AppFilesReadString(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public java.lang.String AppFilesReadString(java.lang.String FileName) {
			return AppFilesReadString(MyActivity, FileName);
		}
		public static java.lang.String AppCacheReadString(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public java.lang.String AppCacheReadString(java.lang.String FileName) {
			return AppCacheReadString(MyActivity, FileName);
		}
		// 从APP数据目录，读取图片（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static android.graphics.Bitmap AppFilesReadBitmap(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppFilesReadBitmap(java.lang.String FileName) {
			return AppFilesReadBitmap(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppFilesReadBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppFilesReadBitmapLowQuality(java.lang.String FileName) {
			return AppFilesReadBitmapLowQuality(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppCacheReadBitmap(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppCacheReadBitmap(java.lang.String FileName) {
			return AppCacheReadBitmap(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppCacheReadBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppCacheReadBitmapLowQuality(java.lang.String FileName) {
			return AppCacheReadBitmapLowQuality(MyActivity, FileName);
		}
		// 向APP数据目录，写入字节数组（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteByteArray(android.app.Activity Activity, java.lang.String FileName, byte[] Data) {
			try {
				return WriteByteArrayToOutputStream(new java.io.FileOutputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteByteArray(java.lang.String FileName, byte[] Data) {
			return AppFilesWriteByteArray(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteByteArray(android.app.Activity Activity, java.lang.String FileName, byte[] Data) {
			try {
				return WriteByteArrayToOutputStream(new java.io.FileOutputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteByteArray(java.lang.String FileName, byte[] Data) {
			return AppCacheWriteByteArray(MyActivity, FileName, Data);
		}
		// 向APP数据目录，写入字符串（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteString(android.app.Activity Activity, java.lang.String FileName, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteString(java.lang.String FileName, java.lang.String Data) {
			return AppFilesWriteString(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteString(android.app.Activity Activity, java.lang.String FileName, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteString(java.lang.String FileName, java.lang.String Data) {
			return AppCacheWriteString(MyActivity, FileName, Data);
		}
		// 向APP数据目录，写入图片（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteBitmap(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteBitmap(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppFilesWriteBitmap(MyActivity, FileName, Data);
		}
		public static boolean AppFilesWriteBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream(Activity.getFilesDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteBitmapLowQuality(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppFilesWriteBitmapLowQuality(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteBitmap(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteBitmap(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppCacheWriteBitmap(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream(Activity.getCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteBitmapLowQuality(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppCacheWriteBitmapLowQuality(MyActivity, FileName, Data);
		}
	}
	// 手机外置或虚拟的SD卡
	public SDCard SDCard() {
		return new SDCard(MyActivity);
	}
	public static class SDCard {
		private android.app.Activity MyActivity;
		public SDCard(android.app.Activity Activity) {
			MyActivity = Activity;
		}
		// SD卡状态是否可读可写
		public static boolean IsReady() {
			return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		}
		// SD卡状态是否为虚拟SD卡
		public static boolean IsEmulate() {
			return android.os.Environment.isExternalStorageEmulated();
		}
		// SD总容量（Byte）
		public static long TotalSize() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount();
		}
		// SD可用容量（Byte）
		public static long AvailableSize() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks();
		}
		// SD总容量（KB）
		public static long TotalSizeKB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount() / 1024;
		}
		// SD可用容量（KB）
		public static long AvailableSizeKB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024;
		}
		// SD总容量（MB）
		public static long TotalSizeMB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getBlockCount() / 1024 / 1024;
		}
		// SD可用容量（MB）
		public static long AvailableSizeMB() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024 / 1024;
		}
		// 总容量（实测结果：29.02GB）
		public static java.lang.String TotalSizeString(android.app.Activity Activity) {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(Activity, stat.getBlockSize() * (long) stat.getBlockCount());
		}
		public java.lang.String TotalSizeString() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(MyActivity, stat.getBlockSize() * (long) stat.getBlockCount());
		}
		// 可用容量（实测结果：25.12GB）
		public static java.lang.String AvailableSizeString(android.app.Activity Activity) {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(Activity, stat.getBlockSize() * (long) stat.getAvailableBlocks());
		}
		public java.lang.String AvailableSizeString() {
			android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
			return android.text.format.Formatter.formatFileSize(MyActivity, stat.getBlockSize() * (long) stat.getAvailableBlocks());
		}
		// APP文件目录（/sdcard/Android/data/<package name>/files，即/storage/sdcard0/Android/data/<package name>/files）
		public static java.lang.String FilesPath(android.app.Activity Activity) {
			return Activity.getExternalFilesDir(null).getAbsolutePath();
		}
		public java.lang.String FilesPath() {
			return MyActivity.getExternalFilesDir(null).getAbsolutePath();
		}
		// APP缓存目录（/sdcard/Android/data/<package name>/cache，即/storage/sdcard0/Android/data/<package name>/cache）
		public static java.lang.String CachePath(android.app.Activity Activity) {
			return Activity.getExternalCacheDir().getAbsolutePath();
		}
		public java.lang.String CachePath() {
			return MyActivity.getExternalCacheDir().getAbsolutePath();
		}
		// 从APP数据目录，读取字节数组（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static byte[] AppFilesReadByteArray(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadByteArrayFromInputStream(new java.io.FileInputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] AppFilesReadByteArray(java.lang.String FileName) {
			return AppFilesReadByteArray(MyActivity, FileName);
		}
		public static byte[] AppCacheReadByteArray(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadByteArrayFromInputStream(new java.io.FileInputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public byte[] AppCacheReadByteArray(java.lang.String FileName) {
			return AppCacheReadByteArray(MyActivity, FileName);
		}
		// 从APP数据目录，读取字符串（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static java.lang.String AppFilesReadString(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public java.lang.String AppFilesReadString(java.lang.String FileName) {
			return AppFilesReadString(MyActivity, FileName);
		}
		public static java.lang.String AppCacheReadString(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public java.lang.String AppCacheReadString(java.lang.String FileName) {
			return AppCacheReadString(MyActivity, FileName);
		}
		// 从APP数据目录，读取图片（出现异常则返回null值，注意FileName为文件名称而不是相对路径）
		public static android.graphics.Bitmap AppFilesReadBitmap(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppFilesReadBitmap(java.lang.String FileName) {
			return AppFilesReadBitmap(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppFilesReadBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppFilesReadBitmapLowQuality(java.lang.String FileName) {
			return AppFilesReadBitmapLowQuality(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppCacheReadBitmap(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppCacheReadBitmap(java.lang.String FileName) {
			return AppCacheReadBitmap(MyActivity, FileName);
		}
		public static android.graphics.Bitmap AppCacheReadBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public android.graphics.Bitmap AppCacheReadBitmapLowQuality(java.lang.String FileName) {
			return AppCacheReadBitmapLowQuality(MyActivity, FileName);
		}
		// 向APP数据目录，写入字节数组（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteByteArray(android.app.Activity Activity, java.lang.String FileName, byte[] Data) {
			try {
				return WriteByteArrayToOutputStream(new java.io.FileOutputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteByteArray(java.lang.String FileName, byte[] Data) {
			return AppFilesWriteByteArray(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteByteArray(android.app.Activity Activity, java.lang.String FileName, byte[] Data) {
			try {
				return WriteByteArrayToOutputStream(new java.io.FileOutputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteByteArray(java.lang.String FileName, byte[] Data) {
			return AppCacheWriteByteArray(MyActivity, FileName, Data);
		}
		// 向APP数据目录，写入字符串（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteString(android.app.Activity Activity, java.lang.String FileName, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteString(java.lang.String FileName, java.lang.String Data) {
			return AppFilesWriteString(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteString(android.app.Activity Activity, java.lang.String FileName, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteString(java.lang.String FileName, java.lang.String Data) {
			return AppCacheWriteString(MyActivity, FileName, Data);
		}
		// 向APP数据目录，写入图片（返回是否写入成功，注意FileName为文件名称而不是相对路径）
		public static boolean AppFilesWriteBitmap(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteBitmap(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppFilesWriteBitmap(MyActivity, FileName, Data);
		}
		public static boolean AppFilesWriteBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream(Activity.getExternalFilesDir(null).getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppFilesWriteBitmapLowQuality(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppFilesWriteBitmapLowQuality(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteBitmap(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteBitmap(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppCacheWriteBitmap(MyActivity, FileName, Data);
		}
		public static boolean AppCacheWriteBitmapLowQuality(android.app.Activity Activity, java.lang.String FileName, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream(Activity.getExternalCacheDir().getAbsolutePath() + "/" + FileName), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean AppCacheWriteBitmapLowQuality(java.lang.String FileName, android.graphics.Bitmap Data) {
			return AppCacheWriteBitmapLowQuality(MyActivity, FileName, Data);
		}
		// SD卡根目录（/storage/sdcard0）
		public static java.lang.String Directory() {
			return android.os.Environment.getExternalStorageDirectory().toString();
		}
		// 建立目录，返回是否建立成功（目录已存在返回true，FilePath为文件在SD卡下的相对路径）
		public static boolean MakeDirectory(java.lang.String FilePath) {
			try {
				java.io.File file = new java.io.File(Directory() + "/" + FilePath);
				file.mkdirs();
				return file.isDirectory();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 删除目录，返回是否删除成功（目录已删除返回true，FilePath为文件在SD卡下的相对路径）
		public static boolean DeleteDirectory(java.lang.String FilePath) {
			try {
				java.io.File file = new java.io.File(Directory() + "/" + FilePath);
				FileSystem.DeleteFileOrDirectory(file);
				return !file.isDirectory();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 获取指定目录下的文件列表（出现异常或无文件则返回null值，FilePath为文件在SD卡下的相对路径）
		public static java.io.File[] FileList(java.lang.String FilePath) {
			return new java.io.File(Directory() + "/" + FilePath).listFiles();
		}
		// 从SD卡根目录，读取字符串（出现异常则返回null值，FilePath为文件在SD卡下的相对路径）
		public static java.lang.String ReadString(java.lang.String FilePath) {
			try {
				return ReadStringFromInputStream(new java.io.FileInputStream(Directory() + "/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 从SD卡根目录，读取图片（出现异常则返回null值，FilePath为文件在SD卡下的相对路径）
		public static android.graphics.Bitmap ReadBitmap(java.lang.String FilePath) {
			try {
				return ReadBitmapFromInputStream(new java.io.FileInputStream(Directory() + "/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public static android.graphics.Bitmap ReadBitmapLowQuality(java.lang.String FilePath) {
			try {
				return ReadBitmapLowQualityFromInputStream(new java.io.FileInputStream(Directory() + "/" + FilePath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		// 从SD卡根目录，写入字符串（返回是否写入成功，FilePath为文件在SD卡下的相对路径）
		public static boolean WriteString(java.lang.String FilePath, java.lang.String Data) {
			try {
				return WriteStringToOutputStream(new java.io.FileOutputStream(Directory() + "/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		// 从SD卡根目录，写入图片（返回是否写入成功，FilePath为文件在SD卡下的相对路径）
		public static boolean WriteBitmap(java.lang.String FilePath, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapToOutputStream(new java.io.FileOutputStream(Directory() + "/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean WriteBitmapLowQuality(java.lang.String FilePath, android.graphics.Bitmap Data) {
			try {
				return WriteBitmapLowQualityToOutputStream(new java.io.FileOutputStream(Directory() + "/" + FilePath), Data);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}
