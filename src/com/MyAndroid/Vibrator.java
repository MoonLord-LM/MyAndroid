package com.MyAndroid;

// 震动控制
//（动态类+静态函数库）
//需要权限：<uses-permission android:name="android.permission.VIBRATE"/>
// 需要物理设备支持
public class Vibrator {
	private android.app.Activity MyActivity;
	public Vibrator(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 单次震动（参数为震动时间）
	public void Once(long milliseconds) {
		android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.vibrate(milliseconds);
		}
	}
	// 单次震动（参数为震动时间，延迟时间）
	public void Once(long milliseconds, long delay) {
		android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.vibrate(new long[] { delay, milliseconds }, -1);
		}
	}
	// 连续震动（参数为震动时间，间隔时间）
	public void Repeat(long on, long off) {
		android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.vibrate(new long[] { off, on }, 1);
		}
	}
	// 连续震动（参数为震动时间，间隔时间，重复次数）
	public void Repeat(final long on, final long off, final int repeat) {
		final android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.vibrate(new long[] { off, on }, 1);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep((on + off) * repeat);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyVibrator.cancel();
				}
			}).run();
		}
		// 等效于：
		// Repeat(on, off);
		// Cancel((on + off) * repeat);
	}
	// 连续震动（参数为震动时间，间隔时间，停止时间）
	public void Repeat(long on, long off, final long end) {
		final android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.vibrate(new long[] { off, on }, 1);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(end);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyVibrator.cancel();
				}
			}).run();
		}
		// 等效于：
		// Repeat(on, off);
		// Cancel(end);
	}
	// 停止震动
	public void Cancel() {
		android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			MyVibrator.cancel();
		}
	}
	// 停止震动（参数为延迟时间）
	public void Cancel(final long delay) {
		final android.os.Vibrator MyVibrator = (android.os.Vibrator) MyActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		if (MyVibrator.hasVibrator()) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(delay);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyVibrator.cancel();
				}
			}).run();
		}
	}
}
