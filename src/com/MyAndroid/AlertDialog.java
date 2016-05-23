package com.MyAndroid;

//使用AlertDialog输出信息
//（动态类+静态函数库）
public class AlertDialog {
	private android.app.Activity MyActivity;
	public AlertDialog(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	public void Show(Object Message) {
		new android.app.AlertDialog.Builder(MyActivity).setMessage(java.lang.String.valueOf(Message)).show();
	}
	public void Show(Object Title, Object Message) {
		new android.app.AlertDialog.Builder(MyActivity).setTitle(java.lang.String.valueOf(Title)).setMessage(java.lang.String.valueOf(Message)).show();
	}
	public void ShowItems(java.lang.String[] Items) {
		new android.app.AlertDialog.Builder(MyActivity).setItems(Items, null).show();
	}
	public void ShowItems(Object Title, java.lang.String[] Items) {
		new android.app.AlertDialog.Builder(MyActivity).setTitle(java.lang.String.valueOf(Title)).setItems(Items, null).show();
	}
	public void ShowImage(int ImageResourceId) {
		android.widget.ImageView view = new android.widget.ImageView(MyActivity);
		view.setImageResource(ImageResourceId);
		view.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		// view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
		new android.app.AlertDialog.Builder(MyActivity).setView(view).show();
	}
	public void ShowImage(Object Title, int ImageResourceId) {
		android.widget.ImageView view = new android.widget.ImageView(MyActivity);
		view.setImageResource(ImageResourceId);
		view.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		// view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
		new android.app.AlertDialog.Builder(MyActivity).setView(view).setTitle(java.lang.String.valueOf(Title)).show();
	}
	public static void Show(android.app.Activity Activity, Object Message) {
		new android.app.AlertDialog.Builder(Activity).setMessage(java.lang.String.valueOf(Message)).show();
	}
	public static void Show(android.app.Activity Activity, Object Title, Object Message) {
		new android.app.AlertDialog.Builder(Activity).setTitle(java.lang.String.valueOf(Title)).setMessage(java.lang.String.valueOf(Message)).show();
	}
	public static void ShowItems(android.app.Activity Activity, java.lang.String[] Items) {
		new android.app.AlertDialog.Builder(Activity).setItems(Items, null).show();
	}
	public static void ShowItems(android.app.Activity Activity, Object Title, java.lang.String[] Items) {
		new android.app.AlertDialog.Builder(Activity).setTitle(java.lang.String.valueOf(Title)).setItems(Items, null).show();
	}
	public static void ShowImage(android.app.Activity Activity, int ImageResourceId) {
		android.widget.ImageView view = new android.widget.ImageView(Activity);
		view.setImageResource(ImageResourceId);
		view.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		// view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
		new android.app.AlertDialog.Builder(Activity).setView(view).show();
	}
	public static void ShowImage(android.app.Activity Activity, Object Title, int ImageResourceId) {
		android.widget.ImageView view = new android.widget.ImageView(Activity);
		view.setImageResource(ImageResourceId);
		view.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		// view.setLayoutParams(new android.view.ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
		new android.app.AlertDialog.Builder(Activity).setView(view).setTitle(java.lang.String.valueOf(Title)).show();
	}
}
