//Android Eclipse优化设置：
//Window - Preferences - General - Workspace，将"Text file encoding"选为"Other" - "UTF-8"。
//Window -> Preferences -> General -> Content Types，将所有项的"Default encoding"选为"UTF-8"。
//Window -> Preferences -> Java -> Editor -> Content Assist，
//将Auto Activation triggers for java设置为".abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ(,"，
//将Auto Activation delay设置为"0"。
//Window -> Preferences -> Java -> Editor -> Syntax Coloring，可以修改JAVA代码和注释的默认颜色。
//Project -> Properties -> Java Code Style -> Formatter，可以设置自定义的代码格式化风格。
//格式化代码，Source -> Format。
package com.MoonLord;

/**
 * <p>
 * MyAndroid 安卓开发中文开源库
 * </p>
 * <p>
 * 版本1.0 （2015.3.23） 安卓SDK版本要求：11-21（安卓3.0-安卓5.0.1） 统一编码：UTF-8 代码：6559行
 * </p>
 * <p>
 * 使用提示：请确保项目的主Activity继承自MyActivity。 代码在Android 4.0环境下编译成功，无错误，无警告。
 * </p>
 * <p>
 * GitHub开源地址：http://github.com/MoonLord-LM/MyAndroid
 * </p>
 * <p>
 * <a href="http://www.moonlord.cn" target="_blank">MoonLord</a> 联系QQ：178910432
 * 交流QQ群：130490067
 * </p>
 * <p>
 * 技术支持：武汉大学RMC工作室 武汉大学计算机协会
 * </p>
 * <p>
 * </p>
 * */
