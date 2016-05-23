package com.MyAndroid;

//使用Toast输出信息
//（动态类+静态函数库）
public class Toast {
	private android.content.Context MyContext;
	public Toast(android.content.Context Context) {
		MyContext = Context;
	}
	public void Show(Object Message) {
		android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_SHORT).show();
	}
	public void Show(int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 0);
		toast.show();
	}
	public void Show(Object Title, int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.TextView textView = new android.widget.TextView(MyContext.getApplicationContext());
		textView.setText(java.lang.String.valueOf(Title));
		textView.setGravity(android.view.Gravity.CENTER);
		textView.setTextColor(android.graphics.Color.WHITE);
		toastView.addView(textView, 0);
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 1);
		toast.show();
	}
	public void ShowCenter(Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_SHORT);
		toast.setGravity(android.view.Gravity.CENTER, 0, 0);
		toast.show();
	}
	public void ShowCenter(int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.CENTER, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 0);
		toast.show();
	}
	public void ShowCenter(Object Title, int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.CENTER, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.TextView textView = new android.widget.TextView(MyContext.getApplicationContext());
		textView.setText(java.lang.String.valueOf(Title));
		textView.setGravity(android.view.Gravity.CENTER);
		textView.setTextColor(android.graphics.Color.WHITE);
		toastView.addView(textView, 0);
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 1);
		toast.show();
	}
	public void ShowTop(Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_SHORT);
		toast.setGravity(android.view.Gravity.TOP, 0, 0);
		toast.show();
	}
	public void ShowTop(int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.TOP, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 0);
		toast.show();
	}
	public void ShowTop(Object Title, int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.TOP, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.TextView textView = new android.widget.TextView(MyContext.getApplicationContext());
		textView.setText(java.lang.String.valueOf(Title));
		textView.setGravity(android.view.Gravity.CENTER);
		textView.setTextColor(android.graphics.Color.WHITE);
		toastView.addView(textView, 0);
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 1);
		toast.show();
	}
	public void ShowBottom(Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_SHORT);
		toast.setGravity(android.view.Gravity.BOTTOM, 0, 0);
		toast.show();
	}
	public void ShowBottom(int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.BOTTOM, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 0);
		toast.show();
	}
	public void ShowBottom(Object Title, int ImageResourceId, Object Message) {
		android.widget.Toast toast = android.widget.Toast.makeText(MyContext.getApplicationContext(), java.lang.String.valueOf(Message), android.widget.Toast.LENGTH_LONG);
		toast.setGravity(android.view.Gravity.BOTTOM, 0, 0);
		android.widget.LinearLayout toastView = (android.widget.LinearLayout) toast.getView();
		android.widget.TextView textView = new android.widget.TextView(MyContext.getApplicationContext());
		textView.setText(java.lang.String.valueOf(Title));
		textView.setGravity(android.view.Gravity.CENTER);
		textView.setTextColor(android.graphics.Color.WHITE);
		toastView.addView(textView, 0);
		android.widget.ImageView imageView = new android.widget.ImageView(MyContext.getApplicationContext());
		imageView.setImageResource(ImageResourceId);
		imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
		toastView.addView(imageView, 1);
		toast.show();
	}
	public static void Show(android.content.Context Context, Object Message) {
		new Toast(Context).Show(Message);
	}
	public static void Show(android.content.Context Context, int ImageResourceId, Object Message) {
		new Toast(Context).Show(ImageResourceId, Message);
	}
	public static void Show(android.content.Context Context, Object Title, int ImageResourceId, Object Message) {
		new Toast(Context).Show(Title, ImageResourceId, Message);
	}
	public static void ShowCenter(android.content.Context Context, Object Message) {
		new Toast(Context).ShowCenter(Message);
	}
	public static void ShowCenter(android.content.Context Context, int ImageResourceId, Object Message) {
		new Toast(Context).ShowCenter(ImageResourceId, Message);
	}
	public static void ShowCenter(android.content.Context Context, Object Title, int ImageResourceId, Object Message) {
		new Toast(Context).ShowCenter(Title, ImageResourceId, Message);
	}
	public static void ShowTop(android.content.Context Context, Object Message) {
		new Toast(Context).ShowTop(Message);
	}
	public static void ShowTop(android.content.Context Context, int ImageResourceId, Object Message) {
		new Toast(Context).ShowTop(ImageResourceId, Message);
	}
	public static void ShowTop(android.content.Context Context, Object Title, int ImageResourceId, Object Message) {
		new Toast(Context).ShowTop(Title, ImageResourceId, Message);
	}
	public static void ShowBottom(android.content.Context Context, Object Message) {
		new Toast(Context).ShowBottom(Message);
	}
	public static void ShowBottom(android.content.Context Context, int ImageResourceId, Object Message) {
		new Toast(Context).ShowBottom(ImageResourceId, Message);
	}
	public static void ShowBottom(android.content.Context Context, Object Title, int ImageResourceId, Object Message) {
		new Toast(Context).ShowBottom(Title, ImageResourceId, Message);
	}
}
