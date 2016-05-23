package com.MyAndroid;

// 创建快捷方式
//（动态类+静态函数库）
// 需要权限：<uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
// 需要权限：<uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT"/>
// 提示：（默认程序名R.string.app_name， 默认图标R.drawable.ic_launcher）
public class ShortCut {
	private android.app.Activity MyActivity;
	public ShortCut(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	public boolean CreateOnce(int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", false);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MyActivity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, MyActivity.getClass().getSimpleName());
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(MyActivity, MyActivity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean CreateOnce(java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", false);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MyActivity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(MyActivity, MyActivity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean CreateMultiple(int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", true);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MyActivity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, MyActivity.getClass().getSimpleName());
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(MyActivity, MyActivity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean CreateMultiple(java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", true);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MyActivity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(MyActivity, MyActivity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean Delete(int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, MyActivity.getClass().getName());
			// 快捷方式的路径
			java.lang.String appClass = MyActivity.getPackageName() + "." + MyActivity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(MyActivity.getPackageName(), appClass);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean Delete(java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 快捷方式的路径
			java.lang.String appClass = MyActivity.getPackageName() + "." + MyActivity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(MyActivity.getPackageName(), appClass);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			MyActivity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean CreateOnce(android.app.Activity Activity, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", false);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(Activity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, Activity.getClass().getSimpleName());
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(Activity, Activity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean CreateOnce(android.app.Activity Activity, java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", false);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(Activity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(Activity, Activity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean CreateMultiple(android.app.Activity Activity, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", true);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(Activity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, Activity.getClass().getSimpleName());
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(Activity, Activity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean CreateMultiple(android.app.Activity Activity, java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 是否允许重复创建
			BroadcastIntent.putExtra("duplicate", true);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(Activity, ImageResourceId);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字，默认为主Activity的名称，例如MainActivity）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 点击快捷方式运行的程序
			android.content.Intent ShortCutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			ShortCutIntent.setClassName(Activity, Activity.getClass().getName());
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, ShortCutIntent);
			// 发送创建快捷方式的Broadcast
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean Delete(android.app.Activity Activity, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, Activity.getClass().getName());
			// 快捷方式的路径
			java.lang.String appClass = Activity.getPackageName() + "." + Activity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(Activity.getPackageName(), appClass);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean Delete(android.app.Activity Activity, java.lang.String ShortCutName, int ImageResourceId) {
		try {
			android.content.Intent BroadcastIntent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, java.lang.String.valueOf(ShortCutName));
			// 快捷方式的路径
			java.lang.String appClass = Activity.getPackageName() + "." + Activity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(Activity.getPackageName(), appClass);
			BroadcastIntent.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			Activity.sendBroadcast(BroadcastIntent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
