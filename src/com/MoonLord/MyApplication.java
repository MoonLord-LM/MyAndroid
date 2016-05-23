package com.MoonLord;

import java.lang.Thread.UncaughtExceptionHandler;

import com.MoonLord.MyStudy.MainActivity;
import com.MyAndroid.Memory;
import com.MyAndroid.Toast;

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
	                //Toast.Show(My.MainActivity,ex);
	                //My.AlertDialog.New("出现了全局的异常：" + "\r\n" + ex+ "\r\n" +"6秒后程序将会重启……").setCancelable(false).show();
	                Looper.loop();
	            }
	        }.start();
			try {
                Thread.sleep(6000);
            }
			catch (Exception e) {
            	e.printStackTrace();
            }
			try {
		        //My.Activity.Restart(MainActivity.class);//重新启动程序
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
			Memory.KillMyself();//结束程序
			defaultHandler.uncaughtException(thread, ex);//显示异常退出的提示（闪退）（程序已经结束就不会执行这一句了）
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
