package com.MoonLord.MyStudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalService extends Service {
	private IBinder binder = new LocalService.LocalBinder();
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	public class LocalBinder extends Binder {
		LocalService getService() {
			return LocalService.this;
		}
	}
}
