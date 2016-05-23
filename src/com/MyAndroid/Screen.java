package com.MyAndroid;

// 屏幕管理
//（动态类+静态函数库）
// 需要权限：<uses-permission android:name="android.permission.WAKE_LOCK" />
public class Screen {
	private android.app.Activity MyActivity;
	public Screen(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 屏幕宽度（像素）
	public int Width() {
		android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
		MyActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
		// return MyActivity.getResources().getDisplayMetrics().heightPixels;
	}
	// 屏幕高度（像素）
	public int Height() {
		android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
		MyActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
		// return MyActivity.getResources().getDisplayMetrics().heightPixels;
	}
	// 屏幕刷新率（Hz）
	public float RefreshRate() {
		return MyActivity.getWindowManager().getDefaultDisplay().getRefreshRate();
	}
	// 像素密度（像素和Dip单位的转换比例，例如3.0）
	public float Density() {
		return MyActivity.getResources().getDisplayMetrics().density;
	}
	// 像素密度（Dots Per Inch，每英寸的像素点个数，例如480）
	public float DPI() {
		return java.lang.Math.min(MyActivity.getResources().getDisplayMetrics().xdpi, MyActivity.getResources().getDisplayMetrics().ydpi);
	}
	// 转换像素值为Dip值（Density Independent Pixel）
	public float ConvertPxToDp(float Px) {
		return Px / Density();
	}
	// 转换Dip值为像素值（Density Independent Pixel）
	public float ConvertDpToPx(float Dp) {
		return Dp * Density();
	}
	// 屏幕保持长亮
	public void KeepScreenOn() {
		MyActivity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	// 屏幕不保持长亮
	public void NotKeepScreenOn() {
		MyActivity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	// 屏幕关闭后，保持CPU继续运转
	public void KeepCPUOn() {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) MyActivity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		MyWakeLock.acquire();
	}
	// 屏幕关闭后，保持CPU继续运转（TimeOut毫秒）
	public void KeepCPUOn(long TimeOut) {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) MyActivity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		MyWakeLock.acquire(TimeOut);
	}
	// 屏幕关闭后，不保持CPU继续运转
	public void NotKeepCPUOn() {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) MyActivity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		try {
			MyWakeLock.release();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		MyWakeLock.setReferenceCounted(false);
	}
	public static int Width(android.app.Activity Activity) {
		android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
		Activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}
	public static int Height(android.app.Activity Activity) {
		android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
		Activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}
	public static float RefreshRate(android.app.Activity Activity) {
		return Activity.getWindowManager().getDefaultDisplay().getRefreshRate();
	}
	public static float Density(android.app.Activity Activity) {
		return Activity.getResources().getDisplayMetrics().density;
	}
	public static float DPI(android.app.Activity Activity) {
		return java.lang.Math.min(Activity.getResources().getDisplayMetrics().xdpi, Activity.getResources().getDisplayMetrics().ydpi);
	}
	public static float ConvertPxToDp(android.app.Activity Activity, float Px) {
		return Px / Density(Activity);
	}
	public static float ConvertDpToPx(android.app.Activity Activity, float Dp) {
		return Dp * Density(Activity);
	}
	public static void KeepScreenOn(android.app.Activity Activity) {
		Activity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	public static void NotKeepScreenOn(android.app.Activity Activity) {
		Activity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	public static void KeepCPUOn(android.app.Activity Activity) {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) Activity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		MyWakeLock.acquire();
	}
	public static void KeepCPUOn(android.app.Activity Activity, long TimeOut) {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) Activity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		MyWakeLock.acquire(TimeOut);
	}
	public static void NotKeepCPUOn(android.app.Activity Activity) {
		android.os.PowerManager MyPowerManager = (android.os.PowerManager) Activity.getSystemService(android.content.Context.POWER_SERVICE);
		android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
		try {
			MyWakeLock.release();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		MyWakeLock.setReferenceCounted(false);
	}
}
