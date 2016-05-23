package com.MyAndroid.Frame;

import com.MyAndroid.Activity;
import com.MyAndroid.AlertDialog;
import com.MyAndroid.Toast;
import com.MyAndroid.ShortCut;
import com.MyAndroid.Screen;
import com.MyAndroid.Memory;
import com.MyAndroid.Vibrator;
import com.MyAndroid.WIFI;
import com.MyAndroid.IO;
import com.MyAndroid.Notification;
import com.MyAndroid.Intent;

//需要权限：<uses-permission android:name="android.permission.INTERNET"></uses-permission>
//需要权限：<uses-permission android:name="android.permission.CALL_PHONE" />
//需要权限：<uses-permission android:name="android.permission.SEND_SMS" />
//需要权限：<uses-permissionandroid:name="android.permission.WRITE_EXTERNAL_STORAGE"/> 
//需要权限：<uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
//需要权限：<uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT"/>
//需要权限：<uses-permission android:name="android.permission.VIBRATE"/>
//需要权限：<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"></uses-permission>
//需要权限：<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"></uses-permission>
//需要权限：<uses-permission android:name="android.permission.WAKE_LOCK" />
//需要权限：<uses-permission android:name = "android.permission.CAMERA" /> 
//需要特性：<uses-feature android:name="android.hardware.camera" />
//需要特性：<uses-feature android:name = "android.hardware.camera.autofocus" />

public class MyActivity extends Activity{
		public AlertDialog AlertDialog = new AlertDialog(this);
		public Toast Toast = new Toast(this);
		public ShortCut ShortCut = new ShortCut(this);
		public Screen Screen = new Screen(this);
		public Memory Memory = new Memory(this);
		public Vibrator Vibrator = new Vibrator(this);
		public WIFI WIFI = new WIFI(this);
		public IO IO = new IO(this);
		public Notification Notification = new Notification(this);
		public Intent Intent = new Intent(this);
}
