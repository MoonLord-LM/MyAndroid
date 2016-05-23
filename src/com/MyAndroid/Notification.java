package com.MyAndroid;

// 通知栏消息
//（动态类+静态函数库）
public class Notification {
	private android.app.Activity MyActivity;
	public Notification(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 显示消息（包含标题、文字、消息时间，滑动可删除）
	public static void Show(android.app.Activity Activity, java.lang.String Title, java.lang.String Message) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setContentTitle(Title).setContentText(Message);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含图标、标题、文字、消息时间，滑动可删除）
	public static void Show(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含图标、标题、文字、消息时间、消息提示，滑动可删除）
	public static void Show(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含标题、文字、消息时间、上升气泡提示，滑动可删除）
	public static void ShowWithTicker(android.app.Activity Activity, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含图标、标题、文字、消息时间、上升气泡提示，滑动可删除）
	public static void ShowWithTicker(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含图标、标题、文字、消息时间、消息提示、上升气泡提示，滑动可删除）
	public static void ShowWithTicker(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info).setTicker(TickerMessage);
		NM.notify(0, NCB.getNotification());
	}
	// 显示消息（包含标题、文字、消息时间，滑动不可删除）
	public static void Hold(android.app.Activity Activity, java.lang.String Title, java.lang.String Message) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setContentTitle(Title).setContentText(Message);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（包含图标、标题、文字、消息时间，滑动不可删除）
	public static void Hold(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（包含图标、标题、文字、消息时间、消息提示，滑动不可删除）
	public static void Hold(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（包含标题、文字、消息时间、上升气泡提示，滑动不可删除）
	public static void HoldWithTicker(android.app.Activity Activity, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（包含图标、标题、文字、消息时间、上升气泡提示，滑动不可删除）
	public static void HoldWithTicker(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setTicker(TickerMessage);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（包含图标、标题、文字、消息时间、消息提示、上升气泡提示，滑动不可删除）
	public static void HoldWithTicker(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info).setTicker(TickerMessage);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(1, mNotification);
	}
	// 显示消息（点击后执行指定的Intent，例如Activity跳转等，滑动可删除）
	public static void ShowIntent(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage, android.content.Intent Intent) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(Activity, 0, Intent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info).setTicker(TickerMessage).setContentIntent(pendingIntent);
		NM.notify(2, NCB.getNotification());
	}
	// 显示消息（点击后执行指定的Intent，例如Activity跳转等，滑动可删除，点击后自动删除）
	public static void ShowIntentOnce(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage, android.content.Intent Intent) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(Activity, 0, Intent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info).setTicker(TickerMessage).setContentIntent(pendingIntent).setAutoCancel(true);
		NM.notify(2, NCB.getNotification());
	}
	// 显示消息（点击后执行指定的Intent，例如Activity跳转等，滑动不可删除）
	public static void HoldIntent(android.app.Activity Activity, int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage, android.content.Intent Intent) {
		android.app.NotificationManager NM = (android.app.NotificationManager) Activity.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		android.app.Notification.Builder NCB = new android.app.Notification.Builder(Activity);
		android.app.PendingIntent pendingIntent = android.app.PendingIntent.getActivity(Activity, 0, Intent, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
		NCB.setSmallIcon(ImageResourceId).setContentTitle(Title).setContentText(Message).setContentInfo(Info).setTicker(TickerMessage).setContentIntent(pendingIntent);
		android.app.Notification mNotification = NCB.getNotification();
		mNotification.flags = android.app.Notification.FLAG_ONGOING_EVENT;
		NM.notify(2, mNotification);
	}
	public void Show(java.lang.String Title, java.lang.String Message) {
		Show(MyActivity, Title, Message);
	}
	public void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
		Show(MyActivity, ImageResourceId, Title, Message);
	}
	public void Show(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info) {
		Show(MyActivity, ImageResourceId, Title, Message, Info);
	}
	public void ShowWithTicker(java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		ShowWithTicker(MyActivity, Title, Message, TickerMessage);
	}
	public void ShowWithTicker(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		ShowWithTicker(MyActivity, ImageResourceId, Title, Message, TickerMessage);
	}
	public void ShowWithTicker(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage) {
		ShowWithTicker(MyActivity, ImageResourceId, Title, Message, Info, TickerMessage);
	}
	public void Hold(java.lang.String Title, java.lang.String Message) {
		Hold(MyActivity, Title, Message);
	}
	public void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message) {
		Hold(MyActivity, ImageResourceId, Title, Message);
	}
	public void Hold(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info) {
		Hold(MyActivity, ImageResourceId, Title, Message, Info);
	}
	public void HoldWithTicker(java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		HoldWithTicker(MyActivity, Title, Message, TickerMessage);
	}
	public void HoldWithTicker(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String TickerMessage) {
		HoldWithTicker(MyActivity, ImageResourceId, Title, Message, TickerMessage);
	}
	public void HoldWithTicker(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage) {
		HoldWithTicker(MyActivity, ImageResourceId, Title, Message, Info, TickerMessage);
	}
	public void ShowIntent(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage, android.content.Intent Intent) {
		ShowIntent(MyActivity, ImageResourceId, Title, Message, Info, TickerMessage, Intent);
	}
	public void HoldIntent(int ImageResourceId, java.lang.String Title, java.lang.String Message, java.lang.String Info, java.lang.String TickerMessage, android.content.Intent Intent) {
		HoldIntent(MyActivity, ImageResourceId, Title, Message, Info, TickerMessage, Intent);
	}
}
