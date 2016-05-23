package com.MoonLord.MyStudy;

import com.MyAndroid.LogCat;
import com.MyAndroid.Toast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.Show(context,"123");
		Toast.Show(context,"123");
		Toast.Show(context,"123");
		LogCat.Error("BootReceiver-onReceive");
		Intent i = new Intent(context, MainActivity.class);
		context.startActivity(i);
		i = new Intent(context, LocalService.class);
		context.startService(i);
	}
}
