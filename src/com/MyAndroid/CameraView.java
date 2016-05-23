package com.MyAndroid;

// 照相机实时预览View
//（UI组件）
//需要权限：<uses-permission android:name = "android.permission.CAMERA" /> 
//需要特性：<uses-feature android:name="android.hardware.camera" />
//需要特性：<uses-feature android:name = "android.hardware.camera.autofocus" />
public class CameraView extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback, android.hardware.Camera.PictureCallback {
	// 公开的变量
	public android.hardware.Camera MyCamera;
	public final boolean CameraFrontFaing;
	// 默认打开后置摄像头
	public CameraView(android.app.Activity activity) {
		super(activity);
		MyActivity = activity;
		this.getHolder().addCallback(this);
		CameraFrontFaing = false;
	}
	// FrontFaing为true则打开前置摄像头
	public CameraView(android.app.Activity activity, Boolean FrontFaing) {
		super(activity);
		MyActivity = activity;
		this.getHolder().addCallback(this);
		CameraFrontFaing = FrontFaing;
	}
	// 设备的可用摄像头数量
	public Integer AvailableCameraNumber() {
		return android.hardware.Camera.getNumberOfCameras();
	}
	// 创建SurfaceHolder
	@Override
	public void surfaceCreated(android.view.SurfaceHolder holder) {
		android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
		int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			android.hardware.Camera.getCameraInfo(i, cameraInfo);
			if (CameraFrontFaing == false && cameraInfo.facing == android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK) {
				MyCamera = android.hardware.Camera.open(i);
			}
			if (CameraFrontFaing == true && cameraInfo.facing == android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT) {
				MyCamera = android.hardware.Camera.open(i);
			}
		}
		if (MyCamera == null) {
			if (CameraFrontFaing == false) {
				android.util.Log.w("CameraView  @" + Integer.toHexString(hashCode()), "The device does not have a back-facing camera！");
			}
			else {
				android.util.Log.w("CameraView  @" + Integer.toHexString(hashCode()), "The device does not have a front-facing camera！");
			}
		}
		else {
			// 保证摄像头方向和屏幕方向一致
			// 实测：大部分情况下OK，90切换270时可能有颠倒的问题
			int rotation = MyActivity.getWindowManager().getDefaultDisplay().getRotation();
			int degrees = 0;
			switch (rotation) {
				case android.view.Surface.ROTATION_0:
					degrees = 0;
					break;
				case android.view.Surface.ROTATION_90:
					degrees = 90;
					break;
				case android.view.Surface.ROTATION_180:
					degrees = 180;
					break;
				case android.view.Surface.ROTATION_270:
					degrees = 270;
					break;
			}
			int result;
			if (cameraInfo.facing == android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT) {
				result = (cameraInfo.orientation + degrees) % 360;
				result = (360 - result) % 360;
			}
			else {
				result = (cameraInfo.orientation - degrees + 360) % 360;
			}
			MyCamera.setDisplayOrientation(result);
			// 设置摄像头的预览大小
			// 实测：VOTO X2前置摄像头500W像素，可预览大小范围176*144-1280*720
			int bestWidth = 0;
			int bestHeight = 0;
			android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
			MyActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
			float scale1 = (float) dm.widthPixels / (float) dm.heightPixels;
			float scale2 = (float) dm.heightPixels / (float) dm.widthPixels;
			java.util.List<android.hardware.Camera.Size> sizeList = MyCamera.getParameters().getSupportedPreviewSizes();
			if (sizeList.size() > 1) {
				java.util.Iterator<android.hardware.Camera.Size> itor = sizeList.iterator();
				while (itor.hasNext()) {
					android.hardware.Camera.Size size = itor.next();
					if (size.width > bestWidth && size.height > bestHeight) {
						float scale = (float) size.width / (float) size.height;
						if (scale == scale1 || scale == scale2) {
							bestWidth = size.width;
							bestHeight = size.height;
						}
					}
				}
				if (bestWidth != 0 && bestHeight != 0) {
					android.hardware.Camera.Parameters param = MyCamera.getParameters();
					param.setPreviewSize(bestWidth, bestHeight);
					MyCamera.setParameters(param);
				}
			}
			try {
				MyCamera.setPreviewDisplay(this.getHolder());
			}
			catch (java.io.IOException e) {
				e.printStackTrace();
				if (MyCamera != null) {
					MyCamera.stopPreview();
					MyCamera.release();
					MyCamera = null;
				}
			}
		}
	}
	// 触摸屏幕
	Boolean MouseOnTouch;
	@Override
	public boolean onTouchEvent(android.view.MotionEvent event) {
		if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {// 按下时自动对焦
			try {
				MyCamera.autoFocus(null);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			MouseOnTouch = true;
		}
		else if (event.getAction() == android.view.MotionEvent.ACTION_UP && MouseOnTouch == true) {// 放开后拍照
			try {
				MyCamera.takePicture(null, null, this);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			performClick();
			MouseOnTouch = false;
		}
		return true;
	}
	// 点击事件（onTouchEvent可能会拦截performClick，所以应该在onTouchEvent的适当地方显式地调用performClick）
	@Override
	public boolean performClick() {
		return super.performClick();
	}
	// 拍照完成
	@Override
	public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
		onPictureTaken(android.graphics.BitmapFactory.decodeByteArray(data, 0, data.length), camera);
		if (MyCamera != null) {
			MyCamera.startPreview();
		}
	}
	public void onPictureTaken(android.graphics.Bitmap bitmap, android.hardware.Camera camera) {}
	// 界面改变
	@Override
	public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) {
		if (MyCamera != null) {
			MyCamera.startPreview();
		}
	}
	// 界面销毁
	@Override
	public void surfaceDestroyed(android.view.SurfaceHolder holder) {
		if (MyCamera != null) {
			MyCamera.stopPreview();
			MyCamera.release();
			MyCamera = null;
		}
	}
	// 快速调用
	private android.app.Activity MyActivity;
	public void Show() {
		MyActivity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
		MyActivity.setContentView(this);
	}
	public static void Show(android.app.Activity activity) {
		activity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
		activity.setContentView(new CameraView(activity));
	}
	public static void Show(android.app.Activity activity, CameraView cameraView) {
		activity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
		activity.setContentView(cameraView);
	}
	// 代码示例：
	/*
	 * CameraView CV = new CameraView(this, true) {
	 * 
	 * @Override public void onPictureTaken(android.graphics.Bitmap bitmap, android.hardware.Camera camera) { android.util.Log.w("CameraView  @" + Integer.toHexString(hashCode()), "onPictureTaken"); } }; CV.Show();
	 */
}
