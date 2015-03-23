package com.MoonLord;

import java.lang.Thread.UncaughtExceptionHandler;

import android.os.Looper;

//处理了全局异常的Application
public class MyApplication extends android.app.Application {
	// 初始化
	@Override
	public void onCreate() {
		super.onCreate();
		defaultHandler = Thread.getDefaultUncaughtExceptionHandler(); 
		Thread.setDefaultUncaughtExceptionHandler(CrashHandler.Instance());
	}
	// 默认异常处理的Handler
	private static UncaughtExceptionHandler defaultHandler;
	// 自定义异常处理的Handler
	public static class CrashHandler implements java.lang.Thread.UncaughtExceptionHandler {
		// 必须实现的接口
		@Override
		public void uncaughtException(final Thread thread, final Throwable ex) {
			new Thread() {  
	            @Override  
	            public void run() {
	                Looper.prepare();
	                //My.Toast.Show(ex);
	                My.AlertDialog.New(ex).setCancelable(false).show();
	                Looper.loop();
	            }
	        }.start();
			try {
                Thread.sleep(5000);  
            } catch (Exception e) {  
            	e.printStackTrace();
            }
			ex.printStackTrace();
			defaultHandler.uncaughtException(thread, ex);
		}
		// 当前类的实例
		private static CrashHandler INSTANCE;
		public static CrashHandler Instance() {
			if (INSTANCE == null) {
				INSTANCE = new CrashHandler();
			}
			return INSTANCE;
		}
	}
}