public class My {
	// 主窗体全局静态引用
	public static MyActivity MainActivity;
	// 常用的常量
	public static class Const {
		public static final Object Null = null;
		public static final java.lang.String NewLine = "\r\n";
	}
	// 字符串函数
	public static class String {
		// ArrayList转为数组
		public static java.lang.String[] FromArrayList(java.util.ArrayList<java.lang.String> ArrayList) {
			java.lang.String[] tempStrings = new java.lang.String[ArrayList.size()];
			for (int i = 0; i < ArrayList.size(); i++) {
				tempStrings[i] = ArrayList.get(i);
			}
			return tempStrings;
		}
		// 数组转换为字符串
		public static java.lang.String FromArray(java.lang.String[] Array, java.lang.String Parameter) {
			java.lang.StringBuffer sb = new java.lang.StringBuffer("");
			if (Array.length > 0) {
				for (int i = 0; i < Array.length - 1; i++) {
					sb.append(Array[i]);
					sb.append(Parameter);
				}
				sb.append(Array[Array.length - 1]);
			}
			return sb.toString();
		}
		public static java.lang.String FromArray(java.lang.String[] Array) {
			java.lang.StringBuffer sb = new StringBuffer("");
			if (Array.length > 0) {
				for (int i = 0; i < Array.length - 1; i++) {
					sb.append(Array[i]);
					sb.append("\r\n");
				}
				sb.append(Array[Array.length - 1]);
			}
			return sb.toString();
		}
		public static java.lang.String FromArray(java.util.ArrayList<java.lang.String> Array, java.lang.String Parameter) {
			java.lang.StringBuffer sb = new StringBuffer("");
			if (Array.size() > 0) {
				for (int i = 0; i < Array.size() - 1; i++) {
					sb.append(Array.get(i));
					sb.append(Parameter);
				}
				sb.append(Array.get(Array.size() - 1));
			}
			return sb.toString();
		}
		public static java.lang.String FromArray(java.util.ArrayList<java.lang.String> Array) {
			java.lang.StringBuffer sb = new StringBuffer("");
			if (Array.size() > 0) {
				for (int i = 0; i < Array.size() - 1; i++) {
					sb.append(Array.get(i));
					sb.append("\r\n");
				}
				sb.append(Array.get(Array.size() - 1));
			}
			return sb.toString();
		}
		public static java.lang.String FromArray(java.io.File[] Array, java.lang.String Parameter) {
			java.lang.StringBuffer sb = new java.lang.StringBuffer("");
			if (Array.length > 0) {
				for (int i = 0; i < Array.length - 1; i++) {
					sb.append(Array[i].getAbsolutePath() + Array[i].getName());
					sb.append(Parameter);
				}
				sb.append(Array[Array.length - 1].getAbsolutePath() + Array[Array.length - 1].getName());
			}
			return sb.toString();
		}
		public static java.lang.String FromArray(java.io.File[] Array) {
			java.lang.StringBuffer sb = new java.lang.StringBuffer("");
			if (Array.length > 0) {
				for (int i = 0; i < Array.length - 1; i++) {
					sb.append(Array[i].getAbsolutePath() + Array[i].getName());
					sb.append("\r\n");
				}
				sb.append(Array[Array.length - 1].getAbsolutePath() + Array[Array.length - 1].getName());
			}
			return sb.toString();
		}
		// /*【 示例用法】*/
		// My.Class.XML A = new
		// My.Class.XML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><XML><Node>这是节点1</Node><Node>这是节点2</Node></XML>");
		// My.Toast.Show(My.String.FindFirst(A.Source, "<?", "?>"));
		// My.Toast.Show(My.String.FindMiddle(A.Source, "<Node>", "</Node>"));
		// My.Toast.Show(My.String.FindLast(A.Source, "<Node>", "</Node>"));
		// My.Toast.Show(My.String.FindArray(A.Source, "<Node>", "</Node>"));
		//
		// 搜索第一个Begin字符串，然后搜索第一个End字符串，截取出中间的字符串
		public static java.lang.String FindFirst(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
			if (Source == null || Begin == null || End == null) {
				return "";
			}
			// 检验
			int temp = Source.indexOf(Begin);
			if (temp == -1) {
				return "";
			}
			// 裁剪开始字符串
			Begin = Source.substring(temp + Begin.length());
			// 检验
			temp = Begin.indexOf(End);
			if (temp == -1) {
				return "";
			}
			// 裁剪结束字符串
			End = Begin.substring(0, temp);
			// 返回值
			return End;
		}
		// 搜索最后一个Begin字符串，然后搜索第一个End字符串，截取出中间的字符串
		public static java.lang.String FindLast(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
			if (Source == null || Begin == null || End == null) {
				return "";
			}
			// 检验
			int temp = Source.lastIndexOf(Begin);
			if (temp == -1) {
				return "";
			}
			// 裁剪开始字符串
			Begin = Source.substring(temp + Begin.length());
			// 检验
			temp = Begin.indexOf(End);
			if (temp == -1) {
				return "";
			}
			// 裁剪结束字符串
			End = Begin.substring(0, temp);
			// 返回值
			return End;
		}
		// 搜索第一个Begin字符串，然后搜索最后一个End字符串，截取出中间的字符串
		public static java.lang.String FindMiddle(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
			if (Source == null || Begin == null || End == null) {
				return "";
			}
			// 检验
			int temp = Source.indexOf(Begin);
			if (temp == -1) {
				return "";
			}
			// 裁剪开始字符串
			Begin = Source.substring(temp + Begin.length());
			// 检验
			temp = Begin.lastIndexOf(End);
			if (temp == -1) {
				return "";
			}
			// 裁剪结束字符串
			End = Begin.substring(0, temp);
			// 返回值
			return End;
		}
		// 依次搜索Begin字符串和End字符串，然后依次截取出中间的字符串，返回字符串数组
		public static java.lang.String[] FindArray(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
			java.util.ArrayList<java.lang.String> tempArrayList = new java.util.ArrayList<java.lang.String>();
			if (Source == null || Begin == null || End == null) {
				return new java.lang.String[0];
			}
			// 字符串复制
			java.lang.String SourceString = new java.lang.String(Source);
			// 检验
			int index = SourceString.indexOf(Begin);
			while (index != -1) {
				// 裁剪开始字符串
				SourceString = SourceString.substring(index + Begin.length());
				// 检验
				index = SourceString.indexOf(End);
				if (index != -1) {
					// 裁剪结束字符串
					tempArrayList.add(SourceString.substring(0, index));
				}
				SourceString = SourceString.substring(index + End.length());
				index = SourceString.indexOf(Begin);
			}
			return FromArrayList(tempArrayList);
		}
		public static java.util.ArrayList<java.lang.String> FindArrayList(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
			java.util.ArrayList<java.lang.String> tempArrayList = new java.util.ArrayList<java.lang.String>();
			if (Source == null || Begin == null || End == null) {
				return tempArrayList;
			}
			// 字符串复制
			java.lang.String SourceString = new java.lang.String(Source);
			// 检验
			int index = SourceString.indexOf(Begin);
			while (index != -1) {
				// 裁剪开始字符串
				SourceString = SourceString.substring(index + Begin.length());
				// 检验
				index = SourceString.indexOf(End);
				if (index != -1) {
					// 裁剪结束字符串
					tempArrayList.add(SourceString.substring(0, index));
				}
				SourceString = SourceString.substring(index + End.length());
				index = SourceString.indexOf(Begin);
			}
			return tempArrayList;
		}
	}
	// 记录信息到LogCat
	public static class LogCat {
		public static void LogVerbose(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.v("类型：String，长度：" + Message.length(), Message);
		}
		public static void LogDebug(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.d("类型：String，长度：" + Message.length(), Message);
		}
		public static void LogError(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.e("类型：String，长度：" + Message.length(), Message);
		}
		public static void LogInfo(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.i("类型：String，长度：" + Message.length(), Message);
		}
		public static void LogWarn(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.w("类型：String，长度：" + Message.length(), Message);
		}
		public static void Log(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.util.Log.v("类型：String，长度：" + Message.length(), Message);
		}
		@android.annotation.SuppressLint("NewApi")
		public static void Log(android.graphics.Bitmap Message) {
			if (My.Device.SDK() >= 12) {
				// getByteCount() requires API level 12
				android.util.Log.v("类型：Bitmap", Message.toString() + "内存占用：" + Message.getByteCount() + "高度：" + Message.getWidth() + "宽度：" + Message.getHeight());
			}
			else {
				android.util.Log.v("类型：Bitmap", Message.toString() + "高度：" + Message.getWidth() + "宽度：" + Message.getHeight());
			}
		}
		public static void Log(int Message) {
			android.util.Log.v("类型：int", java.lang.String.valueOf(Message));
		}
		public static void Log(Boolean Message) {
			android.util.Log.v("类型：Boolean", java.lang.String.valueOf(Message));
		}
		public static void Log(Object Message) {
			android.util.Log.v(Message.getClass().toString(), Message.toString());
		}
	}
	// 桌面快捷方式
	public static class ShortCut {
		// 默认程序名R.string.app_name
		// 默认图标R.drawable.ic_launcher
		public static void Create(int ImageResourceId) {
			// 需要权限：
			// <uses-permission
			// android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
			// Intent（意图）主要是解决Android应用的各项组件之间的通讯。
			android.content.Intent NewShortCut = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			// 不允许重复创建false，允许则true。
			NewShortCut.putExtra("duplicate", false);
			// 快捷方式的图标（显示在桌面的图标）
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MainActivity, ImageResourceId);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			// 快捷方式的名称（显示在桌面图标下面的文字）
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, My.Activity.ClassName);
			// 点击快捷方式运行的程序
			android.content.Intent shortcutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			shortcutIntent.setClassName(MainActivity, MainActivity.getClass().getName());
			// 下面这种写法也可以创建，但是无法用下面的删除方法删除：
			// android.content.Intent shortcutIntent = new
			// android.content.Intent(MainActivity.getApplicationContext(),MainActivity.class);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
			// 发送创建消息
			MainActivity.sendBroadcast(NewShortCut);
		}
		public static void Create(java.lang.String ShortCutName, int ImageResourceId) {
			if (ShortCutName == "") {
				ShortCutName = "";
			}
			android.content.Intent NewShortCut = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			NewShortCut.putExtra("duplicate", false);
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MainActivity, ImageResourceId);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, ShortCutName);
			android.content.Intent shortcutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			shortcutIntent.setClassName(MainActivity, MainActivity.getClass().getName());
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
			MainActivity.sendBroadcast(NewShortCut);
		}
		public static void CreateDuplicate(int ImageResourceId) {
			android.content.Intent NewShortCut = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			NewShortCut.putExtra("duplicate", true);
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MainActivity, ImageResourceId);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, My.Activity.ClassName);
			android.content.Intent shortcutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			shortcutIntent.setClassName(MainActivity, MainActivity.getClass().getName());
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
			MainActivity.sendBroadcast(NewShortCut);
		}
		public static void CreateDuplicate(java.lang.String ShortCutName, int ImageResourceId) {
			if (ShortCutName == "") {
				ShortCutName = "";
			}
			android.content.Intent NewShortCut = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			NewShortCut.putExtra("duplicate", true);
			android.content.Intent.ShortcutIconResource iconRes = android.content.Intent.ShortcutIconResource.fromContext(MainActivity, ImageResourceId);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, ShortCutName);
			android.content.Intent shortcutIntent = new android.content.Intent(android.content.Intent.ACTION_MAIN);
			shortcutIntent.setClassName(MainActivity, MainActivity.getClass().getName());
			NewShortCut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
			MainActivity.sendBroadcast(NewShortCut);
		}
		public static void Delete(int ImageResourceId) {
			// 需要权限：
			// <uses-permission
			// android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT"/>
			android.content.Intent shortcut = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			shortcut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, My.Activity.ClassName);
			// 快捷方式的路径
			java.lang.String appClass = MainActivity.getPackageName() + "." + MainActivity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(MainActivity.getPackageName(), appClass);
			shortcut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			MainActivity.sendBroadcast(shortcut);
		}
		public static void Delete(java.lang.String ShortCutName, int ImageResourceId) {
			if (ShortCutName == "") {
				ShortCutName = "";
			}
			// 需要权限：
			// <uses-permission
			// android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT"/>
			android.content.Intent shortcut = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
			// 快捷方式的名称（只会删除指定名称的所有快捷方式）
			shortcut.putExtra(android.content.Intent.EXTRA_SHORTCUT_NAME, ShortCutName);
			// 快捷方式的路径
			java.lang.String appClass = MainActivity.getPackageName() + "." + MainActivity.getLocalClassName();
			android.content.ComponentName comp = new android.content.ComponentName(MainActivity.getPackageName(), appClass);
			shortcut.putExtra(android.content.Intent.EXTRA_SHORTCUT_INTENT, new android.content.Intent(android.content.Intent.ACTION_MAIN).setComponent(comp));
			// 发送消息
			MainActivity.sendBroadcast(shortcut);
		}
	}
	// Toast输出信息
	public static class Toast {
		public static void Show(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message.toString(), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(java.lang.String[] Message) {
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), String.FromArray(Message), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(java.lang.String[] Message, java.lang.String Parameter) {
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), String.FromArray(Message, Parameter), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(java.util.ArrayList<java.lang.String> Message) {
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), String.FromArray(Message), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(java.util.ArrayList<java.lang.String> Message, java.lang.String Parameter) {
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), String.FromArray(Message, Parameter), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(Object Message) {
			android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message.toString(), android.widget.Toast.LENGTH_SHORT).show();
		}
		public static void Show(int Message) {
			Show(java.lang.String.valueOf(Message));
		}
		public static void Show(Boolean Message) {
			Show(java.lang.String.valueOf(Message));
		}
		public static void ShowCenter(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.widget.Toast toast = android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message, android.widget.Toast.LENGTH_SHORT);
			toast.setGravity(android.view.Gravity.CENTER, 0, 0);
			toast.show();
		}
		public static void ShowCenter(int Message) {
			ShowCenter(java.lang.String.valueOf(Message));
		}
		public static void ShowCenter(Boolean Message) {
			ShowCenter(java.lang.String.valueOf(Message));
		}
		public static void ShowBottom(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.widget.Toast toast = android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message, android.widget.Toast.LENGTH_SHORT);
			toast.setGravity(android.view.Gravity.BOTTOM, 0, 0);
			toast.show();
		}
		public static void ShowBottom(int Message) {
			ShowBottom(java.lang.String.valueOf(Message));
		}
		public static void ShowBottom(Boolean Message) {
			ShowBottom(java.lang.String.valueOf(Message));
		}
		public static void ShowTop(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			android.widget.Toast toast = android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message, android.widget.Toast.LENGTH_SHORT);
			toast.setGravity(android.view.Gravity.TOP, 0, 0);
			toast.show();
		}
		public static void ShowTop(int Message) {
			ShowTop(java.lang.String.valueOf(Message));
		}
		public static void ShowTop(Boolean Message) {
			ShowTop(java.lang.String.valueOf(Message));
		}
		public static void Show(java.lang.String Message, int ImageResourceId) {
			if (Message == "") {
				Message = "null";
			}
			android.widget.Toast toast = android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message, android.widget.Toast.LENGTH_LONG);
			toast.setGravity(android.view.Gravity.CENTER, 0, 0);
			android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
			android.widget.ImageView image = new android.widget.ImageView(MainActivity.getApplicationContext());
			image.setImageResource(ImageResourceId);
			image.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			toastView.addView(image, 0);
			toast.show();
		}
		public static void Show(int Message, int ImageResourceId) {
			Show(java.lang.String.valueOf(Message), ImageResourceId);
		}
		public static void Show(Boolean Message, int ImageResourceId) {
			Show(java.lang.String.valueOf(Message), ImageResourceId);
		}
		public static void Show(java.lang.String Message, int ImageResourceId, java.lang.String Title) {
			if (Message == "") {
				Message = "null";
			}
			// Toast区域大小由Message文字长度决定，Title可能会被截断。
			android.widget.Toast toast = android.widget.Toast.makeText(MainActivity.getApplicationContext(), Message, android.widget.Toast.LENGTH_LONG);
			toast.setGravity(android.view.Gravity.CENTER, 0, 0);
			android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
			android.widget.ImageView image = new android.widget.ImageView(MainActivity.getApplicationContext());
			image.setImageResource(ImageResourceId);
			image.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			android.widget.TextView text = new android.widget.TextView(MainActivity.getApplicationContext());
			text.setText(Title);
			text.setGravity(android.view.Gravity.CENTER);
			toastView.addView(text, 0);
			toastView.addView(image, 1);
			toast.show();
		}
		public static void Show(java.lang.String Message, int ImageResourceId, int Title) {
			if (Message == "") {
				Message = "null";
			}
			Show(Message, ImageResourceId, java.lang.String.valueOf(Title));
		}
		public static void Show(java.lang.String Message, int ImageResourceId, Boolean Title) {
			if (Message == "") {
				Message = "null";
			}
			Show(Message, ImageResourceId, java.lang.String.valueOf(Title));
		}
	}
	// AlertDialog输出信息
	public static class AlertDialog {
		// 实际测试：后弹出的对话框会覆盖在上面。
		// 实际测试：只有Message的AlertDialog只有一行，无法显示Icon。
		// 实际测试：Message参数会掩盖掉View、Items、SingleChoiceItems、MultiChoiceItems参数。
		public static int IconImageResourceId_info = android.R.drawable.ic_dialog_info;
		public static int IconImageResourceId_alert = android.R.drawable.ic_dialog_alert;
		public static int IconImageResourceId_email = android.R.drawable.ic_dialog_email;
		public static int IconImageResourceId_dialer = android.R.drawable.ic_dialog_dialer;
		public static int IconImageResourceId_map = android.R.drawable.ic_dialog_map;
		public static android.app.AlertDialog.Builder New(java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			return new android.app.AlertDialog.Builder(My.MainActivity).setMessage(Message);
		}
		public static android.app.AlertDialog.Builder New(Object Message) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setMessage(Message.toString());
		}
		public static android.app.AlertDialog.Builder New(java.lang.String Title, java.lang.String Message) {
			if (Message == "") {
				Message = "null";
			}
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setMessage(Message);
		}
		public static android.app.AlertDialog.Builder New(int IconImageResourceId, java.lang.String Title, java.lang.String Message) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setMessage(Message);
		}
		public static android.app.AlertDialog.Builder New(java.lang.String Title, java.lang.String Message, java.lang.String PositiveButton) {
			if (Message == "") {
				Message = "null";
			}
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setMessage(Message).setPositiveButton(PositiveButton, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder New(int IconImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setMessage(Message).setPositiveButton(PositiveButton, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder New(java.lang.String Title, java.lang.String Message, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			if (Message == "") {
				Message = "null";
			}
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setMessage(Message).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder New(int IconImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setMessage(Message).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder New(java.lang.String Title, android.view.View view, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder New(int IconImageResourceId, java.lang.String Title, android.view.View view, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder New(java.lang.String Title, android.view.View view, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder New(int IconImageResourceId, java.lang.String Title, android.view.View view, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder NewImage(java.lang.String Title, int ImageResourceId, java.lang.String PositiveButton) {
			android.widget.ImageView view = new android.widget.ImageView(MainActivity);
			view.setImageResource(ImageResourceId);
			view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder NewImage(int IconImageResourceId, java.lang.String Title, int ImageResourceId, java.lang.String PositiveButton) {
			android.widget.ImageView view = new android.widget.ImageView(MainActivity);
			view.setImageResource(ImageResourceId);
			view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder NewImage(java.lang.String Title, int ImageResourceId, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			android.widget.ImageView view = new android.widget.ImageView(MainActivity);
			view.setImageResource(ImageResourceId);
			view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder NewImage(int IconImageResourceId, java.lang.String Title, int ImageResourceId, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			android.widget.ImageView view = new android.widget.ImageView(MainActivity);
			view.setImageResource(ImageResourceId);
			view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconImageResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setView(view);
		}
		public static android.app.AlertDialog.Builder NewSingleChoice(java.lang.String Title, java.lang.String[] SingleChoice, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setSingleChoiceItems(SingleChoice, 0, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewSingleChoice(int IconResourceId, java.lang.String Title, java.lang.String[] SingleChoice, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setSingleChoiceItems(SingleChoice, 0, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewSingleChoice(java.lang.String Title, java.lang.String[] SingleChoice, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setSingleChoiceItems(SingleChoice, 0, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewSingleChoice(int IconResourceId, java.lang.String Title, java.lang.String[] SingleChoice, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setSingleChoiceItems(SingleChoice, 0, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewItems(java.lang.String Title, java.lang.String[] Items, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setItems(Items, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewItems(int IconResourceId, java.lang.String Title, java.lang.String[] Items, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setItems(Items, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewItems(java.lang.String Title, java.lang.String[] Items, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setItems(Items, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewItems(int IconResourceId, java.lang.String Title, java.lang.String[] Items, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setItems(Items, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewMultiChoice(java.lang.String Title, java.lang.String[] MultiChoice, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setMultiChoiceItems(MultiChoice, null, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewMultiChoice(int IconResourceId, java.lang.String Title, java.lang.String[] MultiChoice, java.lang.String PositiveButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setMultiChoiceItems(MultiChoice, null, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewMultiChoice(java.lang.String Title, java.lang.String[] MultiChoice, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setMultiChoiceItems(MultiChoice, null, My.MainActivity);
		}
		public static android.app.AlertDialog.Builder NewMultiChoice(int IconResourceId, java.lang.String Title, java.lang.String[] MultiChoice, java.lang.String PositiveButton, java.lang.String NegativeButton) {
			return new android.app.AlertDialog.Builder(My.MainActivity).setIcon(IconResourceId).setTitle(Title).setPositiveButton(PositiveButton, My.MainActivity).setNegativeButton(NegativeButton, My.MainActivity).setMultiChoiceItems(MultiChoice, null, My.MainActivity);
		}
	}
	// 网络数据交互
	public static class Http {
		// 需要权限：
		// <uses-permission
		// android:name="android.permission.INTERNET"></uses-permission>
		public static java.lang.String FormatGetParameter(java.lang.String UrlString) {
			// 注意：JAVA的substring函数的end参数是指截取的最后一位的下一位index
			try {
				if (UrlString.contains("?") && UrlString.contains("=")) {
					java.lang.String GetParameter = UrlString.substring(UrlString.indexOf("?") + 1);// 截取出?号之后的字符
					UrlString = UrlString.substring(0, UrlString.indexOf("?") + 1);// 截取出?号和之前的字符
					for (java.lang.String P : GetParameter.split("&")) {// 分离多个参数Key=Value组
						if (P.indexOf("=") > 0) {
							UrlString += java.net.URLEncoder.encode(P.substring(0, P.indexOf("=")), "UTF-8");// Key值的转码
							UrlString += "=";
							UrlString += java.net.URLEncoder.encode(P.substring(P.indexOf("=") + 1), "UTF-8");// Value值的转码
						}
						UrlString += "&";
					}
					UrlString = UrlString.substring(0, UrlString.length() - 1);// 删除多余的&符号
				}
				else if (UrlString.contains("?")) {
					java.lang.String GetParameter = UrlString.substring(UrlString.indexOf("?") + 1);// 截取出?号之后的字符
					UrlString = UrlString.substring(0, UrlString.indexOf("?") + 1);// 截取出?号和之前的字符
					UrlString += java.net.URLEncoder.encode(GetParameter, "UTF-8");
				}
			}
			catch (java.io.UnsupportedEncodingException e) {// 编码不支持
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return UrlString;
		}
		public static java.lang.String FormatPostParameter(java.lang.String PostParameter) {
			if (PostParameter == null || PostParameter == "") {
				return "";
			}
			try {
				if (PostParameter.contains("=")) {
					java.lang.String Temp = PostParameter;// POST参数的转码
					PostParameter = "";
					for (java.lang.String P : Temp.split("&")) {// 分离多个参数Key=Value组
						if (P.indexOf("=") > 0) {
							PostParameter += java.net.URLEncoder.encode(P.substring(0, P.indexOf("=")), "UTF-8");// Key值的转码
							PostParameter += "=";
							PostParameter += java.net.URLEncoder.encode(P.substring(P.indexOf("=") + 1), "UTF-8");// Value值的转码
						}
						PostParameter += "&";
					}
					PostParameter = PostParameter.substring(0, PostParameter.length() - 1);// 删除多余的&符号
				}
			}
			catch (java.io.UnsupportedEncodingException e) {// 编码不支持
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return PostParameter;
		}
		// 使用KeyValue传递Header信息时，需要对Key和Value的中文进行URL编码（Cookie&Referer的示例编码如下）。
		public static java.lang.String FormatCookieParameter(java.lang.String CookieString) {
			if (CookieString == null || CookieString == "") {
				return "";
			}
			try {
				if (CookieString.contains("=")) {
					java.lang.String Temp = CookieString;// POST参数的转码
					CookieString = "";
					for (java.lang.String P : Temp.split(";")) {// 分离多个参数Key=Value组
						if (P.indexOf("=") > 0) {
							CookieString += java.net.URLEncoder.encode(P.substring(0, P.indexOf("=")), "UTF-8");// Key值的转码
							CookieString += "=";
							CookieString += java.net.URLEncoder.encode(P.substring(P.indexOf("=") + 1), "UTF-8");// Value值的转码
						}
						CookieString += ";";
					}
					CookieString = CookieString.substring(0, CookieString.length() - 1);// 删除多余的&符号
				}
				else {
					CookieString = java.net.URLEncoder.encode(CookieString, "UTF-8");
				}
			}
			catch (java.io.UnsupportedEncodingException e) {// 编码不支持
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return CookieString;
		}
		public static java.lang.String FormatRefererParameter(java.lang.String RefererString) {
			// 注意：JAVA的substring函数的end参数是指截取的最后一位的下一位index
			try {
				if (RefererString.contains("?") && RefererString.contains("=")) {
					java.lang.String GetParameter = RefererString.substring(RefererString.indexOf("?") + 1);// 截取出?号之后的字符
					RefererString = RefererString.substring(0, RefererString.indexOf("?") + 1);// 截取出?号和之前的字符
					for (java.lang.String P : GetParameter.split("&")) {// 分离多个参数Key=Value组
						if (P.indexOf("=") > 0) {
							RefererString += java.net.URLEncoder.encode(P.substring(0, P.indexOf("=")), "UTF-8");// Key值的转码
							RefererString += "=";
							RefererString += java.net.URLEncoder.encode(P.substring(P.indexOf("=") + 1), "UTF-8");// Value值的转码
						}
						RefererString += "&";
					}
					RefererString = RefererString.substring(0, RefererString.length() - 1);// 删除多余的&符号
				}
				else if (RefererString.contains("?")) {
					java.lang.String GetParameter = RefererString.substring(RefererString.indexOf("?") + 1);// 截取出?号之后的字符
					RefererString = RefererString.substring(0, RefererString.indexOf("?") + 1);// 截取出?号和之前的字符
					RefererString += java.net.URLEncoder.encode(GetParameter, "UTF-8");
				}
				else {
					RefererString = java.net.URLEncoder.encode(RefererString, "UTF-8");
				}
			}
			catch (java.io.UnsupportedEncodingException e) {// 编码不支持
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return RefererString;
		}
		public static java.lang.String FormatToCookieString(java.lang.String CookieString) {
			if (CookieString == null || CookieString == "") {
				return "";
			}
			try {
				if (CookieString.contains("=")) {
					java.lang.String Temp = CookieString;// POST参数的转码
					CookieString = "";
					for (java.lang.String P : Temp.split(";")) {// 分离多个参数Key=Value组
						// My.LogCat.Log(P);
						if (P.indexOf("=") > 0) {
							CookieString += java.net.URLDecoder.decode(P.substring(0, P.indexOf("=")), "UTF-8");// Key值的转码
							CookieString += "=";
							CookieString += java.net.URLDecoder.decode(P.substring(P.indexOf("=") + 1), "UTF-8");// Value值的转码
						}
						CookieString += ";";
					}
				}
				else {
					CookieString = java.net.URLDecoder.decode(CookieString, "UTF-8");
				}
			}
			catch (java.io.UnsupportedEncodingException e) {// 编码不支持
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return CookieString;
		}
		public static My.Class.KeyValue PostParameterKeyValue(java.lang.String PostParameter) {
			My.Class.KeyValue Temp = new My.Class.KeyValue();
			if (PostParameter == null || PostParameter == "") {
				return Temp;
			}
			if (PostParameter.contains("=")) {
				for (java.lang.String P : PostParameter.split("&")) {// 分离多个参数Key=Value组
					Temp.Add(P.substring(0, P.indexOf("=")), P.substring(P.indexOf("=") + 1));
				}
			}
			else {
				Temp.Add(PostParameter, "");
			}
			return Temp;
		}
		// 各种方式，各种参数的HTTP请求和结果
		public static java.lang.String Get(java.lang.String UrlString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Get(java.lang.String UrlString, My.Class.KeyValue HeaderKeyValue) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Get(java.lang.String UrlString, java.lang.String CookieString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Get(java.lang.String UrlString, java.lang.String CookieString, java.lang.String RefererString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Post(java.lang.String UrlString, java.lang.String PostParameter) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Post(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Post(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String Post(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		// PHP的SetCookie默认只对Value进行了URL编码，必须参考下面的写法，才能保证Key和Value里面的值的中文不会乱码。
		// SetCookie(UrlEncode("Key"),"Value", time()+3600*24);
		// 本文件和所有函数都使用的UTF-8编码。
		public static java.lang.String CookieByGet(java.lang.String UrlString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByGet(java.lang.String UrlString, My.Class.KeyValue HeaderKeyValue) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByGet(java.lang.String UrlString, java.lang.String CookieString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByGet(java.lang.String UrlString, java.lang.String CookieString, java.lang.String RefererString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByPost(java.lang.String UrlString, java.lang.String PostParameter) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByPost(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByPost(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String CookieByPost(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");// 使用StringBuffer比String更高效
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.util.List<java.lang.String> cookies = urlConn.getHeaderFields().get("Set-Cookie");
				for (java.lang.String temp : cookies) {
					resultData.append(FormatToCookieString(temp.substring(0, temp.indexOf("; ") + 1)));
				}
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static android.graphics.Bitmap GetImage(java.lang.String UrlString) {
			android.graphics.Bitmap ResultImage = null;
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap GetImage(java.lang.String UrlString, java.lang.String PostParameter) {
			android.graphics.Bitmap ResultImage = null;
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap GetImage(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue) {
			android.graphics.Bitmap ResultImage = null;
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap GetImage(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString) {
			android.graphics.Bitmap ResultImage = null;
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap GetImage(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString) {
			android.graphics.Bitmap ResultImage = null;
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static boolean DownLoad(java.lang.String UrlString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoad(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoadToSDCard(java.lang.String UrlString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(My.IO.SDCard.Directory + "/" + fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoadToSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(My.IO.SDCard.Directory + "/" + fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoadToSDCard(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(My.IO.SDCard.Directory + "/" + fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoadToSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(My.IO.SDCard.Directory + "/" + fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean DownLoadToSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString, java.lang.String fileName) {
			// 实测结果，新下载的文件的会替换掉之前可能已存在的文件。
			try {
				UrlString = FormatGetParameter(UrlString);
				PostParameter = FormatPostParameter(PostParameter);
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// POST方式必需
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				urlConn.connect();
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());
				out.writeBytes(PostParameter);
				out.flush();
				out.close();
				java.io.InputStream in = urlConn.getInputStream();// 新建IO对象
				java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(My.IO.SDCard.Directory + "/" + fileName));// 文件流
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = in.read(bytes)) != -1) {// 读取并判断是否为文件尾
					fos.write(bytes, 0, length);// 写入文件
				}
				fos.close();
				in.close();
				urlConn.disconnect();
				return true;
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
				sb1.append("--" + BoundaryString + "\r\n");
				sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + new java.io.File(fileName).getName() + "\"" + "\r\n");
				sb1.append("Content-Type: application/octet-stream" + "\r\n");
				sb1.append("\r\n");
				out.write(sb1.toString().getBytes());// 写入到输出流中
				java.io.InputStream fis = new java.io.FileInputStream(fileName);// 将文件读入输入流中
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = fis.read(bytes)) != -1) {
					out.write(bytes, 0, length);// 写入到输出流中
				}
				fis.close();
				out.write("\r\n".getBytes());// 添加换行
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\"; filename=\"" + new java.io.File(fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\"; filename=\"" + new java.io.File(fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\"; filename=\"" + new java.io.File(fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\"; filename=\"" + new java.io.File(fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoad(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\"; filename=\"" + new java.io.File(fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
				sb1.append("--" + BoundaryString + "\r\n");
				sb1.append("Content-Disposition: form-data; name=\"file\";");
				sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileName).getName() + "\"" + "\r\n");
				sb1.append("Content-Type: application/octet-stream" + "\r\n");
				sb1.append("\r\n");
				out.write(sb1.toString().getBytes());// 写入到输出流中
				java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileName);// 将文件读入输入流中
				byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
				int length = 0; // 读取到的实际字节
				while ((length = fis.read(bytes)) != -1) {
					out.write(bytes, 0, length);// 写入到输出流中
				}
				fis.close();
				out.write("\r\n".getBytes());// 添加换行
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\";");
					sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\";");
					sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				for (int i = 0; i < HeaderKeyValue.Length; i++) {
					urlConn.setRequestProperty(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\";");
					sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\";");
					sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		public static java.lang.String UpLoadSDCard(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString, java.lang.String[] fileName) {
			java.lang.StringBuffer resultData = new java.lang.StringBuffer("");
			try {
				UrlString = FormatGetParameter(UrlString);
				java.lang.String BoundaryString = My.Maths.UniversallyUniqueIdentifier();
				java.net.URL url = new java.net.URL(UrlString);// 新建URL对象
				java.net.HttpURLConnection urlConn = (java.net.HttpURLConnection) url.openConnection();// 新建网络连接对象
				urlConn.setRequestMethod("POST");
				urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BoundaryString);
				urlConn.setRequestProperty("Cookie", FormatCookieParameter(CookieString));
				urlConn.setRequestProperty("Referer", FormatRefererParameter(RefererString));
				java.io.DataOutputStream out = new java.io.DataOutputStream(urlConn.getOutputStream());// 输出对象
				for (java.lang.String fileNameString : fileName) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"file[]\";");
					sb1.append("filename=\"" + new java.io.File(My.IO.SDCard.Directory + "/" + fileNameString).getName() + "\"" + "\r\n");
					sb1.append("Content-Type: application/octet-stream" + "\r\n");
					sb1.append("\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
					java.io.InputStream fis = new java.io.FileInputStream(My.IO.SDCard.Directory + "/" + fileNameString);// 将文件读入输入流中
					byte[] bytes = new byte[4 * 1024];// 缓冲区（4KB）
					int length = 0; // 读取到的实际字节
					while ((length = fis.read(bytes)) != -1) {
						out.write(bytes, 0, length);// 写入到输出流中
					}
					fis.close();
					out.write("\r\n".getBytes());// 添加换行
				}
				My.Class.KeyValue PostKeyValue = PostParameterKeyValue(PostParameter);
				for (int i = 0; i < PostKeyValue.Length; i++) {
					java.lang.StringBuilder sb1 = new java.lang.StringBuilder();// 构建发送字符串数据
					sb1.append("--" + BoundaryString + "\r\n");
					sb1.append("Content-Disposition: form-data; name=\"" + PostKeyValue.GetKey(i) + "\"\r\n");
					sb1.append("\r\n");
					sb1.append(PostKeyValue.GetValue(i) + "\r\n");
					out.write(sb1.toString().getBytes());// 写入到输出流中
				}
				out.write(("--" + BoundaryString + "--" + "\r\n").getBytes());// 添加尾部字符串
				out.flush();// 刷新发送数据
				out.close();
				java.io.InputStreamReader in = new java.io.InputStreamReader(urlConn.getInputStream());// 新建IO对象
				if (urlConn.getContentLength() != -1) {// 响应头部返回了流的长度
					char[] buffer = new char[urlConn.getContentLength()];
					in.read(buffer, 0, buffer.length);
					resultData.append(buffer);
				}
				else {// 流的长度未知
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);// 输出流
					java.lang.String inputLine = null;
					while (((inputLine = buffer.readLine()) != null))// 使用循环来读取获得的数据
					{
						resultData.append(inputLine + "\r\n");
					}
				}
				in.close();
				urlConn.disconnect();
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (java.io.FileNotFoundException e) {// 文件夹不存在
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return resultData.toString();
		}
		// 所有Client操作使用同一个静态私有的MyClient，MyClient在外部可以用Client()访问。
		private static org.apache.http.client.HttpClient MyClient;
		public static org.apache.http.client.HttpClient Client() {
			if (MyClient == null) {
				org.apache.http.params.BasicHttpParams httpParams = new org.apache.http.params.BasicHttpParams();// 网络连接超时参数
				org.apache.http.params.HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
				org.apache.http.params.HttpConnectionParams.setSoTimeout(httpParams, 30000);
				MyClient = new org.apache.http.impl.client.DefaultHttpClient(httpParams);
			}
			return MyClient;
		}
		public static java.lang.String ClientGet(java.lang.String UrlString) {
			java.lang.String strResult = "";
			try {
				org.apache.http.client.methods.HttpGet httpRequest = new org.apache.http.client.methods.HttpGet(UrlString);// GET参数
				org.apache.http.HttpResponse httpResponse = Client().execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
					strResult = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
				}
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
		public static java.lang.String ClientPost(java.lang.String UrlString, java.lang.String PostParameter) {
			java.lang.String strResult = "";
			try {
				// POST参数从字符串转换到ArrayList
				java.util.List<org.apache.http.NameValuePair> params = new java.util.ArrayList<org.apache.http.NameValuePair>();
				for (java.lang.String P : PostParameter.split("&")) {
					params.add(new org.apache.http.message.BasicNameValuePair(P.substring(0, P.indexOf("=")), P.substring(P.indexOf("=") + 1)));
				}
				org.apache.http.HttpEntity httpentity = new org.apache.http.client.entity.UrlEncodedFormEntity(params, "UTF-8");
				org.apache.http.client.methods.HttpPost httpRequest = new org.apache.http.client.methods.HttpPost(UrlString);// GET参数
				httpRequest.setEntity(httpentity);// POST参数
				org.apache.http.HttpResponse httpResponse = Client().execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
					strResult = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
				}
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
		public static java.lang.String ClientPost(java.lang.String UrlString, java.lang.String PostParameter, My.Class.KeyValue HeaderKeyValue) {
			java.lang.String strResult = "";
			try {
				// POST参数从字符串转换到ArrayList
				java.util.List<org.apache.http.NameValuePair> params = new java.util.ArrayList<org.apache.http.NameValuePair>();
				for (java.lang.String P : PostParameter.split("&")) {
					params.add(new org.apache.http.message.BasicNameValuePair(P.substring(0, P.indexOf("=")), P.substring(P.indexOf("=") + 1)));
				}
				org.apache.http.HttpEntity httpentity = new org.apache.http.client.entity.UrlEncodedFormEntity(params, "UTF-8");
				org.apache.http.client.methods.HttpPost httpRequest = new org.apache.http.client.methods.HttpPost(UrlString);// GET参数
				for (int i = 0; i < HeaderKeyValue.Length; i++) {// Header参数
					httpRequest.addHeader(HeaderKeyValue.GetKey(i), HeaderKeyValue.GetValue(i));
				}
				httpRequest.setEntity(httpentity);// POST参数
				org.apache.http.HttpResponse httpResponse = Client().execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
					strResult = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
				}
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
		public static java.lang.String ClientPost(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString) {
			java.lang.String strResult = "";
			try {
				// POST参数从字符串转换到ArrayList
				java.util.List<org.apache.http.NameValuePair> params = new java.util.ArrayList<org.apache.http.NameValuePair>();
				for (java.lang.String P : PostParameter.split("&")) {
					params.add(new org.apache.http.message.BasicNameValuePair(P.substring(0, P.indexOf("=")), P.substring(P.indexOf("=") + 1)));
				}
				org.apache.http.HttpEntity httpentity = new org.apache.http.client.entity.UrlEncodedFormEntity(params, "UTF-8");
				org.apache.http.client.methods.HttpPost httpRequest = new org.apache.http.client.methods.HttpPost(UrlString);// GET参数
				httpRequest.addHeader("Cookie", FormatCookieParameter(CookieString));
				httpRequest.setEntity(httpentity);// POST参数
				org.apache.http.HttpResponse httpResponse = Client().execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
					strResult = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
				}
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
		public static java.lang.String ClientPost(java.lang.String UrlString, java.lang.String PostParameter, java.lang.String CookieString, java.lang.String RefererString) {
			java.lang.String strResult = "";
			try {
				// POST参数从字符串转换到ArrayList
				java.util.List<org.apache.http.NameValuePair> params = new java.util.ArrayList<org.apache.http.NameValuePair>();
				for (java.lang.String P : PostParameter.split("&")) {
					params.add(new org.apache.http.message.BasicNameValuePair(P.substring(0, P.indexOf("=")), P.substring(P.indexOf("=") + 1)));
				}
				org.apache.http.HttpEntity httpentity = new org.apache.http.client.entity.UrlEncodedFormEntity(params, "UTF-8");
				org.apache.http.client.methods.HttpPost httpRequest = new org.apache.http.client.methods.HttpPost(UrlString);// GET参数
				httpRequest.addHeader("Cookie", FormatCookieParameter(CookieString));
				httpRequest.addHeader("Referer", FormatRefererParameter(RefererString));
				httpRequest.setEntity(httpentity);// POST参数
				org.apache.http.HttpResponse httpResponse = Client().execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
					strResult = org.apache.http.util.EntityUtils.toString(httpResponse.getEntity());
				}
			}
			catch (java.net.UnknownHostException e) {// 未连接网络
				e.printStackTrace();
			}
			catch (android.os.NetworkOnMainThreadException e) {// UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
	}
	// 数学计算
	public static class Maths {
		private static java.lang.String LastUUID;
		public static java.lang.String LastUniversallyUniqueIdentifier() {
			if (LastUUID == null) {
				UniversallyUniqueIdentifier();
			}
			return LastUUID;
		}
		public static java.lang.String UniversallyUniqueIdentifier() {
			// Log(java.util.UUID.randomUUID().toString());
			// 对在同一时空中的所有机器都是唯一的。
			// 36字节
			LastUUID = java.util.UUID.randomUUID().toString();
			return LastUUID;
		}
		public static int Random(int Min, int Max) {
			// 随机数
			return (int) Math.round(Math.random() * (Max - Min) + Min);
		}
		public static int RandomColor() {
			// 随机颜色
			java.util.Random random = new java.util.Random();
			int r = random.nextInt(256);
			int g = random.nextInt(256);
			int b = random.nextInt(256);
			return android.graphics.Color.rgb(r, g, b);
		}
		public static int RandomAlphaColor() {
			java.util.Random random = new java.util.Random();
			int a = random.nextInt(256);
			int r = random.nextInt(256);
			int g = random.nextInt(256);
			int b = random.nextInt(256);
			return android.graphics.Color.argb(a, r, g, b);
		}
		public static class SmoothChangeColor {
			public static int LastColor;// 上一次输出的颜色
			public static int RedSpeed = 2;// 颜色分量的变化速度
			public static int GreenSpeed = 3;
			public static int BlueSpeed = 5;
			// 输出一个颜色连贯的新颜色
			public static int NewColor() {
				if (LastColor == 0) {// 首次运行时生成随机颜色
					LastColor = RandomColor();
					return LastColor;
				}
				int NowColor = LastColor;
				int r = android.graphics.Color.red(NowColor) + RedSpeed;
				int g = android.graphics.Color.green(NowColor) + GreenSpeed;
				int b = android.graphics.Color.blue(NowColor) + BlueSpeed;
				if (r > 255) {
					r = 255;
					RedSpeed = -RedSpeed;
				}
				if (g > 255) {
					g = 255;
					GreenSpeed = -GreenSpeed;
				}
				if (b > 255) {
					b = 255;
					BlueSpeed = -BlueSpeed;
				}
				if (r < 0) {
					r = 0;
					RedSpeed = -RedSpeed;
				}
				if (g < 0) {
					g = 0;
					GreenSpeed = -GreenSpeed;
				}
				if (b < 0) {
					b = 0;
					BlueSpeed = -BlueSpeed;
				}
				LastColor = android.graphics.Color.rgb(r, g, b);
				return LastColor;
			}
		}
		public static class SmoothChangeAlphaColor {
			public static int LastColor;// 上一次输出的颜色
			public static int AlphaSpeed = 2;// 颜色分量的变化速度
			public static int RedSpeed = 3;
			public static int GreenSpeed = 5;
			public static int BlueSpeed = 7;
			// 输出一个颜色连贯的新颜色
			public static int NewColor() {
				if (LastColor == 0) {// 首次运行时生成随机颜色
					LastColor = RandomAlphaColor();
					return LastColor;
				}
				int NowColor = LastColor;
				int a = android.graphics.Color.alpha(NowColor) + AlphaSpeed;
				int r = android.graphics.Color.red(NowColor) + RedSpeed;
				int g = android.graphics.Color.green(NowColor) + GreenSpeed;
				int b = android.graphics.Color.blue(NowColor) + BlueSpeed;
				if (a > 255) {
					a = 255;
					AlphaSpeed = -AlphaSpeed;
				}// 防止溢出
				if (r > 255) {
					r = 255;
					RedSpeed = -RedSpeed;
				}
				if (g > 255) {
					g = 255;
					GreenSpeed = -GreenSpeed;
				}
				if (b > 255) {
					b = 255;
					BlueSpeed = -BlueSpeed;
				}
				if (a < 0) {
					a = 0;
					AlphaSpeed = -AlphaSpeed;
				}
				if (r < 0) {
					r = 0;
					RedSpeed = -RedSpeed;
				}
				if (g < 0) {
					g = 0;
					GreenSpeed = -GreenSpeed;
				}
				if (b < 0) {
					b = 0;
					BlueSpeed = -BlueSpeed;
				}
				LastColor = android.graphics.Color.argb(a, r, g, b);
				return LastColor;
			}
		}
		public static class SmoothChangeLightColor {
			public static int Red;// 上一次输出的颜色分量
			public static int Green;
			public static int Blue;
			public static int ZeroColor;// 当前保持为0的颜色分量（枚举1、2、3，代表R、G、B。）
			public static int ChangeColor;// 当前变化的颜色分量（枚举1、2、3，代表R、G、B。）
			public static int FullColor;// 当前保持为255的颜色分量（枚举1、2、3，代表R、G、B。）
			public static int MinLevel = 55;// 颜色分量的最低值（为0时产生标准纯色，值越高，颜色越亮，颜色变化幅度也越小）
			public static int MaxLevel = 255;// 颜色分量的最高值
			public static int Speed = 2;// 颜色分量每次改变的值
			public static int LastColor;// 上一次输出的颜色
			// 输出一个颜色连贯的新颜色，并且保证色彩的鲜艳（RGB值的最大差值为255）
			// 实测结果为：颜色变化顺序按照七色光的顺序依次渐变。
			public static int NewColor() {
				if (LastColor == 0) {
					return Initialize();
				}
				switch (ChangeColor) {// 颜色分量的连贯变化
					case 1:
						Red += Speed;
						break;
					case 2:
						Green += Speed;
						break;
					case 3:
						Blue += Speed;
						break;
				}
				if (Red > MaxLevel) {
					Red = MaxLevel;
					Speed = -Speed;
					SwapFullColor();
				}
				if (Green > MaxLevel) {
					Green = MaxLevel;
					Speed = -Speed;
					SwapFullColor();
				}
				if (Blue > MaxLevel) {
					Blue = MaxLevel;
					Speed = -Speed;
					SwapFullColor();
				}
				if (Red < MinLevel) {
					Red = MinLevel;
					Speed = -Speed;
					SwapZeroColor();
				}
				if (Green < MinLevel) {
					Green = MinLevel;
					Speed = -Speed;
					SwapZeroColor();
				}
				if (Blue < MinLevel) {
					Blue = MinLevel;
					Speed = -Speed;
					SwapZeroColor();
				}
				LastColor = android.graphics.Color.rgb(Red, Green, Blue);
				return LastColor;
			}
			// 首次运行时生成随机的鲜艳颜色
			public static int Initialize() {
				Red = Random(MinLevel + 1, MaxLevel);
				Green = Random(MinLevel + 1, MaxLevel);
				Blue = Random(MinLevel + 1, MaxLevel);
				if (Red < Green) {
					if (Red < Blue) {
						if (Green < Blue) {// 从小到大排列R、G、B
							ZeroColor = 1;
							ChangeColor = 2;
							FullColor = 3;
						}
						else {// 从小到大排列R、B、G
							ZeroColor = 1;
							ChangeColor = 3;
							FullColor = 2;
						}
					}
					else {// 从小到大排列B、R、G
						ZeroColor = 3;
						ChangeColor = 1;
						FullColor = 2;
					}
				}
				else {
					if (Green < Blue) {
						if (Red < Blue) {// 从小到大排列G、R、B
							ZeroColor = 2;
							ChangeColor = 1;
							FullColor = 3;
						}
						else {// 从小到大排列G、B、R
							ZeroColor = 2;
							ChangeColor = 3;
							FullColor = 1;
						}
					}// 从小到大排列B、G、R
					else {
						ZeroColor = 3;
						ChangeColor = 2;
						FullColor = 1;
					}
				}
				switch (ZeroColor) {// 将最小的值赋值为0
					case 1:
						Red = MinLevel;
						break;
					case 2:
						Green = MinLevel;
						break;
					case 3:
						Blue = MinLevel;
						break;
				}
				switch (FullColor) {// 将最大的值赋值为255
					case 1:
						Red = MaxLevel;
						break;
					case 2:
						Green = MaxLevel;
						break;
					case 3:
						Blue = MaxLevel;
						break;
				}
				LastColor = android.graphics.Color.rgb(Red, Green, Blue);
				return LastColor;
			}
			// 交换ChangeColor和FullColor的值
			public static void SwapFullColor() {
				ChangeColor = ChangeColor ^ FullColor;
				FullColor = ChangeColor ^ FullColor;
				ChangeColor = ChangeColor ^ FullColor;
			}
			// 交换ChangeColor和ZeroColor的值
			public static void SwapZeroColor() {
				ChangeColor = ChangeColor ^ ZeroColor;
				ZeroColor = ChangeColor ^ ZeroColor;
				ChangeColor = ChangeColor ^ ZeroColor;
			}
		}
	}
	// 自定义数据结构
	public static class Class {
		// /*【 示例用法】*/
		// My.Class.KeyValue A = new My.Class.KeyValue("123","456");
		// A.SetKeyUnique(true);
		// A.Add("120","120");
		//
		// My.Class.KeyValue B = new My.Class.KeyValue(A);
		// B.SetKeyAndValueUnique(true);
		// B.Add("123","789");
		// B.Add("120","111");
		// B.Add("123","000");
		// My.Toast.Show(A.IsKeyAndValueUnique());
		// My.Toast.Show(B.IsKeyUnique());
		//
		// KeyValue键值动态数组
		public static class KeyValue {
			//
			// 成员变量
			private java.util.ArrayList<java.lang.String> Key = new java.util.ArrayList<java.lang.String>();
			private java.util.ArrayList<java.lang.String> Value = new java.util.ArrayList<java.lang.String>();
			private int Length = 0;
			private boolean KeyUnique = false;// 键唯一
			private boolean ValueUnique = false;// 值唯一
			private boolean KeyAndValueUnique = false;// 键值组合唯一
			//
			// 构造函数
			public KeyValue() {}
			public KeyValue(java.lang.String KeyString, java.lang.String ValueString) {
				Add(KeyString, ValueString);
			}
			public KeyValue(KeyValue KeyValueInstance) {
				// 直接Key =KeyValueInstance.Key;赋值会导致两个KeyValue关联到一起。
				// Key =KeyValueInstance.Key;
				// Value =KeyValueInstance.Value;
				Key = new java.util.ArrayList<java.lang.String>(KeyValueInstance.Key);
				Value = new java.util.ArrayList<java.lang.String>(KeyValueInstance.Value);
				Length = KeyValueInstance.Length;
				SetKeyUnique(KeyValueInstance.KeyUnique);
				SetValueUnique(KeyValueInstance.ValueUnique);
				SetKeyAndValueUnique(KeyValueInstance.KeyAndValueUnique);
			}
			//
			// 读取内部成员（只读不修改）
			public int Length() {
				return Length;
			}
			public int Size() {
				return Length;
			}
			public boolean IsKeyUnique() {
				return KeyUnique;
			}
			public boolean IsValueUnique() {
				return ValueUnique;
			}
			public boolean IsKeyAndValueUnique() {
				return KeyAndValueUnique;
			}
			public java.lang.String[] KeyToArray() {
				Object[] tempObjects = Key.toArray();
				java.lang.String[] tempStrings = new java.lang.String[tempObjects.length];
				for (int i = 0; i < tempStrings.length; i++) {
					tempStrings[i] = tempObjects[i].toString();
				}
				return tempStrings;
			}
			public java.lang.String[] ValueToArray() {
				Object[] tempObjects = Value.toArray();
				java.lang.String[] tempStrings = new java.lang.String[tempObjects.length];
				for (int i = 0; i < tempStrings.length; i++) {
					tempStrings[i] = tempObjects[i].toString();
				}
				return tempStrings;
			}
			// Key或Value转化为List的接口实现
			// List是可以重复的集合，转化后信息无损失
			public java.util.ArrayList<java.lang.String> KeyToArrayList() {
				return new java.util.ArrayList<java.lang.String>(Key);
			}
			public java.util.ArrayList<java.lang.String> ValueToArrayList() {
				return new java.util.ArrayList<java.lang.String>(Value);
			}
			public java.util.LinkedList<java.lang.String> KeyToLinkedList() {
				return new java.util.LinkedList<java.lang.String>(Key);
			}
			public java.util.LinkedList<java.lang.String> ValueToLinkedList() {
				return new java.util.LinkedList<java.lang.String>(Value);
			}
			public java.util.Vector<java.lang.String> KeyToVector() {
				return new java.util.Vector<java.lang.String>(Key);
			}
			public java.util.Vector<java.lang.String> ValueToVector() {
				return new java.util.Vector<java.lang.String>(Value);
			}
			// Key或Value转化为Set和SortedSet的接口实现
			// Set是不可重复的集合，转化后可能会有损失
			public java.util.HashSet<java.lang.String> KeyToHashSet() {
				return new java.util.HashSet<java.lang.String>(Key);
			}
			public java.util.HashSet<java.lang.String> ValueToHashSet() {
				return new java.util.HashSet<java.lang.String>(Value);
			}
			public java.util.LinkedHashSet<java.lang.String> KeyToLinkedHashSet() {
				return new java.util.LinkedHashSet<java.lang.String>(Key);
			}
			public java.util.LinkedHashSet<java.lang.String> ValueToLinkedHashSet() {
				return new java.util.LinkedHashSet<java.lang.String>(Value);
			}
			public java.util.TreeSet<java.lang.String> KeyToTreeSet() {
				return new java.util.TreeSet<java.lang.String>(Key);
			}
			public java.util.TreeSet<java.lang.String> ValueToTreeSet() {
				return new java.util.TreeSet<java.lang.String>(Value);
			}
			// Key和Value一起转化为Map和SortedMap的接口实现
			// Map是一对多的关系，故Map的size()函数返回的是不重复的Key的数量
			public java.util.HashMap<java.lang.String, java.lang.String> ToHashMap() {
				java.util.HashMap<java.lang.String, java.lang.String> tempHashMap = new java.util.HashMap<java.lang.String, java.lang.String>();
				for (int i = 0; i < Length; i++) {
					tempHashMap.put(Key.get(i), Value.get(i));
				}
				return tempHashMap;
			}
			public java.util.Hashtable<java.lang.String, java.lang.String> ToHashtable() {
				java.util.Hashtable<java.lang.String, java.lang.String> tempHashtable = new java.util.Hashtable<java.lang.String, java.lang.String>();
				for (int i = 0; i < Length; i++) {
					tempHashtable.put(Key.get(i), Value.get(i));
				}
				return tempHashtable;
			}
			public java.util.LinkedHashMap<java.lang.String, java.lang.String> ToLinkedHashMap() {
				java.util.LinkedHashMap<java.lang.String, java.lang.String> tempLinkedHashMap = new java.util.LinkedHashMap<java.lang.String, java.lang.String>();
				for (int i = 0; i < Length; i++) {
					tempLinkedHashMap.put(Key.get(i), Value.get(i));
				}
				return tempLinkedHashMap;
			}
			public java.util.TreeMap<java.lang.String, java.lang.String> ToTreeMap() {
				java.util.TreeMap<java.lang.String, java.lang.String> tempTreeMap = new java.util.TreeMap<java.lang.String, java.lang.String>();
				for (int i = 0; i < Length; i++) {
					tempTreeMap.put(Key.get(i), Value.get(i));
				}
				return tempTreeMap;
			}
			//
			// 判断是否存在
			public boolean HasKey(java.lang.String KeyString) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString) {
						return true;
					}
				}
				return false;
			}
			public boolean HasValue(java.lang.String ValueString) {
				for (int i = 0; i < Length; i++) {
					if (Value.get(i) == ValueString) {
						return true;
					}
				}
				return false;
			}
			public boolean HasKeyAndValue(java.lang.String KeyString, java.lang.String ValueString) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString && Value.get(i) == ValueString) {
						return true;
					}
				}
				return false;
			}
			//
			// 获取值（字符串准确相等）
			public java.lang.String[] Get(int index) {
				return new java.lang.String[] { Key.get(index), Value.get(index) };
			}
			public java.lang.String GetKey(int index) {
				return Key.get(index);
			}
			public java.lang.String GetValue(int index) {
				return Value.get(index);
			}
			public java.lang.String[] GetKey(java.lang.String ValueString) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Value.get(i) == ValueString) {
						tempArrayList.add(i);
					}
				}
				java.lang.String[] temp = new java.lang.String[tempArrayList.size()];
				for (int i = 0; i < tempArrayList.size(); i++) {
					temp[i] = Key.get(i);
				}
				return temp;
			}
			public java.lang.String[] GetValue(java.lang.String KeyString) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString) {
						tempArrayList.add(i);
					}
				}
				java.lang.String[] temp = new java.lang.String[tempArrayList.size()];
				for (int i = 0; i < tempArrayList.size(); i++) {
					temp[i] = Value.get(i);
				}
				return temp;
			}
			public java.lang.String GetFirstKey(java.lang.String ValueString) {
				for (int i = 0; i < Length; i++) {
					if (Value.get(i) == ValueString) {
						return Key.get(i);
					}
				}
				return "";
			}
			public java.lang.String GetFirstValue(java.lang.String KeyString) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString) {
						return Value.get(i);
					}
				}
				return "";
			}
			public java.lang.String GetLastKey(java.lang.String ValueString) {
				for (int i = Length - 1; i > -1; i--) {
					if (Value.get(i) == ValueString) {
						return Key.get(i);
					}
				}
				return "";
			}
			public java.lang.String GetLastValue(java.lang.String KeyString) {
				for (int i = Length - 1; i > -1; i--) {
					if (Key.get(i) == KeyString) {
						return Value.get(i);
					}
				}
				return "";
			}
			public int GetFirstKeyIndex(java.lang.String KeyString) {
				return Key.indexOf(KeyString);
			}
			public int GetFirstValueIndex(java.lang.String ValueString) {
				return Value.indexOf(ValueString);
			}
			public int[] GetKeyIndex(java.lang.String KeyString) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString) {
						tempArrayList.add(i);
					}
				}
				// ArrayList转数组
				int[] temp = new int[tempArrayList.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = tempArrayList.get(i);
				}
				return temp;
			}
			public int[] GetValueIndex(java.lang.String ValueString) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Value.get(i) == ValueString) {
						tempArrayList.add(i);
					}
				}
				// ArrayList转数组
				int[] temp = new int[tempArrayList.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = tempArrayList.get(i);
				}
				return temp;
			}
			//
			// 模糊搜索值（字符串包含）
			public java.lang.String[] SearchKey(java.lang.String ValueWord) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Value.get(i).contains(ValueWord)) {
						tempArrayList.add(i);
					}
				}
				java.lang.String[] temp = new java.lang.String[tempArrayList.size()];
				for (int i = 0; i < tempArrayList.size(); i++) {
					temp[i] = Key.get(i);
				}
				return temp;
			}
			public java.lang.String[] SearchValue(java.lang.String KeyWord) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Key.get(i).contains(KeyWord)) {
						tempArrayList.add(i);
					}
				}
				java.lang.String[] temp = new java.lang.String[tempArrayList.size()];
				for (int i = 0; i < tempArrayList.size(); i++) {
					temp[i] = Value.get(i);
				}
				return temp;
			}
			public java.lang.String SearchFirstKey(java.lang.String ValueWord) {
				for (int i = 0; i < Length; i++) {
					if (Value.get(i).contains(ValueWord)) {
						return Key.get(i);
					}
				}
				return "";
			}
			public java.lang.String SearchFirstValue(java.lang.String KeyWord) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i).contains(KeyWord)) {
						return Value.get(i);
					}
				}
				return "";
			}
			public java.lang.String SearchLastKey(java.lang.String ValueWord) {
				for (int i = Length - 1; i > -1; i--) {
					if (Value.get(i).contains(ValueWord)) {
						return Key.get(i);
					}
				}
				return "";
			}
			public java.lang.String SearchLastValue(java.lang.String KeyWord) {
				for (int i = Length - 1; i > -1; i--) {
					if (Key.get(i).contains(KeyWord)) {
						return Value.get(i);
					}
				}
				return "";
			}
			public int SearchFirstKeyIndex(java.lang.String KeyWord) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i).contains(KeyWord)) {
						return i;
					}
				}
				return -1;
			}
			public int SearchFirstValueIndex(java.lang.String ValueWord) {
				for (int i = 0; i < Length; i++) {
					if (Value.get(i).contains(ValueWord)) {
						return i;
					}
				}
				return -1;
			}
			public int[] SearchKeyIndex(java.lang.String KeyWord) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Key.get(i).contains(KeyWord)) {
						tempArrayList.add(i);
					}
				}
				// ArrayList转数组
				int[] temp = new int[tempArrayList.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = tempArrayList.get(i);
				}
				return temp;
			}
			public int[] SearchValueIndex(java.lang.String ValueWord) {
				java.util.ArrayList<Integer> tempArrayList = new java.util.ArrayList<Integer>();
				for (int i = 0; i < Length; i++) {
					if (Value.get(i).contains(ValueWord)) {
						tempArrayList.add(i);
					}
				}
				// ArrayList转数组
				int[] temp = new int[tempArrayList.size()];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = tempArrayList.get(i);
				}
				return temp;
			}
			//
			// 添加（返回是否添加成功）
			public boolean Add(java.lang.String KeyString, java.lang.String ValueString) {
				if (KeyUnique && HasKey(KeyString)) {
					return false;
				}
				if (ValueUnique && HasValue(ValueString)) {
					return false;
				}
				if (KeyAndValueUnique && HasKeyAndValue(KeyString, ValueString)) {
					return false;
				}
				Key.add(KeyString);
				Value.add(ValueString);
				Length = Length + 1;
				return true;
			}
			//
			// 删除（返回是否删除成功，或删除元素的数量）
			public boolean Delete(int index) {
				try {
					Key.remove(index);
					Value.remove(index);
					Length = Length - 1;
					return true;
				}
				catch (Exception e) {
					return false;
				}
			}
			public boolean DeleteFirstKey(java.lang.String KeyString) {
				try {
					int index = Key.indexOf(KeyString);
					Key.remove(index);
					Value.remove(index);
					Length = Length - 1;
					return true;
				}
				catch (Exception e) {
					return false;
				}
			}
			public boolean DeleteLastKey(java.lang.String KeyString) {
				try {
					int index = Key.lastIndexOf(KeyString);
					Key.remove(index);
					Value.remove(index);
					Length = Length - 1;
					return true;
				}
				catch (Exception e) {
					return false;
				}
			}
			public boolean DeleteFirstValue(java.lang.String ValueString) {
				try {
					int index = Value.indexOf(ValueString);
					Key.remove(index);
					Value.remove(index);
					Length = Length - 1;
					return true;
				}
				catch (Exception e) {
					return false;
				}
			}
			public boolean DeleteLastValue(java.lang.String ValueString) {
				try {
					int index = Value.lastIndexOf(ValueString);
					Key.remove(index);
					Value.remove(index);
					Length = Length - 1;
					return true;
				}
				catch (Exception e) {
					return false;
				}
			}
			public int DeleteAllKey(java.lang.String KeyString) {
				int i = 0;
				int j = Length;
				while (i != Length) {
					if (Key.get(i) == KeyString) {
						Key.remove(i);
						Value.remove(i);
						Length = Length - 1;
					}
					else {
						i = i + 1;
					}
					// My.Log("" + i + ":" + Length);
				}
				return j - Length;
			}
			public int DeleteAllValue(java.lang.String ValueString) {
				int i = 0;
				int j = Length;
				while (i != Length) {
					if (Value.get(i) == ValueString) {
						Key.remove(i);
						Value.remove(i);
						Length = Length - 1;
					}
					else {
						i = i + 1;
					}
					// My.Log("" + i + ":" + Length);
				}
				return j - Length;
			}
			//
			// 设置是否不可重复（不可重复时删除重复项）
			public void SetKeyUnique(boolean IsUnique) {
				KeyUnique = IsUnique;
				if (KeyUnique) {
					for (int i = 0; i < Length; i++) {
						for (int j = 0; j < i; j++) {
							if (Key.get(i) == Key.get(j)) {
								Delete(i);// 删除
								i--;// 重新检验
							}
						}
					}
				}
			}
			public void SetValueUnique(boolean IsUnique) {
				ValueUnique = IsUnique;
				if (ValueUnique) {
					for (int i = 0; i < Length; i++) {
						for (int j = 0; j < i; j++) {
							if (Value.get(i) == Value.get(j)) {
								Delete(i);// 删除
								i--;// 重新检验
							}
						}
					}
				}
			}
			public void SetKeyAndValueUnique(boolean IsUnique) {
				KeyAndValueUnique = IsUnique;
				if (KeyAndValueUnique) {
					for (int i = 0; i < Length; i++) {
						for (int j = 0; j < i; j++) {
							if (Key.get(i) == Key.get(j) && Value.get(i) == Value.get(j)) {
								Delete(i);// 删除
								i--;// 重新检验
							}
						}
					}
				}
			}
			//
			// 设置值
			public void Set(int index, java.lang.String KeyString, java.lang.String ValueString) {
				Key.set(index, KeyString);
				Value.set(index, ValueString);
				// 检验重复性问题
				SetKeyUnique(KeyUnique);
				SetValueUnique(ValueUnique);
				SetKeyAndValueUnique(KeyAndValueUnique);
			}
			public void Set(int index, java.lang.String[] KeyAndValue) {
				if (KeyAndValue.length >= 2) {
					Key.set(index, KeyAndValue[0]);
					Value.set(index, KeyAndValue[1]);
					// 检验重复性问题
					SetKeyUnique(KeyUnique);
					SetValueUnique(ValueUnique);
					SetKeyAndValueUnique(KeyAndValueUnique);
				}
			}
			public void SetAllValue(java.lang.String KeyString, java.lang.String ValueString) {
				for (int i = 0; i < Length; i++) {
					if (Key.get(i) == KeyString) {
						Value.set(i, ValueString);
					}
				}
				// 检验重复性问题
				SetKeyUnique(KeyUnique);
				SetValueUnique(ValueUnique);
				SetKeyAndValueUnique(KeyAndValueUnique);
			}
			public void SetAllValue(java.lang.String[] KeyAndValue) {
				if (KeyAndValue.length >= 2) {
					for (int i = 0; i < Length; i++) {
						if (Key.get(i) == KeyAndValue[0]) {
							Value.set(i, KeyAndValue[1]);
						}
					}
					// 检验重复性问题
					SetKeyUnique(KeyUnique);
					SetValueUnique(ValueUnique);
					SetKeyAndValueUnique(KeyAndValueUnique);
				}
			}
			public void SetKey(int index, java.lang.String KeyString) {
				Key.set(index, KeyString);
				// 检验重复性问题
				SetKeyUnique(KeyUnique);
				SetKeyAndValueUnique(KeyAndValueUnique);
			}
			public void SetValue(int index, java.lang.String ValueString) {
				Value.set(index, ValueString);
				// 检验重复性问题
				SetValueUnique(ValueUnique);
				SetKeyAndValueUnique(KeyAndValueUnique);
			}
			//
			// 转为JSON（重复的键会被靠后的键值替换）
			public Json ToJson() {
				return new Json(this);
			}
			public java.lang.String ToJsonString() {
				org.json.JSONObject Object = new org.json.JSONObject();
				for (int i = 0; i < Length; i++) {
					try {
						Object.put(GetKey(i), GetValue(i));
					}
					catch (org.json.JSONException e) {
						e.printStackTrace();
					}
				}
				return Object.toString();
			}
		}
		// /*【 示例用法】*/
		// My.Toast.Show(A.ToJson().JsonString());
		// My.Toast.Show(B.ToJsonString());
		// My.Class.Json C = new My.Class.Json(new My.Class.Json(A));
		// My.Class.Json D = new My.Class.Json(B);
		// My.Toast.Show(C.JsonString());
		// My.Toast.Show(D.JsonString());
		//
		// JSON递归解析对象
		public static class Json {
			public org.json.JSONArray Array = new org.json.JSONArray();;
			public org.json.JSONObject Object = new org.json.JSONObject();;
			// 只有JSON格式为JSONArray时，Length才会大于0
			public int Length = 0;
			public Json() {}
			public Json(java.lang.String jsonString) {
				try {
					Object = new org.json.JSONObject(jsonString);
				}
				catch (org.json.JSONException e) {
					// e.printStackTrace();
				}
				try {
					Array = new org.json.JSONArray(jsonString);
					Length = Array.length();
				}
				catch (org.json.JSONException e) {
					// e.printStackTrace();
				}
			}
			public Json(Json JsonInstance) {
				try {
					Object = new org.json.JSONObject(JsonInstance.JsonString());
				}
				catch (org.json.JSONException e) {
					// e.printStackTrace();
				}
				try {
					Array = new org.json.JSONArray(JsonInstance.JsonString());
					Length = Array.length();
				}
				catch (org.json.JSONException e) {
					// e.printStackTrace();
				}
			}
			public Json(KeyValue KeyValueInstance) {
				Array = null;
				if (Object == null) {
					Object = new org.json.JSONObject();
				}
				for (int i = 0; i < KeyValueInstance.Length; i++) {
					try {
						Object.put(KeyValueInstance.GetKey(i), KeyValueInstance.GetValue(i));
					}
					catch (org.json.JSONException e) {
						e.printStackTrace();
					}
				}
			}
			// 取子对象
			public Json Get(int index) {
				Json temp = new Json();
				if (Array != null) {
					temp.Object = Array.optJSONObject(index);
					temp.Array = Array.optJSONArray(index);
				}
				return temp;
			}
			public Json Get(java.lang.String index) {
				Json temp = new Json();
				if (Object != null) {
					temp.Object = Object.optJSONObject(index);
					temp.Array = Object.optJSONArray(index);
				}
				return temp;
			}
			// 以下函数为强行取值函数，获取失败时返回各类型的默认初值
			public int GetInt(int index) {
				int temp = 0;
				if (Array != null) {
					temp = Array.optInt(index);
				}
				return temp;
			}
			public int GetInt(java.lang.String index) {
				int temp = 0;
				if (Object != null) {
					temp = Object.optInt(index);
				}
				return temp;
			}
			public java.lang.String GetString(int index) {
				java.lang.String temp = "";
				if (Array != null) {
					temp = Array.optString(index);
				}
				return temp;
			}
			public java.lang.String GetString(java.lang.String index) {
				java.lang.String temp = "";
				if (Object != null) {
					temp = Object.optString(index);
				}
				return temp;
			}
			public boolean GetBoolean(int index) {
				boolean temp = false;
				if (Array != null) {
					temp = Array.optBoolean(index);
				}
				return temp;
			}
			public boolean GetBoolean(java.lang.String index) {
				boolean temp = false;
				if (Object != null) {
					temp = Object.optBoolean(index);
				}
				return temp;
			}
			public long GetLong(int index) {
				long temp = 0;
				if (Array != null) {
					temp = Array.optLong(index);
				}
				return temp;
			}
			public long GetLong(java.lang.String index) {
				long temp = 0;
				if (Object != null) {
					temp = Object.optLong(index);
				}
				return temp;
			}
			public double GetDouble(int index) {
				double temp = 0;
				if (Array != null) {
					temp = Array.optDouble(index);
				}
				return temp;
			}
			public double GetDouble(java.lang.String index) {
				double temp = 0;
				if (Object != null) {
					temp = Object.optDouble(index);
				}
				return temp;
			}
			// 修正org.json.JSONObject.NULL为null值，认为不存在
			public Object GetObject(int index) {
				Object temp = null;
				if (Array != null) {
					temp = Array.opt(index);
					if (temp == org.json.JSONObject.NULL) {
						temp = null;
					}
				}
				return temp;
			}
			public Object GetObject(java.lang.String index) {
				Object temp = null;
				if (Object != null) {
					temp = Object.opt(index);
					if (temp == org.json.JSONObject.NULL) {
						temp = null;
					}
				}
				return temp;
			}
			// 以下函数为尝试赋值函数，获取失败时返回false
			public boolean AssignInt(int index, int OutValue) {
				if (Array != null) {
					try {
						OutValue = Array.getInt(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignInt(java.lang.String index, int OutValue) {
				if (Object != null) {
					try {
						OutValue = Object.getInt(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignString(int index, java.lang.String OutValue) {
				if (Array != null) {
					try {
						OutValue = Array.getString(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignString(java.lang.String index, java.lang.String OutValue) {
				if (Object != null) {
					try {
						OutValue = Object.getString(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignBoolean(int index, boolean OutValue) {
				if (Array != null) {
					try {
						OutValue = Array.getBoolean(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignBoolean(java.lang.String index, boolean OutValue) {
				if (Object != null) {
					try {
						OutValue = Object.getBoolean(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignLong(int index, long OutValue) {
				if (Array != null) {
					try {
						OutValue = Array.getLong(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignLong(java.lang.String index, long OutValue) {
				if (Object != null) {
					try {
						OutValue = Object.getLong(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignDouble(int index, double OutValue) {
				if (Array != null) {
					try {
						OutValue = Array.getDouble(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean AssignDouble(java.lang.String index, double OutValue) {
				if (Object != null) {
					try {
						OutValue = Object.getDouble(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			// 以下函数为判断存在函数，获取失败则返回false
			public boolean HasInt(int index) {
				if (Array != null) {
					try {
						Array.getInt(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasInt(java.lang.String index) {
				if (Object != null) {
					try {
						Object.getInt(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasString(int index) {
				if (Array != null) {
					try {
						Array.getString(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasString(java.lang.String index) {
				if (Object != null) {
					try {
						Object.getString(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasBoolean(int index) {
				if (Array != null) {
					try {
						Array.getBoolean(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasBoolean(java.lang.String index) {
				if (Object != null) {
					try {
						Object.getBoolean(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasLong(int index) {
				if (Array != null) {
					try {
						Array.getLong(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasLong(java.lang.String index) {
				if (Object != null) {
					try {
						Object.getLong(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasDouble(int index) {
				if (Array != null) {
					try {
						Array.getDouble(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasDouble(java.lang.String index) {
				if (Object != null) {
					try {
						Object.getDouble(index);
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			// 修正org.json.JSONObject.NULL为null值，认为不存在
			public boolean HasObject(int index) {
				if (Array != null) {
					try {
						Array.get(index);
						if (Array.get(index) == org.json.JSONObject.NULL) {
							return false;
						}
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			public boolean HasObject(java.lang.String index) {
				if (Object != null) {
					try {
						Object.get(index);
						if (Object.get(index) == org.json.JSONObject.NULL) {
							return false;
						}
					}
					catch (org.json.JSONException e) {
						// e.printStackTrace();
						return false;
					}
					return true;
				}
				return false;
			}
			// 转换字符串函数
			// 默认初始化的JSON类对象转换后为{ }
			public java.lang.String JsonString() {
				java.lang.String temp = "";
				if (Object != null) {
					temp = Object.toString();
				}
				else if (Array != null) {
					temp = Array.toString();
				}
				return temp;
			}
			// JSON创建和修改函数（index必须全为整数或全为字符串）
			// index为整数时，跳过的没有赋值的整数位置的值为org.json.JSONObject.NULL
			// 可能的结果为：["123",null,null,null,"123"]
			// null值，用GetString获取为null的字符串，用GetObject获取为JAVA的null空值
			public boolean Put(int index, int value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					Array.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, int value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					Object.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(int index, java.lang.String value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					Array.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, java.lang.String value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					Object.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(int index, boolean value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					Array.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, boolean value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					Object.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(int index, long value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					Array.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, long value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					Object.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(int index, double value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					Array.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, double value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					Object.put(index, value);
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(int index, Json value) {
				Object = null;
				try {
					if (Array == null) {
						Array = new org.json.JSONArray();
					}
					if (value.Object != null) {
						Array.put(index, value.Object);
					}
					else if (value.Array != null) {
						Array.put(index, value.Array);
					}
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public boolean Put(java.lang.String index, Json value) {
				Array = null;
				try {
					if (Object == null) {
						Object = new org.json.JSONObject();
					}
					if (value.Object != null) {
						Object.put(index, value.Object);
					}
					else if (value.Array != null) {
						Object.put(index, value.Array);
					}
				}
				catch (org.json.JSONException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		// /*【 示例用法】*/
		// My.Class.KeyValue A = new My.Class.KeyValue("123","456");
		// A.SetKeyUnique(true);
		// A.Add("120","120");
		// My.Class.XML X = new
		// My.Class.XML("<?xml version=\"1.0\" encoding=\"UTF-8\"?><XML><Node>这是节点1</Node><Node>这是节点2<node>这是节点3</node></Node></XML>");
		// My.Toast.Show("Declaration："+A.Declaration);
		// My.Toast.Show("NodeName："+A.NodeName);
		// My.Toast.Show("NodeBody："+A.InnerString);
		// My.Toast.Show("XMLString："+A.XMLString());
		// My.Toast.Show("GetChildren.length："+A.GetChildren("Node").length);
		// My.Toast.Show("GetFirstChild.XMLString："+A.GetFirstChild("Node").XMLString());
		// My.Toast.Show("GetLastChild.InnerString："+A.GetLastChild("Node").InnerBody);
		// My.LogCat.Log("GetChildren(Node)[1].GetLastChild(node).XMLString()："+X.GetChildren("Node")[1].GetLastChild("node").XMLString());
		// My.LogCat.Log("GetChildren(Node)[1].GetLastChild(node).Clone().InnerBody："+X.GetChildren("Node")[1].GetLastChild("node").Clone().InnerBody);
		// My.LogCat.Log("new My.Class.XML().XMLString()："+ new
		// My.Class.XML().XMLString() );
		// My.LogCat.Log("new My.Class.XML(null,ROOT,null).XMLString()："+
		// My.Class.XML.Create("ROOT").XMLString() );
		// My.LogCat.Log("new My.Class.XML(null,ABC,123).XMLString()："+
		// My.Class.XML.Create("ABC","123").XMLString() );
		// My.LogCat.Log("(new My.Class.XML(null,ROOT,null)).AddChild(new My.Class.XML(null,ABC,123)).XMLString()："+My.Class.XML.Create("ROOT").AddChild("ABC","123").XMLString());
		// My.LogCat.Log("A："+My.Class.XML.Create("root",A).XMLString());
		// My.Class.XML B = new My.Class.XML();
		// B = B.SetNodeName("HTML");
		// B.ReallyAddChild("Head","这是头部");
		// B.ReallyAddChild("Body","这是正文");
		// My.LogCat.Log("B："+B.XMLString());
		// My.LogCat.Log("Y："+My.Class.XML.Create("root",new
		// My.Class.KeyValue()).XMLString());
		//
		// XML递归解析对象
		public static class XML {
			// 成员
			// <?xml?>
			// <?xml version="1.0"?>
			// <?xml version="1.0" encoding="utf-8"?>
			public java.lang.String Declaration;// 声明
			public java.lang.String NodeName;// 节点名称
			public java.lang.String InnerBody;// 节点内容
			// 构造函数
			public XML() {
				Declaration = "";
				NodeName = "";
				InnerBody = "";
			}
			public XML(java.lang.String XMLString) {
				if (XMLString != null) {
					if (XMLString.startsWith("<?") && XMLString.contains("?>")) {
						Declaration = "<?" + My.String.FindFirst(XMLString, "<?", "?>").trim() + "?>";
					}
					else {
						Declaration = "";
					}
					java.lang.String tempString = XMLString.replace(Declaration, "").trim();
					if (tempString.startsWith("<") && tempString.endsWith(">")) {
						NodeName = My.String.FindFirst(tempString, "<", ">").trim();
					}
					else {
						NodeName = "";
					}
					InnerBody = My.String.FindMiddle(tempString, "<" + NodeName + ">", "</" + NodeName + ">").trim();
				}
				else {
					Declaration = "";
					NodeName = "";
					InnerBody = "";
				}
			}
			public XML(java.lang.String XMLString, java.lang.String DeclarationString) {
				if (XMLString != null) {
					// 强制设定XML声明
					if (DeclarationString != null && DeclarationString.startsWith("<?") && DeclarationString.contains("?>")) {
						Declaration = "<?" + My.String.FindFirst(DeclarationString, "<?", "?>").trim() + "?>";
					}
					else {
						Declaration = "";
					}
					java.lang.String tempString = XMLString.replace(Declaration, "").trim();
					if (tempString.startsWith("<") && tempString.endsWith(">")) {
						NodeName = My.String.FindFirst(tempString, "<", ">").trim();
					}
					else {
						NodeName = "";
					}
					InnerBody = My.String.FindMiddle(tempString, "<" + NodeName + ">", "</" + NodeName + ">").trim();
				}
				else {
					Declaration = "";
					NodeName = "";
					InnerBody = "";
				}
			}
			public XML(java.lang.String DeclarationString, java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				if (DeclarationString == null) {
					DeclarationString = "";
				}
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				Declaration = new java.lang.String(DeclarationString);
				NodeName = new java.lang.String(NodeNameString);
				InnerBody = new java.lang.String(InnerBodyString);
			}
			public XML(java.lang.String DeclarationString, java.lang.String NodeNameString, KeyValue InnerBodyKeyValue) {
				if (DeclarationString == null) {
					DeclarationString = "";
				}
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyKeyValue == null) {
					InnerBodyKeyValue = new KeyValue();
				}
				StringBuffer stringBuffer = new StringBuffer();
				for (int i = 0; i < InnerBodyKeyValue.Length(); i++) {
					stringBuffer.append(new XML("", InnerBodyKeyValue.GetKey(i), InnerBodyKeyValue.GetValue(i)).XMLString());
				}
				Declaration = new java.lang.String(DeclarationString);
				NodeName = new java.lang.String(NodeNameString);
				InnerBody = new java.lang.String(stringBuffer.toString());
			}
			public XML(XML XMLInstance) {
				Declaration = new java.lang.String(XMLInstance.Declaration);
				NodeName = new java.lang.String(XMLInstance.NodeName);
				InnerBody = new java.lang.String(XMLInstance.InnerBody);
			}
			// 创建新XML对象的函数
			public static XML Create(java.lang.String NodeNameString) {
				return new XML("", NodeNameString, "");
			}
			public static XML Create(java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				return new XML("", NodeNameString, InnerBodyString);
			}
			public static XML Create(java.lang.String NodeNameString, KeyValue InnerBodyKeyValue) {
				return new XML("", NodeNameString, InnerBodyKeyValue);
			}
			// 输出完整的XML字符串
			// 新建的空白XML转换结果为：<></>
			public java.lang.String XMLString() {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(Declaration);
				stringBuffer.append("<");
				stringBuffer.append(NodeName);
				stringBuffer.append(">");
				stringBuffer.append(InnerBody);
				stringBuffer.append("</");
				stringBuffer.append(NodeName);
				stringBuffer.append(">");
				return stringBuffer.toString();
			}
			// 复制对象
			public XML Clone() {
				// return new XML( this );
				return new XML(Declaration, NodeName, InnerBody);
			}
			// 获取节点
			// 节点区分大小写
			// 节点不允许有属性，无法获取属性信息
			// 同层的节点名称可以重复，多层不允许重复（出现多层重名的节点时，会导致被截断的问题）
			// 无法获取类似<NodeName/>或<NodeName>形式的节点
			public XML GetFirstChild(java.lang.String ElementName) {
				if (ElementName == null) {
					ElementName = "";
				}
				return new XML("<" + ElementName + ">" + My.String.FindFirst(InnerBody, "<" + ElementName + ">", "</" + ElementName + ">") + "</" + ElementName + ">", Declaration);
			}
			public XML GetLastChild(java.lang.String ElementName) {
				if (ElementName == null) {
					ElementName = "";
				}
				return new XML("<" + ElementName + ">" + My.String.FindLast(InnerBody, "<" + ElementName + ">", "</" + ElementName + ">") + "</" + ElementName + ">", Declaration);
			}
			public XML[] GetChildren(java.lang.String ElementName) {
				if (ElementName == null) {
					ElementName = "";
				}
				java.util.ArrayList<java.lang.String> StringArrayList = My.String.FindArrayList(InnerBody, "<" + ElementName + ">", "</" + ElementName + ">");
				XML[] XMLArrayList = new XML[StringArrayList.size()];
				for (int i = 0; i < StringArrayList.size(); i++) {
					XMLArrayList[i] = new XML("<" + ElementName + ">" + StringArrayList.get(i) + "</" + ElementName + ">", Declaration);
				}
				StringArrayList.clear();
				return XMLArrayList;
			}
			// 添加节点
			// 注意：只是返回一个添加过的XML，并不是添加到当前这个XML本身
			public XML AddChildAtFirst(java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				return AddChildAtFirst(new My.Class.XML("", NodeNameString, InnerBodyString));
			}
			public XML AddChild(java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				return AddChild(new My.Class.XML("", NodeNameString, InnerBodyString));
			}
			public XML AddChildAtFirst(java.lang.String NodeString) {
				if (NodeString == null) {
					NodeString = "";
				}
				return new XML(Declaration, NodeName, NodeString + InnerBody);
			}
			public XML AddChild(java.lang.String NodeString) {
				if (NodeString == null) {
					NodeString = "";
				}
				return new XML(Declaration, NodeName, InnerBody + NodeString);
			}
			public XML AddChildAtFirst(XML Node) {
				return new XML(Declaration, NodeName, Node.XMLString() + InnerBody);
			}
			public XML AddChild(XML Node) {
				return new XML(Declaration, NodeName, InnerBody + Node.XMLString());
			}
			// 修改节点
			// 注意：只是返回一个修改过的XML，并不是修改了当前这个XML本身
			public XML SetDeclaration(java.lang.String DeclarationString) {
				if (DeclarationString == null) {
					DeclarationString = "";
				}
				if (DeclarationString.startsWith("<?") && DeclarationString.contains("?>")) {
					return new XML("<?" + My.String.FindFirst(DeclarationString, "<?", "?>").trim() + "?>", NodeName, InnerBody);
				}
				else {
					return new XML("", NodeName, InnerBody);
				}
			}
			public XML SetNodeName(java.lang.String NodeNameString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				return new XML(Declaration, NodeNameString, InnerBody);
			}
			public XML SetInnerBody(java.lang.String InnerBodyString) {
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				return new XML(Declaration, NodeName, InnerBodyString);
			}
			// 真实操作的函数
			// 修改当前这个XML本身
			public XML ReallySetDeclaration(java.lang.String DeclarationString) {
				if (DeclarationString == null) {
					DeclarationString = "";
				}
				if (DeclarationString.startsWith("<?") && DeclarationString.contains("?>")) {
					Declaration = "<?" + My.String.FindFirst(DeclarationString, "<?", "?>").trim() + "?>";
				}
				else {
					Declaration = "";
				}
				return this;
			}
			public XML ReallySetNodeName(java.lang.String NodeNameString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				NodeName = NodeNameString;
				return this;
			}
			public XML ReallySetInnerBody(java.lang.String InnerBodyString) {
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				InnerBody = InnerBodyString;
				return this;
			}
			public XML ReallyAddChildAtFirst(java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				ReallyAddChildAtFirst(new My.Class.XML("", NodeNameString, InnerBodyString));
				return this;
			}
			public XML ReallyAddChild(java.lang.String NodeNameString, java.lang.String InnerBodyString) {
				if (NodeNameString == null) {
					NodeNameString = "";
				}
				if (InnerBodyString == null) {
					InnerBodyString = "";
				}
				ReallyAddChildAtFirst(new My.Class.XML("", NodeNameString, InnerBodyString));
				return this;
			}
			public XML ReallyAddChildAtFirst(java.lang.String NodeString) {
				if (NodeString == null) {
					NodeString = "";
				}
				InnerBody = NodeString + InnerBody;
				return this;
			}
			public XML ReallyAddChild(java.lang.String NodeString) {
				if (NodeString == null) {
					NodeString = "";
				}
				InnerBody = InnerBody + NodeString;
				return this;
			}
			public XML ReallyAddChildAtFirst(XML Node) {
				InnerBody = Node.XMLString() + InnerBody;
				return this;
			}
			public XML ReallyAddChild(XML Node) {
				InnerBody = InnerBody + Node.XMLString();
				return this;
			}
		}
	}
	// 设备信息
	public static class Device {
		public static int SDK() {
			return android.os.Build.VERSION.SDK_INT;
		}
		public static java.lang.String AndroidVersion() {// 安卓版本号
			return android.os.Build.VERSION.RELEASE;
		}
		public static java.lang.String Brand() {// 商标
			return android.os.Build.BRAND;
		}
		public static java.lang.String Design() {
			return android.os.Build.DEVICE;
		}
		public static java.lang.String Name() {
			return android.os.Build.DISPLAY;
		}
		public static java.lang.String FingerPrint() {// 产品指纹（唯一）
			return android.os.Build.FINGERPRINT;
		}
		public static java.lang.String ID() {
			return android.os.Build.ID;
		}
		public static java.lang.String KernelHardware() {// 核心硬件型号
			return android.os.Build.HARDWARE;
		}
		public static java.lang.String Manufacturer() {// 制造商
			return android.os.Build.MANUFACTURER;
		}
		public static java.lang.String SerialNumber() {// 序列号
			return android.os.Build.SERIAL;
		}
		public static java.lang.String User() {
			return android.os.Build.USER;
		}
		public static java.lang.String ProductName() {// 商品名
			return android.os.Build.MODEL;
		}
		public static java.lang.String ProductTime() {// 生产日期
			java.util.Date date = new java.util.Date(android.os.Build.TIME);
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.PRC);
			return formatter.format(date);
		}
		public static java.lang.String ProductTimeByChinese() {// 生产日期（中文日期格式）
			java.util.Date date = new java.util.Date(android.os.Build.TIME);
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒", java.util.Locale.PRC);
			return formatter.format(date);
		}
	}
	// 时间信息
	public static class Time {
		public static long NowTime() {// 当前时间
			return java.lang.System.currentTimeMillis();
		}
		public static long ElapsedTime() {// 从开机到现在一共过去的时间
			return android.os.SystemClock.elapsedRealtime();
		}
		public static long UpTime() {// 从开机到现在的非睡眠状态时间
			return android.os.SystemClock.uptimeMillis();
		}
		public static java.lang.String NowTimeString() {// 当前时间
			java.util.Date date = new java.util.Date(java.lang.System.currentTimeMillis());
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.PRC);
			return formatter.format(date);
		}
		public static java.lang.String ElapsedTimeString() {// 从开机到现在一共过去的时间
			return FormatTime(android.os.SystemClock.elapsedRealtime());
		}
		public static java.lang.String UpTimeString() {// 从开机到现在的非睡眠状态时间
			return FormatTime(android.os.SystemClock.uptimeMillis());
		}
		public static java.lang.String FormatTime(long Time) {// 将时间差转换为字符串（精确到秒）
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTimeInMillis(Time);
			java.lang.String returnString = "";
			// 原始时间格式1970-01-01 08:00:00
			if (calendar.get(java.util.Calendar.YEAR) - 1970 > 0) {
				returnString += (calendar.get(java.util.Calendar.YEAR) - 1970) + "年";
				returnString += (calendar.get(java.util.Calendar.MONTH) - 1) + "月";
				returnString += (calendar.get(java.util.Calendar.DAY_OF_MONTH) - 1) + "日";
				returnString += (calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8) + "时";
				returnString += (calendar.get(java.util.Calendar.MINUTE)) + "分";
				returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
			}
			else {
				if (calendar.get(java.util.Calendar.MONTH) - 1 > 0) {
					returnString += (calendar.get(java.util.Calendar.MONTH) - 1) + "月";
					returnString += (calendar.get(java.util.Calendar.DAY_OF_MONTH) - 1) + "日";
					returnString += (calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8) + "时";
					returnString += (calendar.get(java.util.Calendar.MINUTE)) + "分";
					returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
				}
				else {
					if (calendar.get(java.util.Calendar.DAY_OF_MONTH) - 1 > 0) {
						returnString += (calendar.get(java.util.Calendar.DAY_OF_MONTH) - 1) + "日";
						returnString += (calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8) + "时";
						returnString += (calendar.get(java.util.Calendar.MINUTE)) + "分";
						returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
					}
					else {
						if (calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8 > 0) {
							returnString += (calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8) + "时";
							returnString += (calendar.get(java.util.Calendar.MINUTE)) + "分";
							returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
						}
						else {
							if (calendar.get(java.util.Calendar.MINUTE) > 0) {
								returnString += (calendar.get(java.util.Calendar.MINUTE)) + "分";
								returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
							}
							else {
								if (calendar.get(java.util.Calendar.SECOND) > 0) {
									returnString += (calendar.get(java.util.Calendar.SECOND)) + "秒";
								}
								else {
									returnString += "0秒";
								}
							}
						}
					}
				}
			}
			return returnString;
		}
	}
	// 屏幕信息
	public static class Screen {
		public static int ScreenWidth() {// 屏幕宽度（像素）
			android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
			MainActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
			return dm.widthPixels;
		}
		public static int ScreenWidth(android.app.Activity Activity) {// 屏幕宽度（像素）
			android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
			Activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
			return dm.widthPixels;
		}
		public static int ScreenHeight() {// 屏幕高度（像素）
			android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
			MainActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
			return dm.heightPixels;
		}
		public static int ScreenHeight(android.app.Activity Activity) {// 屏幕高度（像素）
			android.util.DisplayMetrics dm = new android.util.DisplayMetrics();
			Activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
			return dm.heightPixels;
		}
		public static float ScreenRefreshRate(android.app.Activity Activity) {// 屏幕刷新率
			return Activity.getWindowManager().getDefaultDisplay().getRefreshRate();
		}
		// 需要权限：
		// <uses-permission android:name="android.permission.WAKE_LOCK" />
		public static void KeepScreenOn() {// 屏幕保持长亮
			MainActivity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		public static void KeepScreenOn(android.app.Activity Activity) {// 屏幕保持长亮
			Activity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		public static void NoKeepScreenOn() {// 屏幕不保持长亮
			MainActivity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		public static void NoKeepScreenOn(android.app.Activity Activity) {// 屏幕不保持长亮
			Activity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
		// 按下电源按钮时，屏幕会关闭，CPU会继续运转。
		public static void KeepCPUOn() {// CPU保持运转
			android.os.PowerManager MyPowerManager = (android.os.PowerManager) MainActivity.getSystemService(android.content.Context.POWER_SERVICE);
			android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
			MyWakeLock.acquire();
		}
		public static void KeepCPUOn(android.app.Activity Activity) {// CPU保持运转
			android.os.PowerManager MyPowerManager = (android.os.PowerManager) Activity.getSystemService(android.content.Context.POWER_SERVICE);
			android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
			MyWakeLock.acquire();
		}
		public static void KeepCPUOnByTime(long Time) {// CPU保持运转一段时间
			android.os.PowerManager MyPowerManager = (android.os.PowerManager) MainActivity.getSystemService(android.content.Context.POWER_SERVICE);
			android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
			MyWakeLock.acquire(Time);
		}
		public static void KeepCPUOnByTime(android.app.Activity Activity, long Time) {// CPU保持运转一段时间
			android.os.PowerManager MyPowerManager = (android.os.PowerManager) Activity.getSystemService(android.content.Context.POWER_SERVICE);
			android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
			MyWakeLock.acquire(Time);
		}
		public static void NoKeepCPUOn() {// CPU不保持运转
			android.os.PowerManager MyPowerManager = (android.os.PowerManager) MainActivity.getSystemService(android.content.Context.POWER_SERVICE);
			android.os.PowerManager.WakeLock MyWakeLock = MyPowerManager.newWakeLock(android.os.PowerManager.PARTIAL_WAKE_LOCK, "");
			try {
				MyWakeLock.release();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			MyWakeLock.setReferenceCounted(false);
		}
		public static void NoKeepCPUOn(android.app.Activity Activity) {// CPU不保持运转
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
	// 内存信息
	public static class Memory {
		// 进程管理
		public static android.app.ActivityManager MyActivityManager = (android.app.ActivityManager) MainActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE);
		public static long AvailableMemory() {// 可用内存
			android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
			MyActivityManager.getMemoryInfo(outInfo);
			return outInfo.availMem;
		}
		public static int AvailableMemoryMB() {// 可用内存（单位MB）
			android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
			MyActivityManager.getMemoryInfo(outInfo);
			return (int) (outInfo.availMem / 1024 / 1024);
		}
		public static long TotalMemory() {// 总内存
			// 以下是android:minSdkVersion在16以上的写法
			// android.app.ActivityManager.MemoryInfo outInfo = new
			// android.app.ActivityManager.MemoryInfo();
			// MyActivityManager.getMemoryInfo(outInfo);
			// return outInfo.totalMem;
			java.lang.String info = "/proc/meminfo";// 系统内存信息文件
			// 文件第一行内容如下（每行固定长度27）：
			// MemTotal: 94096 kB
			// Log(My.IO.ReadLine(info).replaceAll("MemTotal:",
			// "").replaceAll(" kB", "").trim());
			return Integer.valueOf(My.IO.ReadLine(info).replaceAll("MemTotal:", "").replaceAll(" kB", "").trim()) * 1024;
		}
		public static int TotalMemoryMB() {// 总内存（单位MB）
			// 以下是android:minSdkVersion在16以上的写法
			// android.app.ActivityManager.MemoryInfo outInfo = new
			// android.app.ActivityManager.MemoryInfo();
			// MyActivityManager.getMemoryInfo(outInfo);
			// return (int) (outInfo.totalMem / 1024 / 1024);
			java.lang.String info = "/proc/meminfo";// 系统内存信息文件
			// 文件第一行内容如下（每行固定长度27）：
			// MemTotal: 94096 kB
			// Log(My.IO.ReadLine(info).replaceAll("MemTotal:",
			// "").replaceAll(" kB", "").trim());
			return Integer.valueOf(My.IO.ReadLine(info).replaceAll("MemTotal:", "").replaceAll(" kB", "").trim()) / 1024;
			// 同理，可获取CPU的信息：
			// My.Log(My.IO.ReadFile("/proc/cpuinfo"));
			// My.Log(My.IO.ReadFile("/proc/stat"));
		}
		public static long ThresholdMemory() {// 内存临界值
			android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
			MyActivityManager.getMemoryInfo(outInfo);
			return outInfo.threshold;
		}
		public static int ThresholdMemoryMB() {// 内存临界值（单位MB）
			android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
			MyActivityManager.getMemoryInfo(outInfo);
			return (int) (outInfo.threshold / 1024 / 1024);
		}
		public static boolean IsLowMemory() {// 内存是否不足
			android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
			MyActivityManager.getMemoryInfo(outInfo);
			return outInfo.lowMemory;
		}
		public static class MyProcessInfo {// 自定义的描述进程信息的类
			public int ProcessId;
			public int UserId;
			public java.lang.String ProcessName;
			public int MemoryUsageKB;
			public int MemoryUsageMB;
			public java.lang.String PackageLoaded;
			public java.lang.String[] PackageLoadedList;
			public java.lang.String InfoString;
			public MyProcessInfo(android.app.ActivityManager.RunningAppProcessInfo Info) {
				ProcessId = Info.pid;
				UserId = Info.uid;
				ProcessName = Info.processName;
				MemoryUsageKB = MyActivityManager.getProcessMemoryInfo(new int[] { ProcessId })[0].getTotalPss();
				// getTotalPss = getTotalPrivateDirty + getTotalSharedDirty
				// getTotalPss的数据较为可信。
				MemoryUsageMB = MemoryUsageKB / 1024;
				PackageLoadedList = Info.pkgList;
				PackageLoaded = My.String.FromArray(PackageLoadedList, "\r\n");
				InfoString = "" + "进程ID：" + ProcessId + "\r\n" + "用户ID：" + UserId + "\r\n" + "进程名称：" + ProcessName + "\r\n" + "占用内存：" + MemoryUsageMB + "MB" + "\r\n" + "进程使用的包：" + PackageLoaded + "";
			}
		}
		public static void KillOtherBackgroundProcess(java.lang.String packageName) {// 杀死其它后台进程
			// 需要权限：
			// <uses-permission
			// android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>
			MyActivityManager.killBackgroundProcesses(packageName);
			// 和安卓核心在内存不足时的处理方法有相同效果。
		}
		public static void KillMyself() {// 强制结束自身
			android.os.Process.killProcess(android.os.Process.myPid());
		}
		public static void Exit() {// 强制结束自身
			System.exit(0);
		}
		public static MyProcessInfo[] RunningAppProcess() {// 正在运行的进程信息
			java.util.List<android.app.ActivityManager.RunningAppProcessInfo> RAP = MyActivityManager.getRunningAppProcesses();
			MyProcessInfo[] info = new MyProcessInfo[RAP.size()];
			for (int i = 0; i < RAP.size(); i++) {
				info[i] = new MyProcessInfo(RAP.get(i));
			}
			return info;
		}
	}
	// Fragment管理
	public static class Fragment {
		public static void Add(int containerViewId, android.app.Fragment fragment) {// 添加Fragment
			if (fragment != null && fragment.isAdded() == false) {
				MainActivity.getFragmentManager().beginTransaction().add(containerViewId, fragment).commit();
			}
		}
		public static android.app.Fragment SlideIn(int containerViewId, android.app.Fragment showFragment, android.app.Fragment hideFragment) {// 切换Fragment
			try {
				if (showFragment == hideFragment) {
					return showFragment;
				}
				if (hideFragment != null && showFragment != null && hideFragment.isAdded() == true && showFragment.isAdded() == true) {
					MainActivity.getFragmentManager().beginTransaction().show(showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).commit();
				}
				else if (hideFragment != null && showFragment != null && hideFragment.isAdded() == true && showFragment.isAdded() == false) {
					MainActivity.getFragmentManager().beginTransaction().add(containerViewId, showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).commit();
				}
				else if (hideFragment == null || hideFragment.isAdded() == false) {
					Add(containerViewId, showFragment);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return showFragment;// 返回当前显示的Fragment
		}
		public static android.app.Fragment FadeIn(int containerViewId, android.app.Fragment showFragment, android.app.Fragment hideFragment) {// 切换Fragment
			try {
				if (showFragment == hideFragment) {
					return showFragment;
				}
				if (hideFragment != null && showFragment != null && hideFragment.isAdded() == true && showFragment.isAdded() == true) {
					MainActivity.getFragmentManager().beginTransaction().show(showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
				}
				else if (hideFragment != null && showFragment != null && hideFragment.isAdded() == true && showFragment.isAdded() == false) {
					MainActivity.getFragmentManager().beginTransaction().add(containerViewId, showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
				}
				else if (hideFragment == null || hideFragment.isAdded() == false) {
					Add(containerViewId, showFragment);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return showFragment;// 返回当前显示的Fragment
		}
	}
	// Activity管理
	public static class Activity {
		// 类名，包名，全部名称（依次为：MainActivity，com.MoonLord.MyStudy，com.MoonLord.MyStudy.MainActivity）
		public static java.lang.String ClassName = MainActivity.getClass().getSimpleName();
		public static java.lang.String PackageName = MainActivity.getPackageName();
		public static java.lang.String FullClassName = MainActivity.getClass().getName();
		// 启动Activity
		// 启动的Activity类应该在AndroidManifest中的<application>下有描述，类似如下：
		// <activity android:name="com.MoonLord.ViewPagerDemo" />
		public static void Start(java.lang.Class<?> Class) {
			android.content.Intent intent = new android.content.Intent();
			intent.setClass(My.MainActivity, Class);
			My.MainActivity.startActivity(intent);
		}
		public static void Start(java.lang.Class<?> Class, My.Class.KeyValue KeyValue) {
			android.content.Intent intent = new android.content.Intent();
			intent.setClass(My.MainActivity, Class);
			for (int i = 0; i < KeyValue.Length; i++) {
				intent.putExtra(KeyValue.GetKey(i), KeyValue.GetValue(i));
			}
			My.MainActivity.startActivity(intent);
		}
		// 重新启动Activity
		public static void Restart(java.lang.Class<?> Class) {
			android.content.Intent intent = new android.content.Intent();
			intent.setClass(My.MainActivity, Class);
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP | android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			My.MainActivity.startActivity(intent);
		}
		public static void Restart(java.lang.Class<?> Class, My.Class.KeyValue KeyValue) {
			android.content.Intent intent = new android.content.Intent();
			intent.setClass(My.MainActivity, Class);
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP | android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			for (int i = 0; i < KeyValue.Length; i++) {
				intent.putExtra(KeyValue.GetKey(i), KeyValue.GetValue(i));
			}
			My.MainActivity.startActivity(intent);
		}
		// 绑定子按钮的监听事件
		public static void BindOnClick(int ViewId) {
			My.MainActivity.findViewById(ViewId).setOnClickListener(MainActivity);
		}
		public static void BindOnClick(int[] ViewId) {
			for (int i : ViewId) {
				My.MainActivity.findViewById(i).setOnClickListener(MainActivity);
			}
		}
		// 打开APK文件
		public static void OpenAPKFile(java.lang.String fileName) {
			java.io.File file = new java.io.File(fileName);
			android.content.Intent intent = new android.content.Intent();
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认桌面
		public static void ShowHome() {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_MAIN);
			intent.addCategory(android.content.Intent.CATEGORY_HOME);
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认拨号界面
		public static void ShowDial() {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_DIAL);
			intent.setData(android.net.Uri.parse("tel:"));
			My.MainActivity.startActivity(intent);
		}
		public static void ShowDial(java.lang.String PhoneNumber) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_DIAL);
			intent.setData(android.net.Uri.parse("tel:" + PhoneNumber));
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认拨号界面，并直接进行拨号通话
		// 示例：My.Activity.ShowCall("15527155972");
		// 需要权限：
		// <uses-permission android:name="android.permission.CALL_PHONE" />
		public static void ShowCall(java.lang.String PhoneNumber) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_CALL);
			intent.setData(android.net.Uri.parse("tel:" + PhoneNumber));
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认短信界面
		// SMS：Short Message Service
		// 可以选择短信发送人
		public static void ShowSms() {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SENDTO);
			intent.setData(android.net.Uri.parse("smsto:"));
			intent.putExtra("sms_body", "");
			My.MainActivity.startActivity(intent);
		}
		public static void ShowSms(java.lang.String PhoneNumber) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SENDTO);
			intent.setData(android.net.Uri.parse("smsto:" + PhoneNumber));
			intent.putExtra("sms_body", "");
			My.MainActivity.startActivity(intent);
		}
		public static void ShowSms(java.lang.String PhoneNumber, java.lang.String SmsBody) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SENDTO);
			intent.setData(android.net.Uri.parse("smsto:" + PhoneNumber));
			intent.putExtra("sms_body", SmsBody);
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认邮件界面
		// 用户选择正确的邮件发送程序则可以识别所有参数（选择用QQ什么的打开就可能只识别邮件内容）
		// CarbonCopied 抄送人
		// 示例：My.Activity.ShowEmail("178910432@qq.com");
		// 示例：My.Activity.ShowEmail(new
		// java.lang.String[]{"178910432@qq.com","moonlord@msn.cn"},new
		// java.lang.String[]{"178910432@qq.com","moonlord@msn.cn"},"邮件标题","邮件内容");
		public static void ShowEmail(java.lang.String EmailAddress) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SENDTO);
			intent.setData(android.net.Uri.parse("mailto:" + EmailAddress));
			My.MainActivity.startActivity(intent);
		}
		public static void ShowEmail(java.lang.String EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
			// My.MainActivity.startActivity(android.content.Intent.createChooser(intent,
			// "Choose Email Client"));
			My.MainActivity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
		}
		public static void ShowEmail(java.lang.String[] EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
			// My.MainActivity.startActivity(android.content.Intent.createChooser(intent,
			// "Choose Email Client"));
			My.MainActivity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
		}
		public static void ShowEmail(java.lang.String EmailAddress, java.lang.String CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
			intent.putExtra(android.content.Intent.EXTRA_CC, CarbonCopied);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
			// My.MainActivity.startActivity(android.content.Intent.createChooser(intent,
			// "Choose Email Client"));
			My.MainActivity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
		}
		public static void ShowEmail(java.lang.String[] EmailAddress, java.lang.String[] CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
			intent.putExtra(android.content.Intent.EXTRA_CC, CarbonCopied);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
			intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
			// My.MainActivity.startActivity(android.content.Intent.createChooser(intent,
			// "Choose Email Client"));
			My.MainActivity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
		}
		// 打开安卓默认地图界面
		// 示例：My.Activity.ShowMap(40,116);
		public static void ShowMap() {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setData(android.net.Uri.parse("geo:"));
			My.MainActivity.startActivity(intent);
		}
		public static void ShowMap(android.graphics.Point point) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setData(android.net.Uri.parse("geo:" + point.x + "," + point.y));
			My.MainActivity.startActivity(intent);
		}
		public static void ShowMap(float locationX, float locationY) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setData(android.net.Uri.parse("geo:" + locationX + "," + locationY));
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认网页界面
		// 示例：My.Activity.ShowUrl("www.baidu.com");
		public static void ShowUrl(java.lang.String URL) {
			if (!URL.toLowerCase(java.util.Locale.CHINA).contains("http://")) {
				URL = "http://" + URL;
			}
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setData(android.net.Uri.parse(URL));
			My.MainActivity.startActivity(intent);
		}
		// 打开安卓默认视频播放界面
		// 示例：My.Activity.ShowVideo("file:///storage/sdcard1/我的视频/Let It Go.mp4");
		public static void ShowVideo(java.lang.String FilePath) {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.parse(FilePath), "video/*");
			My.MainActivity.startActivity(intent);
		}
		// 不经过用户允许，后台静默发送短信（谨慎测试）
		// 示例：My.Activity.SendSms("15527155972", "MyAndroid框架短信测试");
		// 需要权限：<uses-permission android:name="android.permission.SEND_SMS" />
		public static void SendSms(java.lang.String PhoneNumber, java.lang.String SmsBody) {
			android.telephony.SmsManager manager = android.telephony.SmsManager.getDefault();
			manager.sendTextMessage(PhoneNumber, null, SmsBody, null, null);
		}
	}
	// IO操作
	public static class IO {
		public static java.lang.String ReadResource(int ResourceId) {// 读取应用程序内部资源，比如R.drawable.ic_launcher
			java.lang.String res = "";
			try {
				// 得到资源中的Raw数据流
				java.io.InputStream in = MainActivity.getResources().openRawResource(ResourceId);
				// 得到数据的大小
				int length = in.available();
				byte[] buffer = new byte[length];
				// 读取数据
				in.read(buffer);
				// 关闭
				in.close();
				res = org.apache.http.util.EncodingUtils.getString(buffer, "UTF-8");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		public static java.lang.String ReadAsset(java.lang.String fileName) {// 读取assets文件夹下的文件，比如test.txt
			java.lang.String res = "";
			try {
				// 得到资源中的asset数据流
				java.io.InputStream in = MainActivity.getResources().getAssets().open(fileName);
				int length = in.available();
				byte[] buffer = new byte[length];
				in.read(buffer);
				in.close();
				res = org.apache.http.util.EncodingUtils.getString(buffer, "UTF-8");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		public static boolean WritePrivateFile(java.lang.String fileName, java.lang.String writestr) {// 写数据到/data/……/<应用程序名>目录
			// 实际测试，写入到/data/user/0/com.Moonlord.MyStudy/files目录下。
			// 第三方应用需要管理员权限才能读取这个位置。
			try {
				java.io.FileOutputStream fout = MainActivity.openFileOutput(fileName, android.content.Context.MODE_PRIVATE);
				byte[] bytes = writestr.getBytes(java.nio.charset.Charset.forName("UTF-8"));
				fout.write(bytes);
				fout.close();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static java.lang.String ReadPrivateFile(java.lang.String fileName) {// 从/data/……/<应用程序名>目录读数据
			java.lang.String res = "";
			try {
				java.io.InputStream in = MainActivity.openFileInput(fileName);
				int length = in.available();
				byte[] buffer = new byte[length];
				in.read(buffer);
				in.close();
				res = org.apache.http.util.EncodingUtils.getString(buffer, "UTF-8");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		public static boolean WriteFile(java.lang.String fileName, java.lang.String writestr) {// 写入文件
			// 文件路径和已有文件夹路径相同时会抛出异常。
			try {
				java.io.File file = new java.io.File(fileName);
				if (!file.exists()) {
					java.io.File DirPath = file.getParentFile();
					DirPath.mkdirs();
				}
				java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
				byte[] bytes = writestr.getBytes(java.nio.charset.Charset.forName("UTF-8"));
				fos.write(bytes);
				fos.close();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static boolean WriteFile(java.lang.String fileName, byte[] bytes) {// 写入文件（重载）
			// 文件路径和已有文件夹路径相同时会抛出异常。
			try {
				java.io.File file = new java.io.File(fileName);
				if (!file.exists()) {
					java.io.File DirPath = file.getParentFile();
					DirPath.mkdirs();
				}
				java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
				fos.write(bytes);
				fos.close();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public static java.lang.String ReadFileAvailable(java.lang.String fileName) {// 读取文件（文件被占用时可能返回空字符串）
			java.lang.String res = "";
			try {
				java.io.File file = new java.io.File(fileName);
				java.io.FileInputStream fis = new java.io.FileInputStream(file);
				int length = fis.available();// 从这个输入流中可无阻塞读取的估算字节数。在文件被占用的情况下可能返回0。
				byte[] buffer = new byte[length];
				fis.read(buffer);
				fis.close();
				res = org.apache.http.util.EncodingUtils.getString(buffer, "UTF-8");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		public static java.lang.String ReadLine(java.lang.String fileName) {// 读取文件（只读第一行）
			java.lang.StringBuffer res = new java.lang.StringBuffer("");
			try {
				java.io.InputStreamReader in = new java.io.InputStreamReader(new java.io.FileInputStream(fileName), "UTF-8");
				java.io.BufferedReader buffer = new java.io.BufferedReader(in);
				java.lang.String inputLine = null;
				if ((inputLine = buffer.readLine()) != null) {
					res.append(inputLine);
				}
				buffer.close();
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res.toString();
		}
		public static java.lang.String ReadFile(java.lang.String fileName) {// 读取文件
			java.lang.StringBuffer res = new java.lang.StringBuffer("");
			try {
				java.io.InputStreamReader in = new java.io.InputStreamReader(new java.io.FileInputStream(fileName), "UTF-8");
				java.io.BufferedReader buffer = new java.io.BufferedReader(in);
				java.lang.String inputLine = null;
				while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
				{
					res.append(inputLine + "\r\n");
				}
				buffer.close();
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return res.toString();
		}
		public static android.graphics.Bitmap ReadImage(java.lang.String fileName) {// 读取图片文件
			android.graphics.Bitmap ResultImage = null;
			try {
				java.io.InputStream in = new java.io.FileInputStream(fileName);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap ReadImage(java.lang.String fileName, android.graphics.BitmapFactory.Options options) {// 读取图片文件（含参数）
			android.graphics.Bitmap ResultImage = null;
			try {
				java.io.InputStream in = new java.io.FileInputStream(fileName);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in, null, options);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap ReadImageLowQuality(java.lang.String fileName) {// 读取图片文件（低质量）
			android.graphics.Bitmap ResultImage = null;
			try {
				android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
				// options.inSampleSize = 2;//长宽像素都减半
				// options.inPreferredConfig =
				// android.graphics.Bitmap.Config.ARGB_4444;//透明图降低质量
				options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;// 非透明的图降低质量
				java.io.InputStream in = new java.io.FileInputStream(fileName);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in, null, options);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap ReadResourceImage(int ResourceId) {// 读取图片文件
			android.graphics.Bitmap ResultImage = null;
			try {
				java.io.InputStream in = MainActivity.getResources().openRawResource(ResourceId);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap ReadResourceImage(int ResourceId, android.graphics.BitmapFactory.Options options) {// 读取图片文件（含参数）
			android.graphics.Bitmap ResultImage = null;
			try {
				java.io.InputStream in = MainActivity.getResources().openRawResource(ResourceId);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in, null, options);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		public static android.graphics.Bitmap ReadResourceImageLowQuality(int ResourceId) {// 读取图片文件（低质量）
			android.graphics.Bitmap ResultImage = null;
			try {
				android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
				// options.inSampleSize = 2;//长宽像素都减半
				// options.inPreferredConfig =
				// android.graphics.Bitmap.Config.ARGB_4444;//透明图降低质量
				options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;// 非透明的图降低质量
				java.io.InputStream in = MainActivity.getResources().openRawResource(ResourceId);
				ResultImage = android.graphics.BitmapFactory.decodeStream(in, null, options);
				in.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResultImage;
		}
		// 手机ROM信息
		public static class Rom {
			public static long TotalSize() {// 总容量（Byte）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getBlockCount();
			}
			public static long AvailableSize() {// 可用容量（Byte）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getAvailableBlocks();
			}
			public static long TotalSizeMB() {// 总容量（MB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getBlockCount() / 1024 / 1024;
			}
			public static long AvailableSizeMB() {// 可用容量（MB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024 / 1024;
			}
			public static java.lang.String TotalSizeString() {// 总容量（实测结果：1.48
																// GB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return android.text.format.Formatter.formatFileSize(MainActivity, stat.getBlockSize() * (long) stat.getBlockCount());
			}
			public static java.lang.String AvailableSizeString() {// 可用容量（实测结果：292
																	// MB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
				return android.text.format.Formatter.formatFileSize(MainActivity, stat.getBlockSize() * (long) stat.getAvailableBlocks());
			}
		}
		// SD卡操作
		public static class SDCard {
			public static java.lang.String Directory = android.os.Environment.getExternalStorageDirectory().toString();// SD卡路径（/storage/sdcard0）
			public static boolean IsEmulate = android.os.Environment.isExternalStorageEmulated();// SD卡是否为内部虚拟SD卡
			public static boolean IsReady() {// SD卡状态是否可读可写
				return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
			}
			public static boolean WriteFile(java.lang.String fileName, java.lang.String writestr) {// 写入SD卡文件
				// 需要权限：
				// <uses-permission
				// android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
				// 文件路径和已有文件夹路径相同时会抛出异常。
				try {
					java.io.File file = new java.io.File(Directory + "/" + fileName);
					if (!file.exists()) {
						java.io.File DirPath = file.getParentFile();
						DirPath.mkdirs();
					}
					java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
					byte[] bytes = writestr.getBytes(java.nio.charset.Charset.forName("UTF-8"));
					fos.write(bytes);
					fos.close();
					return true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public static boolean WriteFile(java.lang.String fileName, byte[] bytes) {// 写入SD卡文件
				// 需要权限：
				// <uses-permission
				// android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
				// 文件路径和已有文件夹路径相同时会抛出异常。
				try {
					java.io.File file = new java.io.File(Directory + "/" + fileName);
					if (!file.exists()) {
						java.io.File DirPath = file.getParentFile();
						DirPath.mkdirs();
					}
					java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
					fos.write(bytes);
					fos.close();
					return true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public static java.lang.String ReadFileAvailable(java.lang.String fileName) {// 读取SD卡文件（文件被占用时可能返回空字符串）
				java.lang.String res = "";
				try {
					java.io.File file = new java.io.File(Directory + "/" + fileName);
					java.io.FileInputStream fis = new java.io.FileInputStream(file);
					int length = fis.available();
					byte[] buffer = new byte[length];
					fis.read(buffer);
					fis.close();
					res = org.apache.http.util.EncodingUtils.getString(buffer, "UTF-8");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return res;
			}
			public static java.lang.String ReadFile(java.lang.String fileName) {// 读取SD文件
				java.lang.StringBuffer res = new java.lang.StringBuffer("");
				try {
					java.io.InputStreamReader in = new java.io.InputStreamReader(new java.io.FileInputStream(Directory + "/" + fileName), "UTF-8");
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);
					java.lang.String inputLine = null;
					while ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						res.append(inputLine + "\r\n");
					}
					buffer.close();
					in.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return res.toString();
			}
			public static java.lang.String ReadLine(java.lang.String fileName) {// 读取SD文件
				java.lang.StringBuffer res = new java.lang.StringBuffer("");
				try {
					java.io.InputStreamReader in = new java.io.InputStreamReader(new java.io.FileInputStream(Directory + "/" + fileName), "UTF-8");
					java.io.BufferedReader buffer = new java.io.BufferedReader(in);
					java.lang.String inputLine = null;
					if ((inputLine = buffer.readLine()) != null)// 使用循环来读取获得的数据
					{
						res.append(inputLine);
					}
					buffer.close();
					in.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return res.toString();
			}
			public static boolean DeleteFile(java.lang.String fileName) {// 删除文件，返回是否删除成功（文件不存在返回true）
				try {
					java.io.File file = new java.io.File(Directory + "/" + fileName);
					file.delete();
					return !file.isFile();// 返回最终结果
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public static boolean MakeDirectory(java.lang.String filePath) {// 建立目录，返回是否建立成功（目录已存在返回true）
				try {
					java.io.File file = new java.io.File(Directory + "/" + filePath);
					file.mkdirs();
					return file.isDirectory();// 返回最终结果
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public static boolean DeleteDirectory(java.lang.String filePath) {// 删除目录，返回是否删除成功（目录已删除返回true）
				try {
					java.io.File file = new java.io.File(Directory + "/" + filePath);
					file.delete();
					return !file.isDirectory();// 返回最终结果
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			public static java.io.File[] FileList(java.lang.String fileName) {// 返回文件夹下面的列表
				if (!new java.io.File(Directory + "/" + fileName).isFile() && !new java.io.File(Directory + "/" + fileName).isDirectory()) {
					return new java.io.File[0];
				}
				if (new java.io.File(Directory + "/" + fileName).listFiles() == null) {
					return new java.io.File[0];
				}
				return new java.io.File(Directory + "/" + fileName).listFiles();
			}
			public static long FileLength(java.lang.String fileName) {// 返回文件长度
				if (!new java.io.File(Directory + "/" + fileName).isFile() && !new java.io.File(Directory + "/" + fileName).isDirectory()) {
					return 0;
				}
				return new java.io.File(Directory + "/" + fileName).length();
			}
			public static long TotalSize() {// SD总容量（字节）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getBlockCount();
			}
			public static long TotalSizeMB() {// SD总容量（MB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getBlockCount() / 1024 / 1024;
			}
			public static long AvailableSize() {// SD可用容量（字节）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getAvailableBlocks();
			}
			public static long AvailableSizeMB() {// SD可用容量（MB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return stat.getBlockSize() * (long) stat.getAvailableBlocks() / 1024 / 1024;
			}
			public static java.lang.String TotalSizeString() {// 总容量（实测结果：29.02
																// GB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return android.text.format.Formatter.formatFileSize(MainActivity, stat.getBlockSize() * (long) stat.getBlockCount());
			}
			public static java.lang.String AvailableSizeString() {// 可用容量（实测结果：25.12
																	// GB）
				android.os.StatFs stat = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
				return android.text.format.Formatter.formatFileSize(MainActivity, stat.getBlockSize() * (long) stat.getAvailableBlocks());
			}
		}
	}
	// Camera操作
	public static class Camera {
		// 声明程序必须要有Camera支持才允许使用：
		// <uses-feature android:name="android.hardware.camera" />
		// 应用程序用到设备摄像头的自动对焦功能：
		// <uses-feature android:name = "android.hardware.camera.autofocus" />
		//
		// 简单切换到系统的照相机软件，无数据交互
		public static void OpenSoftware() {
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
			MainActivity.startActivity(intent);
		}
		//
		// 使用系统照相机拍照并设置View的背景
		public static final int SetBackgroundCode = 1000;
		public static android.view.View SetBackgroundView;
		public static void SetBackground(android.view.View ViewToSetBackground) {
			// 需要权限
			// <uses-permission android:name="android.permission.CAMERA"/>
			SetBackgroundView = ViewToSetBackground;
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			MainActivity.startActivityForResult(intent, SetBackgroundCode);
		}
		//
		// 使用系统照相机拍照并保存为文件
		public static final int SavePhotoCode = 1001;
		public static void SavePhoto(java.lang.String FileName) {
			// 需要权限：
			// <uses-permission
			// android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
			java.io.File file = new java.io.File(FileName);
			if (!file.exists()) {
				java.io.File DirPath = file.getParentFile();
				DirPath.mkdirs();
			}
			android.net.Uri uri = android.net.Uri.fromFile(file);
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
			MainActivity.startActivityForResult(intent, SavePhotoCode);
		}
		public static void SaveSDCardPhoto(java.lang.String FileName) {
			java.io.File file = new java.io.File(My.IO.SDCard.Directory + "/" + FileName);
			if (!file.exists()) {
				java.io.File DirPath = file.getParentFile();
				DirPath.mkdirs();
			}
			android.net.Uri uri = android.net.Uri.fromFile(file);
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
			MainActivity.startActivityForResult(intent, SavePhotoCode);
		}
		//
		// 保存为文件并设置View的背景
		public static final int SavePhotoAndSetBackgroundCode = 1002;
		public static android.view.View SavePhotoAndSetBackgroundView;
		public static java.lang.String SavePhotoAndSetBackgroundFile;
		public static void SavePhotoAndSetBackground(java.lang.String FileName, android.view.View ViewToSetBackground) {
			// 需要权限：
			// <uses-permission
			// android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
			SavePhotoAndSetBackgroundFile = FileName;
			SavePhotoAndSetBackgroundView = ViewToSetBackground;
			java.io.File file = new java.io.File(FileName);
			if (!file.exists()) {
				java.io.File DirPath = file.getParentFile();
				DirPath.mkdirs();
			}
			android.net.Uri uri = android.net.Uri.fromFile(file);
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
			MainActivity.startActivityForResult(intent, SavePhotoAndSetBackgroundCode);
		}
		public static void SaveSDCardPhotoAndSetBackground(java.lang.String FileName, android.view.View ViewToSetBackground) {
			SavePhotoAndSetBackgroundFile = My.IO.SDCard.Directory + "/" + FileName;
			SavePhotoAndSetBackgroundView = ViewToSetBackground;
			java.io.File file = new java.io.File(My.IO.SDCard.Directory + "/" + FileName);
			if (!file.exists()) {
				java.io.File DirPath = file.getParentFile();
				DirPath.mkdirs();
			}
			android.net.Uri uri = android.net.Uri.fromFile(file);
			android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);
			MainActivity.startActivityForResult(intent, SavePhotoAndSetBackgroundCode);
		}
		//
		// 自定义的SurfaceView，使用setContentView或AddView方法进行调用，已经实现了连拍和保存的功能。
		public static class CameraView extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback, android.hardware.Camera.PictureCallback {
			private android.hardware.Camera MyCamera;
			private boolean MouseOnTouch;
			// 构造函数
			public CameraView(android.content.Context context) {
				super(context);
				this.getHolder().addCallback(this);
				My.LogCat.Log("MyCamera-New");
			}
			// SurfaceHolder.Callback接口实现
			@Override
			public void surfaceCreated(android.view.SurfaceHolder holder) {
				MyCamera = android.hardware.Camera.open();
				MyCamera.setDisplayOrientation(90);
				try {
					MyCamera.setPreviewDisplay(this.getHolder());
				}
				catch (java.io.IOException e) {
					e.printStackTrace();
				}
				My.LogCat.Log("MyCamera-surfaceCreated");
			}
			@Override
			public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) {
				MyCamera.startPreview();
				My.LogCat.Log("MyCamera-surfaceChanged");
			}
			@Override
			public void surfaceDestroyed(android.view.SurfaceHolder holder) {
				if (MyCamera != null) {
					MyCamera.stopPreview();
					MyCamera.release();
					MyCamera = null;
				}
				My.LogCat.Log("MyCamera-surfaceDestroyed");
			}
			// 拍照功能
			public void TakePicture(android.hardware.Camera.PictureCallback imageCallback) {
				MyCamera.takePicture(null, null, imageCallback);
				My.LogCat.Log("MyCamera-TakePicture");
			}
			@Override
			public boolean onTouchEvent(android.view.MotionEvent event) {// 屏幕触摸事件
				if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {// 按下时自动对焦
					try {
						MyCamera.autoFocus(null);// 可能失败
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					MouseOnTouch = true;
				}
				else if (event.getAction() == android.view.MotionEvent.ACTION_UP && MouseOnTouch == true) {// 放开后拍照
					try {
						MyCamera.takePicture(null, null, this);// 可能失败
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					performClick();
					MouseOnTouch = false;
				}
				My.LogCat.Log("MyCamera-onTouchEvent");
				return true;
			}
			@Override
			public boolean performClick() {
				// 只是为了消除onTouchEvent的黄色警告。
				// onTouchEvent可能会拦截performClick，系统提示应该在onTouchEvent适当的地方显式地调用performClick。
				return super.performClick();
			}
			// PictureCallback事件回调（保存照片）
			@Override
			public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
				My.IO.SDCard.WriteFile("Picture/" + My.Maths.UniversallyUniqueIdentifier() + ".jpg", data);
				My.Toast.Show("PictureTaken：" + My.IO.SDCard.Directory + "/Picture/" + My.Maths.LastUniversallyUniqueIdentifier() + ".jpg");
				My.LogCat.Log("MyCamera-onPictureTaken");
				MyCamera.startPreview();// 拍照完成后继续预览
			}
		}
		//
		// CameraView的快速调用
		public static void ShowCameraView(android.app.Activity activity) {
			activity.getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
			activity.setContentView(new My.Camera.CameraView(activity));
		}
		public static void ShowCameraView(android.widget.LinearLayout linearLayout) {
			linearLayout.addView(new My.Camera.CameraView(linearLayout.getContext()));
		}
		//
		// 系统图库的快速调用
		public static final int GetPhotoCode = 1003;
		public static android.view.View GetPhotoView;
		public static void GetPhoto(android.view.View ViewToGetPhoto) {
			GetPhotoView = ViewToGetPhoto;
			android.content.Intent intent = new android.content.Intent(android.content.Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			MainActivity.startActivityForResult(intent, GetPhotoCode);
		}
		//
		// 调用系统图库选择和裁剪图片
		public static final int GetCropPhotoCode1 = 1004;
		public static final int GetCropPhotoCode2 = 1005;
		public static int GetCropPhotoSize = 128;// 默认裁剪大小128像素
		public static android.view.View GetCropPhotoView;
		public static void GetCropPhoto(android.view.View ViewToGetPhoto) {
			GetCropPhotoView = ViewToGetPhoto;
			android.content.Intent intent = new android.content.Intent(android.content.Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			MainActivity.startActivityForResult(intent, GetCropPhotoCode1);
		}
		public static void GetCropPhoto(android.view.View ViewToGetPhoto, int CropSize) {
			GetCropPhotoView = ViewToGetPhoto;
			GetCropPhotoSize = CropSize;
			android.content.Intent intent = new android.content.Intent(android.content.Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			MainActivity.startActivityForResult(intent, GetCropPhotoCode1);
		}
	}
	// 震动操作
	public static class Vibrator {
		// 需要权限：
		// <uses-permission android:name="android.permission.VIBRATE"/>
		public static android.os.Vibrator MyVibrator = (android.os.Vibrator) MainActivity.getSystemService(android.content.Context.VIBRATOR_SERVICE);
		// pattern数组的值依次表示：等待/开启/关闭/开启/关闭/……的时间。
		// repeat指定pattern数组的索引，指定pattern数组中从repeat索引开始的振动进行循环。
		// -1表示只振动一次，非-1表示从 pattern的指定下标开始重复振动。
		public static void Pattern(long[] pattern, int repeat) {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.vibrate(pattern, repeat);
			}
		}
		public static void Pattern(long[] pattern) {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.vibrate(pattern, -1);
			}
		}
		public static void Once(long milliseconds) {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.vibrate(milliseconds);
			}
		}
		public static void Cancel() {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.cancel();
			}
		}
		public static void Cancel(long delay) {
			if (MyVibrator.hasVibrator()) {
				My.MainActivity.Handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						MyVibrator.cancel();
					}
				}, delay);
			}
		}
		// 依次震动、等待的重复振动模式，参数为振动时间，等待时间，重复次数。
		public static void Repeat(long on, long off, int repeat) {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.vibrate(new long[] { 0, on, off }, 0);
			}
			Cancel((on + off) * repeat);
		}
		public static void Repeat(long on, long off) {
			if (MyVibrator.hasVibrator()) {
				MyVibrator.vibrate(new long[] { 0, on, off }, 0);
			}
		}
		// 参数为振动时间，等待时间，总时间限制（结束震动时间）。
		public static void RepeatAndCancel(long on, long off, long end) {
			Repeat(on, off);
			Cancel(end);
		}
	}
	// UI定时器操作
	public static class Timer {
		// FixedTimerTask的执行频率是固定的（UI线程操作）
		public static abstract class FixedTimerTask implements Runnable {
			private FixedTimerTask Me;
			public java.util.Timer Timer;
			public java.util.TimerTask Task;
			public FixedTimerTask(long IntervalMs) {
				Me = this;
				Timer = new java.util.Timer(true);
				Task = new java.util.TimerTask() {
					public void run() {
						My.MainActivity.Handler.post(Me);
					}
				};
				Timer.scheduleAtFixedRate(Task, 0, IntervalMs);
			}
			public FixedTimerTask(long IntervalMs, long DelayMs) {
				Me = this;
				Timer = new java.util.Timer(true);
				Task = new java.util.TimerTask() {
					public void run() {
						My.MainActivity.Handler.post(Me);
					}
				};
				Timer.scheduleAtFixedRate(Task, DelayMs, IntervalMs);
			}
			public void Cancel() {
				Timer.cancel();
				Timer = null;
				Task.cancel();
				Task = null;
				Me = null;
			}
			// 需要实现的接口
			@Override
			public abstract void run();
		}
		// IntervalTimerTask的执行间隔时间是固定的（UI线程操作）
		public static abstract class IntervalTimerTask implements Runnable {
			private IntervalTimerTask Me;
			public java.util.Timer Timer;
			public java.util.TimerTask Task;
			public IntervalTimerTask(long IntervalMs) {
				Me = this;
				Timer = new java.util.Timer(true);
				Task = new java.util.TimerTask() {
					public void run() {
						My.MainActivity.Handler.post(Me);
					}
				};
				Timer.schedule(Task, 0, IntervalMs);
			}
			public IntervalTimerTask(long IntervalMs, long DelayMs) {
				Me = this;
				Timer = new java.util.Timer(true);
				Task = new java.util.TimerTask() {
					public void run() {
						My.MainActivity.Handler.post(Me);
					}
				};
				Timer.schedule(Task, DelayMs, IntervalMs);
			}
			public void Cancel() {
				Timer.cancel();
				Timer = null;
				Task.cancel();
				Task = null;
				Me = null;
			}
			// 需要实现的接口
			public abstract void run();
		}
		// NewRunnable在UI线程（可延时）进行一次性操作
		public static abstract class NewUIRunnable implements Runnable {
			private Runnable Me;
			public NewUIRunnable() {
				Me = this;
				new Thread(new Runnable() {
					@Override
					public void run() {
						My.MainActivity.Handler.post(Me);
					}
				}).start();
			}
			public NewUIRunnable(final long DelayMs) {
				Me = this;
				new Thread(new Runnable() {
					@Override
					public void run() {
						My.MainActivity.Handler.postDelayed(Me, DelayMs);
					}
				}).start();
			}
			// 需要实现的接口
			@Override
			public abstract void run();
		}
		// NewRunnable在UI线程（可延时）进行一次性操作
		public static abstract class NewThreadRunnable implements Runnable {
			private Thread Me;
			public NewThreadRunnable() {
				Me = new Thread(this);
				Me.start();
			}
			public NewThreadRunnable(final long DelayMs) {
				Me = new Thread(this);
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(DelayMs);
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
						Me.start();
					}
				}).start();
			}
			// 需要实现的接口
			@Override
			public abstract void run();
		}
	}
	// 通知栏操作
	public static class Notification {
		// 显示一个通知栏消息（最少需要的参数：图片、标题、文本）
		// 图片过大时，小图标的预览图仍为正常图片。划开通知栏看到的图片，系统会自动裁剪中间的部分显示。
		// 文本过长时，会自动显示为省略号（换行符会被转为空格，并不能换行）。
		public static void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message);
			NM.notify(0, NCB.build());
		}
		// 显示一个通知栏消息（参数：图片、标题、文本、屏幕上方的上升动画提示文本）
		// Ticker：庆祝、欢迎等场合所散发的五彩纸带。
		public static void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
			NM.notify(0, NCB.build());
		}
		// 显示一个通知栏消息（参数：图片、标题、文本、通知栏滑动块的右下角显示的数字）
		// 通知栏滑动块的右上角默认会显示通知的时间。
		// 数字大于999时会显示为999+。
		public static void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number);
			NM.notify(0, NCB.build());
		}
		// 显示一个通知栏消息（参数：图片、标题、文本、数字、提示）
		public static void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number);
			NM.notify(0, NCB.build());
		}
		// 不可被用户移除的通知（程序内清除或者程序结束才会消失）
		public static void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(1, mNotification);
		}
		public static void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(1, mNotification);
		}
		public static void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(1, mNotification);
		}
		public static void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(1, mNotification);
		}
		// 点击后跳转到Activity的通知（可以被用户移除）
		public static void Redirect(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentIntent(pendingIntent);
			NM.notify(2, NCB.build());
		}
		public static void Redirect(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setContentIntent(pendingIntent);
			NM.notify(2, NCB.build());
		}
		public static void Redirect(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number).setContentIntent(pendingIntent);
			NM.notify(2, NCB.build());
		}
		public static void Redirect(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number).setContentIntent(pendingIntent);
			NM.notify(2, NCB.build());
		}
		// 点击后跳转到Activity的通知（用户点击后自动移除）
		public static void RedirectOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(3, NCB.build());
		}
		public static void RedirectOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(3, NCB.build());
		}
		public static void RedirectOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(3, NCB.build());
		}
		public static void RedirectOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(3, NCB.build());
		}
		// 点击后跳转到Activity的通知（程序内清除或者程序结束才会消失）
		public static void RedirectHold(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentIntent(pendingIntent);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(4, mNotification);
		}
		public static void RedirectHold(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setContentIntent(pendingIntent);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(4, mNotification);
		}
		public static void RedirectHold(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number).setContentIntent(pendingIntent);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(4, mNotification);
		}
		public static void RedirectHold(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.content.Intent resultIntent = new android.content.Intent(MainActivity, com.MoonLord.MyStudy.MainActivity.class);
			resultIntent.setFlags(android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, resultIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number).setContentIntent(pendingIntent);
			android.app.Notification mNotification = NCB.build();
			mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
			NM.notify(4, mNotification);
		}
		// 点击后打开APK的通知
		public static void OpenOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String fileName) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			java.io.File file = new java.io.File(fileName);
			android.content.Intent intent = new android.content.Intent();
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, intent, 0);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(5, NCB.build());
		}
		public static void OpenOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage, java.lang.String fileName) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			java.io.File file = new java.io.File(fileName);
			android.content.Intent intent = new android.content.Intent();
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, intent, 0);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(5, NCB.build());
		}
		public static void OpenOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String fileName) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			java.io.File file = new java.io.File(fileName);
			android.content.Intent intent = new android.content.Intent();
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, intent, 0);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setNumber(Number).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(5, NCB.build());
		}
		public static void OpenOnce(int ImageResourceId, java.lang.String Title, java.lang.String Message, int Number, java.lang.String TickerMessage, java.lang.String fileName) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			java.io.File file = new java.io.File(fileName);
			android.content.Intent intent = new android.content.Intent();
			intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(android.net.Uri.fromFile(file), "application/vnd.android.package-archive");
			android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(MainActivity, 0, intent, 0);
			NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage).setNumber(Number).setContentIntent(pendingIntent).setAutoCancel(true);
			NM.notify(5, NCB.build());
		}
		// 大视图通知，只支持安卓4.1及以上，当通知处在顶端，或者用户手动滑动展开时显示为大视图
		public static void ShowInbox(int ImageResourceId, java.lang.String Title, java.lang.String Summary, java.lang.String[] Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.InboxStyle NCBPS = new android.support.v4.app.NotificationCompat.InboxStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			for (int i = 0; i < Message.length; i++) {
				NCBPS.addLine(Message[i]);// 大视图的文本
			}
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			;
			NM.notify(6, NCB.build());
		}
		public static void ShowInbox(int ImageResourceId, java.lang.String Title, java.lang.String Summary, java.lang.String Message) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.InboxStyle NCBPS = new android.support.v4.app.NotificationCompat.InboxStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			java.lang.String[] temp = Message.split("\r\n");
			for (int i = 0; i < temp.length; i++) {
				NCBPS.addLine(temp[i]);// 大视图的文本
			}
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			;
			NM.notify(6, NCB.build());
		}
		public static void ShowInbox(int ImageResourceId, java.lang.String Title, java.lang.String Summary, java.lang.String[] Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.InboxStyle NCBPS = new android.support.v4.app.NotificationCompat.InboxStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			for (int i = 0; i < Message.length; i++) {
				NCBPS.addLine(Message[i]);// 大视图的文本
			}
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			.setTicker(TickerMessage)// 提示文本
			;
			NM.notify(6, NCB.build());
		}
		public static void ShowInbox(int ImageResourceId, java.lang.String Title, java.lang.String Summary, java.lang.String Message, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.InboxStyle NCBPS = new android.support.v4.app.NotificationCompat.InboxStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			java.lang.String[] temp = Message.split("\r\n");
			for (int i = 0; i < temp.length; i++) {
				NCBPS.addLine(temp[i]);// 大视图的文本
			}
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			.setTicker(TickerMessage)// 提示文本
			;
			NM.notify(6, NCB.build());
		}
		// 显示一张图片的通知
		public static void ShowPicture(int ImageResourceId, java.lang.String Title, java.lang.String Summary, int PictureResourceId) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.BigPictureStyle NCBPS = new android.support.v4.app.NotificationCompat.BigPictureStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			NCBPS.bigPicture(android.graphics.BitmapFactory.decodeResource(MainActivity.getResources(), PictureResourceId));
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			;
			NM.notify(7, NCB.build());
		}
		public static void ShowPicture(int ImageResourceId, java.lang.String Title, java.lang.String Summary, int PictureResourceId, java.lang.String TickerMessage) {
			android.app.NotificationManager NM = (android.app.NotificationManager) MainActivity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
			android.support.v4.app.NotificationCompat.Builder NCB = new android.support.v4.app.NotificationCompat.Builder(MainActivity);
			android.support.v4.app.NotificationCompat.BigPictureStyle NCBPS = new android.support.v4.app.NotificationCompat.BigPictureStyle();
			NCBPS.setBigContentTitle(Title);// 大视图的标题
			NCBPS.setSummaryText(Summary);// 大视图的摘要
			NCBPS.bigPicture(android.graphics.BitmapFactory.decodeResource(MainActivity.getResources(), PictureResourceId));
			NCB.setSmallIcon(ImageResourceId)// 图标
			.setContentTitle(Title)// 小视图的标题
			.setContentText(Summary)// 小视图的文本
			.setStyle(NCBPS)// 大视图的风格
			.setTicker(TickerMessage)// 提示文本
			;
			NM.notify(7, NCB.build());
		}
	}
	// 图片裁剪操作
	public static class Image {
		// /*【 示例用法】*/
		// Bitmap aBitmap = My.IO.ReadResourceImage(R.drawable.a1);//1537600
		// My.LogCat.Log(aBitmap);//768800
		// aBitmap = My.IO.ReadResourceImageLowQuality(R.drawable.a1);
		// My.LogCat.Log(aBitmap);//768800
		// Bitmap bitmap;
		// bitmap = My.Image.CutCenter(aBitmap, 300, 400);
		// My.LogCat.Log(bitmap);//480K
		// bitmap = My.Image.CutCenterLowQuality(aBitmap, 300, 400);
		// My.LogCat.Log(bitmap);//240K
		// bitmap = My.Image.FitSize(aBitmap, 300, 400);
		// My.LogCat.Log(bitmap);//360K
		// bitmap = My.Image.FitSizeLowQuality(aBitmap, 300, 400);
		// My.LogCat.Log(bitmap);//180K
		// rootView.setBackgroundDrawable(new BitmapDrawable(bitmap));
		//
		// 裁剪图片（图片大小已确定，不拉伸变形，尽量取出最大范围的原图）
		public static android.graphics.Bitmap CutCenter(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
			// 原始图大小
			int SourceHeight = SourceBitmap.getHeight();
			int SourceWidth = SourceBitmap.getWidth();
			// 图片高宽比率
			float SourceRatio = (float) SourceHeight / (float) SourceWidth;
			float Ratio = (float) Height / (float) Width;
			// 裁剪范围
			android.graphics.Rect srcRect;
			android.graphics.Rect dstRect = new android.graphics.Rect(0, 0, Width, Height);
			// 原始图较高（以宽度为限制，尽量取出最高）
			if (SourceRatio > Ratio) {
				final int srcRectHeight = (int) (SourceWidth * Ratio); // 高度
				final int scrRectTop = (int) (SourceHeight - srcRectHeight) / 2; // 上边距
				srcRect = new android.graphics.Rect(0, scrRectTop, SourceWidth, scrRectTop + srcRectHeight);
			}
			// 原始图较宽（以高度为限制，尽量取出最宽）
			else {
				final int srcRectWidth = (int) (SourceHeight / Ratio); // 宽度
				final int srcRectLeft = (int) (SourceWidth - srcRectWidth) / 2; // 左边距
				srcRect = new android.graphics.Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, SourceHeight); // 左边距，上边距，宽度，高度
			}
			// 生成图片
			android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(Width, Height, android.graphics.Bitmap.Config.ARGB_8888);// 最佳质量
			android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
			canvas.drawBitmap(SourceBitmap, srcRect, dstRect, new android.graphics.Paint(android.graphics.Paint.FILTER_BITMAP_FLAG | android.graphics.Paint.ANTI_ALIAS_FLAG));// 抗锯齿
			return TargetBitmap;
		}
		// 重载：裁剪图片并降低质量
		public static android.graphics.Bitmap CutCenterLowQuality(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
			// 原始图大小
			int SourceHeight = SourceBitmap.getHeight();
			int SourceWidth = SourceBitmap.getWidth();
			// 图片高宽比率
			float SourceRatio = (float) SourceHeight / (float) SourceWidth;
			float Ratio = (float) Height / (float) Width;
			// 裁剪范围
			android.graphics.Rect srcRect;
			android.graphics.Rect dstRect = new android.graphics.Rect(0, 0, Width, Height);
			// 原始图较高（以宽度为限制，尽量取出最高）
			if (SourceRatio > Ratio) {
				final int srcRectHeight = (int) (SourceWidth * Ratio); // 高度
				final int scrRectTop = (int) (SourceHeight - srcRectHeight) / 2; // 上边距
				srcRect = new android.graphics.Rect(0, scrRectTop, SourceWidth, scrRectTop + srcRectHeight);
			}
			// 原始图较宽（以高度为限制，尽量取出最宽）
			else {
				final int srcRectWidth = (int) (SourceHeight / Ratio); // 宽度
				final int srcRectLeft = (int) (SourceWidth - srcRectWidth) / 2; // 左边距
				srcRect = new android.graphics.Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, SourceHeight); // 左边距，上边距，宽度，高度
			}
			// 生成图片
			android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(Width, Height, android.graphics.Bitmap.Config.RGB_565);// 降低质量
			android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
			canvas.drawBitmap(SourceBitmap, srcRect, dstRect, null);// 不抗锯齿
			return TargetBitmap;
		}
		// 缩放图片（图片大小已限制，不拉伸变形，原图缩放到最大范围）
		public static android.graphics.Bitmap FitSize(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
			// 原始图大小
			int SourceHeight = SourceBitmap.getHeight();
			int SourceWidth = SourceBitmap.getWidth();
			// 图片高宽比率
			float SourceRatio = (float) SourceHeight / (float) SourceWidth;
			float Ratio = (float) Height / (float) Width;
			// 裁剪范围
			android.graphics.Rect srcRect = new android.graphics.Rect(0, 0, SourceWidth, SourceHeight);
			android.graphics.Rect dstRect;
			// 原始图较高（以宽度为限制，尽量取出最高）
			if (SourceRatio > Ratio) {
				dstRect = new android.graphics.Rect(0, 0, (int) (Height / SourceRatio), Height);
			}
			// 原始图较宽（以高度为限制，尽量取出最宽）
			else {
				dstRect = new android.graphics.Rect(0, 0, Width, (int) (Width * SourceRatio)); // 左边距，上边距，宽度，高度
			}
			// 生成图片
			android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(dstRect.width(), dstRect.height(), android.graphics.Bitmap.Config.ARGB_8888);// 最佳质量
			android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
			canvas.drawBitmap(SourceBitmap, srcRect, dstRect, new android.graphics.Paint(android.graphics.Paint.FILTER_BITMAP_FLAG | android.graphics.Paint.ANTI_ALIAS_FLAG));// 抗锯齿
			return TargetBitmap;
		}
		// 重载：缩放图片并降低质量
		public static android.graphics.Bitmap FitSizeLowQuality(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
			// 原始图大小
			int SourceHeight = SourceBitmap.getHeight();
			int SourceWidth = SourceBitmap.getWidth();
			// 图片高宽比率
			float SourceRatio = (float) SourceHeight / (float) SourceWidth;
			float Ratio = (float) Height / (float) Width;
			// 裁剪范围
			android.graphics.Rect srcRect = new android.graphics.Rect(0, 0, SourceWidth, SourceHeight);
			android.graphics.Rect dstRect;
			// 原始图较高（以宽度为限制，尽量取出最高）
			if (SourceRatio > Ratio) {
				dstRect = new android.graphics.Rect(0, 0, (int) (Height / SourceRatio), Height);
			}
			// 原始图较宽（以高度为限制，尽量取出最宽）
			else {
				dstRect = new android.graphics.Rect(0, 0, Width, (int) (Width * SourceRatio)); // 左边距，上边距，宽度，高度
			}
			// 生成图片
			android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(dstRect.width(), dstRect.height(), android.graphics.Bitmap.Config.RGB_565);// 降低质量
			android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
			canvas.drawBitmap(SourceBitmap, srcRect, dstRect, null);// 不抗锯齿
			return TargetBitmap;
		}
	}
}
