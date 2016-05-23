package com.MyAndroid;

// Intent交互
//（动态类+静态函数库）
// 需要权限：<uses-permission android:name="android.permission.CALL_PHONE" />
// 需要权限：<uses-permission android:name="android.permission.SEND_SMS" />
public class Intent {
	private android.app.Activity MyActivity;
	public Intent(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 打开安卓默认短信界面（ SMS：Short Message Service，可选择发送号码和短信内容，多个号码可用英文逗号隔开）
	// （可能会让用户选择短信、通讯助手、应用宝、360手机助手、金山手机助手、百度云、猎豹安全大师等App中的一个）
	public static void ShowSms(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SENDTO);
		intent.setData(android.net.Uri.parse("smsto:"));
		intent.putExtra("sms_body", "");
		Activity.startActivity(intent);
	}
	public static void ShowSms(android.app.Activity Activity, java.lang.String PhoneNumber) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SENDTO);
		intent.setData(android.net.Uri.parse("smsto:" + PhoneNumber));
		intent.putExtra("sms_body", "");
		Activity.startActivity(intent);
	}
	public static void ShowSms(android.app.Activity Activity, java.lang.String PhoneNumber, java.lang.String SmsBody) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SENDTO);
		intent.setData(android.net.Uri.parse("smsto:" + PhoneNumber));
		intent.putExtra("sms_body", SmsBody);
		Activity.startActivity(intent);
	}
	// 不经过用户允许，后台静默发送短信（谨慎测试）
	public static void SendSms(java.lang.String PhoneNumber, java.lang.String SmsBody) {
		android.telephony.SmsManager manager = android.telephony.SmsManager.getDefault();
		manager.sendTextMessage(PhoneNumber, null, SmsBody, null, null);
	}
	// 打开安卓默认拨号界面
	public static void ShowDial(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_DIAL);
		intent.setData(android.net.Uri.parse("tel:"));
		Activity.startActivity(intent);
	}
	public static void ShowDial(android.app.Activity Activity, java.lang.String PhoneNumber) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_DIAL);
		intent.setData(android.net.Uri.parse("tel:" + PhoneNumber));
		Activity.startActivity(intent);
	}
	// 对指定号码直接进行拨号通话
	public static void CallPhone(android.app.Activity Activity, java.lang.String PhoneNumber) {
		try {
			android.content.Intent intent = new android.content.Intent();
			intent.setAction(android.content.Intent.ACTION_CALL);
			intent.setData(android.net.Uri.parse("tel:" + PhoneNumber));
			Activity.startActivity(intent);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 打开安卓默认桌面
	public static void ShowHome(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_MAIN);
		intent.addCategory(android.content.Intent.CATEGORY_HOME);
		Activity.startActivity(intent);
	}
	// 打开安卓拍照界面
	public static void ShowCamera(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
		Activity.startActivity(intent);
	}
	// 打开安卓录像界面
	public static void ShowVideoCamera(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.INTENT_ACTION_VIDEO_CAMERA);
		Activity.startActivity(intent);
	}
	// 打开安卓音乐播放器
	public static void ShowMusicPlayer(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.INTENT_ACTION_MUSIC_PLAYER);
		Activity.startActivity(intent);
	}
	// 打开指定的URL（浏览器）
	public static void ShowURL(android.app.Activity Activity, java.lang.String URL) {
		if (!URL.toLowerCase(java.util.Locale.CHINA).startsWith("http://") && !URL.toLowerCase(java.util.Locale.CHINA).startsWith("https://") && !URL.toLowerCase(java.util.Locale.CHINA).startsWith("ftp://")) {
			URL = "http://" + URL;
		}
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setData(android.net.Uri.parse(URL));
		Activity.startActivity(intent);
	}
	// 打开安卓默认发送邮件界面（用户选择QQ邮箱则可以识别所有参数，选择QQ则只识别邮件内容，CarbonCopied 抄送人）
	public static void ShowEmail(android.app.Activity Activity, java.lang.String EmailAddress) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SENDTO);
		intent.setData(android.net.Uri.parse("mailto:" + EmailAddress));
		Activity.startActivity(intent);
	}
	public static void ShowEmail(android.app.Activity Activity, java.lang.String EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
		intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
		Activity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
	}
	public static void ShowEmail(android.app.Activity Activity, java.lang.String[] EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
		intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
		Activity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
	}
	public static void ShowEmail(android.app.Activity Activity, java.lang.String EmailAddress, java.lang.String CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
		intent.putExtra(android.content.Intent.EXTRA_CC, CarbonCopied);
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
		intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
		Activity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
	}
	public static void ShowEmail(android.app.Activity Activity, java.lang.String[] EmailAddress, java.lang.String[] CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAddress);
		intent.putExtra(android.content.Intent.EXTRA_CC, CarbonCopied);
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, EmailTitle);
		intent.putExtra(android.content.Intent.EXTRA_TEXT, EmailBody);
		Activity.startActivity(android.content.Intent.createChooser(intent, "选择用来发送邮件的程序"));
	}
	// 打开安卓默认地图界面
	public static void ShowMap(android.app.Activity Activity) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setData(android.net.Uri.parse("geo:"));
		Activity.startActivity(intent);
	}
	public static void ShowMap(android.app.Activity Activity, android.graphics.Point Point) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setData(android.net.Uri.parse("geo:" + Point.x + "," + Point.y));
		Activity.startActivity(intent);
	}
	public static void ShowMap(android.app.Activity Activity, float LocationX, float LocationY) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setData(android.net.Uri.parse("geo:" + LocationX + "," + LocationY));
		Activity.startActivity(intent);
	}
	// 打开磁盘上的APK文件
	public static void OpenApkFile(android.app.Activity Activity, java.lang.String FilePath) {
		android.content.Intent intent = new android.content.Intent();
		intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(FilePath)), "application/vnd.android.package-archive");
		Activity.startActivity(intent);
	}
	// 打开磁盘上的TXT文件
	public static void OpenTxtFile(android.app.Activity Activity, java.lang.String FilePath) {
		android.content.Intent intent = new android.content.Intent();
		intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(FilePath)), "text/plain");
		Activity.startActivity(intent);
	}
	// 打开磁盘上的视频文件
	public static void OpenVideoFile(android.app.Activity Activity, java.lang.String FilePath) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(FilePath)), "video/*");
		Activity.startActivity(intent);
	}
	// 打开磁盘上的图片文件
	public static void OpenImageFile(android.app.Activity Activity, java.lang.String FilePath) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(FilePath)), "image/*");
		Activity.startActivity(intent);
	}
	// 打开磁盘上的音频文件
	public static void OpenAudioFile(android.app.Activity Activity, java.lang.String FilePath) {
		android.content.Intent intent = new android.content.Intent();
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(FilePath)), "audio/*");
		Activity.startActivity(intent);
	}
	public void ShowSms() {
		ShowSms(MyActivity);
	}
	public void ShowSms(java.lang.String PhoneNumber) {
		ShowSms(MyActivity, PhoneNumber);
	}
	public void ShowSms(java.lang.String PhoneNumber, java.lang.String SmsBody) {
		ShowSms(MyActivity, PhoneNumber, SmsBody);
	}
	public void ShowDial() {
		ShowDial(MyActivity);
	}
	public void ShowDial(java.lang.String PhoneNumber) {
		ShowDial(MyActivity, PhoneNumber);
	}
	public void ShowCall(java.lang.String PhoneNumber) {
		CallPhone(MyActivity, PhoneNumber);
	}
	public void ShowHome() {
		ShowHome(MyActivity);
	}
	public void ShowCamera() {
		ShowCamera(MyActivity);
	}
	public void ShowVideoCamera() {
		ShowVideoCamera(MyActivity);
	}
	public void ShowMusicPlayer() {
		ShowMusicPlayer(MyActivity);
	}
	public void ShowURL(java.lang.String URL) {
		ShowURL(MyActivity, URL);
	}
	public void ShowEmail(java.lang.String EmailAddress) {
		ShowEmail(MyActivity, EmailAddress);
	}
	public void ShowEmail(java.lang.String EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
		ShowEmail(MyActivity, EmailAddress, EmailTitle, EmailBody);
	}
	public void ShowEmail(java.lang.String[] EmailAddress, java.lang.String EmailTitle, java.lang.String EmailBody) {
		ShowEmail(MyActivity, EmailAddress, EmailTitle, EmailBody);
	}
	public void ShowEmail(java.lang.String EmailAddress, java.lang.String CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
		ShowEmail(MyActivity, EmailAddress, CarbonCopied, EmailTitle, EmailBody);
	}
	public void ShowEmail(java.lang.String[] EmailAddress, java.lang.String[] CarbonCopied, java.lang.String EmailTitle, java.lang.String EmailBody) {
		ShowEmail(MyActivity, EmailAddress, CarbonCopied, EmailTitle, EmailBody);
	}
	public void ShowMap() {
		ShowMap(MyActivity);
	}
	public void ShowMap(android.graphics.Point Point) {
		ShowMap(MyActivity, Point);
	}
	public void ShowMap(float LocationX, float LocationY) {
		ShowMap(MyActivity, LocationX, LocationY);
	}
	public void OpenApkFile(java.lang.String FilePath) {
		OpenApkFile(MyActivity, FilePath);
	}
	public void OpenTxtFile(java.lang.String FilePath) {
		OpenTxtFile(MyActivity, FilePath);
	}
	public void OpenVideoFile(java.lang.String FilePath) {
		OpenVideoFile(MyActivity, FilePath);
	}
	public void OpenImageFile(java.lang.String FilePath) {
		OpenImageFile(MyActivity, FilePath);
	}
	public void OpenAudioFile(java.lang.String FilePath) {
		OpenAudioFile(MyActivity, FilePath);
	}
}
