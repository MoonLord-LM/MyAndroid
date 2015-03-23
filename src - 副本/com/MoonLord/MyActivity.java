package com.MoonLord;

public class MyActivity extends android.app.Activity implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnMultiChoiceClickListener {
	// 第一次启动（全局MainActivity的赋值）
	@Override
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		My.MainActivity = this;
	}
	// 内部Hander实现
	public MyHandler Handler = new MyHandler();
	public static class MyHandler extends android.os.Handler {
		@Override
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
		}
	}
	// OnClickListener接口实现
	@Override
	public void onClick(android.view.View v) {}
	@Override
	public void onClick(android.content.DialogInterface dialog, int which) {
		// StringBuffer a = new StringBuffer();
		// a.append(which == android.content.DialogInterface.BUTTON_POSITIVE ?
		// "确定键" : "");
		// a.append(which == android.content.DialogInterface.BUTTON_NEGATIVE ?
		// "取消键" : "");
		// a.append(which == android.content.DialogInterface.BUTTON_POSITIVE ||
		// which == android.content.DialogInterface.BUTTON_NEGATIVE ? "" : "第" +
		// which + "项");
		// My.Toast.Show(a.toString());
	}
	@Override
	public void onClick(android.content.DialogInterface dialog, int which, boolean isChecked) {}
	// 生命周期事件监控
	@Override
	protected void onStart() {
		super.onStart();
		My.LogCat.Log("MyActivity-onCreate");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		My.LogCat.Log("MyActivity-onRestart");
	}
	@Override
	protected void onResume() {
		super.onResume();
		My.LogCat.Log("MyActivity-onResume");
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		My.LogCat.Log("MyActivity-onWindowFocusChanged-" + hasFocus);
	}
	@Override
	protected void onPause() {
		super.onPause();
		My.LogCat.Log("MyActivity-onPause");
	}
	@Override
	protected void onStop() {
		super.onStop();
		My.LogCat.Log("MyActivity-onStop");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		My.LogCat.Log("MyActivity-onDestroy");
	}
	@Override
	protected void onSaveInstanceState(android.os.Bundle outState) {
		super.onSaveInstanceState(outState);
		My.LogCat.Log("MyActivity-onSaveInstanceState");
	}
	@Override
	protected void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		My.LogCat.Log("MyActivity-onRestoreInstanceState");
	}
	// Intent事件回调
	@Override
	protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
		try {
			if (resultCode == android.app.Activity.RESULT_OK) {
				switch (requestCode) {
					case My.Camera.SetBackgroundCode:
						android.graphics.Bitmap bitmap1 = (android.graphics.Bitmap) data.getExtras().get("data");
						My.Camera.SetBackgroundView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(bitmap1));
						break;
					case My.Camera.SavePhotoCode:
						break;
					case My.Camera.SavePhotoAndSetBackgroundCode:
						android.graphics.Bitmap bitmap2 = android.graphics.BitmapFactory.decodeFile(My.Camera.SavePhotoAndSetBackgroundFile);
						My.Camera.SavePhotoAndSetBackgroundView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(bitmap2));
						break;
					case My.Camera.GetPhotoCode:
						android.net.Uri selectedImage = data.getData();
						//My.AlertDialog.New(selectedImage).show();
						//My.AlertDialog.New(data.getExtras().get("data")).show();
						String[] filePathColumn = { android.provider.MediaStore.Images.Media.DATA };
						android.database.Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
						cursor.moveToFirst();
						int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
						String picturePath = cursor.getString(columnIndex);
						cursor.close();
						android.graphics.Bitmap bitmap3 = android.graphics.BitmapFactory.decodeFile(picturePath);
						My.Camera.GetPhotoView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(bitmap3));
						break;
					case My.Camera.GetCropPhotoCode1:
						android.content.Intent intent =new android.content.Intent("com.android.camera.action.CROP");
						intent.setData(data.getData());//data是图库选取文件传回的参数
						intent.putExtra("crop","true");
						intent.putExtra("aspectX",1);//长宽1：1
						intent.putExtra("aspectY",1);
						intent.putExtra("outputX",My.Camera.GetCropPhotoSize);
						intent.putExtra("outputY",My.Camera.GetCropPhotoSize);
						intent.putExtra("noFaceDetection",true);//不识别人脸
						intent.putExtra("return-data",true);
						My.MainActivity.startActivityForResult(intent, My.Camera.GetCropPhotoCode2);
						break;
					case My.Camera.GetCropPhotoCode2:
						android.graphics.Bitmap bitmap4 = data.getExtras().getParcelable("data");
						My.Camera.GetCropPhotoView.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(bitmap4));						
					default:
						break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
