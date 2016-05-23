package com.MoonLord.MyStudy;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.MoonLord.R;
import com.MyAndroid.Color.RainbowColor;
import com.MyAndroid.Json;
import com.MyAndroid.Timer.UITask;
import com.MyAndroid.Frame.ImageEngine.FileCacheImageEngine;
import com.MyAndroid.Frame.JsonEngine;
import com.MyAndroid.Frame.MyActivity;

public class MainActivity extends MyActivity implements OnClickListener {
	public LinearLayout MainLayout;
	public Fragment ContentFragment;
	public String ContentFragmentTag;
	public FragmentA FragmentA;
	public FragmentB FragmentB;
	public FragmentC FragmentC;
	public FragmentD FragmentD;
	public int ShowIndex;
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button1:
				if (FragmentA == null) {
					FragmentA = new FragmentA();
				}
				ContentFragment = FadeFragment(R.id.content, FragmentA, "FragmentA", ContentFragment, ContentFragmentTag);
				ContentFragmentTag = "FragmentA";
				ShowIndex = 1;
				break;
			case R.id.button2:
				if (FragmentB == null) {
					FragmentB = new FragmentB();
				}
				ContentFragment = FadeFragment(R.id.content, FragmentB, "FragmentB", ContentFragment, ContentFragmentTag);
				ContentFragmentTag = "FragmentB";
				ShowIndex = 2;
				break;
			case R.id.button3:
				if (FragmentC == null) {
					FragmentC = new FragmentC();
				}
				ContentFragment = FadeFragment(R.id.content, FragmentC, "FragmentC", ContentFragment, ContentFragmentTag);
				ContentFragmentTag = "FragmentC";
				ShowIndex = 3;
				break;
			case R.id.button4:
				if (FragmentD == null) {
					FragmentD = new FragmentD();
				}
				ContentFragment = FadeFragment(R.id.content, FragmentD, "FragmentD", ContentFragment, ContentFragmentTag);
				ContentFragmentTag = "FragmentD";
				ShowIndex = 4;
				break;
			default:
				break;
		}
	}
	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		Toast.Show(fragment);
		if (FragmentA == null && fragment instanceof FragmentA) {
			FragmentA = (FragmentA) fragment;
			FragmentA.getActivity();
		}
		else if (FragmentB == null && fragment instanceof FragmentB) {
			FragmentB = (FragmentB) fragment;
		}
		else if (FragmentC == null && fragment instanceof FragmentC) {
			FragmentC = (FragmentC) fragment;
		}
		else if (FragmentD == null && fragment instanceof FragmentD) {
			FragmentD = (FragmentD) fragment;
		}
	}
	protected void onSaveInstanceState(android.os.Bundle outState) {
		outState.putInt("ShowIndex", ShowIndex);
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			ShowIndex = savedInstanceState.getInt("ShowIndex");
			if (ShowIndex != 0) {
				FragmentTransaction HideTransaction = this.getFragmentManager().beginTransaction();
				if (ShowIndex != 1) {
					HideTransaction.hide(FragmentA);
				}
				else {
					ContentFragment = FragmentA;
					ContentFragmentTag = "FragmentA";
				}
				if (ShowIndex != 2) {
					HideTransaction.hide(FragmentB);
				}
				else {
					ContentFragment = FragmentB;
					ContentFragmentTag = "FragmentB";
				}
				if (ShowIndex != 3) {
					HideTransaction.hide(FragmentC);
				}
				else {
					ContentFragment = FragmentC;
					ContentFragmentTag = "FragmentC";
				}
				if (ShowIndex != 4) {
					HideTransaction.hide(FragmentD);
				}
				else {
					ContentFragment = FragmentD;
					ContentFragmentTag = "FragmentD";
				}
				HideTransaction.commit();
			}
		}
		setContentView(R.layout.activity_main); 
		//Intent.ShowURL("http://wlan.whu.edu.cn/portal/logout");
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		findViewById(R.id.button4).setOnClickListener(this);
		findViewById(R.id.MAIN).setOnClickListener(this);
		MainLayout = (LinearLayout) findViewById(R.id.MAIN);
		final RainbowColor RC = new RainbowColor();
		RC.Alpha = 125;
		RC.ChangeSpeed = -5;
		new UITask(this) {
			@Override
			public void run() {
				((LinearLayout) findViewById(R.id.MAIN)).setBackgroundColor((new RainbowColor()).NextColor());
				FileCacheImageEngine.Load(MainActivity.this, findViewById(R.id.MAIN), 0, "http://moonlord.cn/img/cloud.jpg");
				this.Stop();
			}
		};
		JsonEngine.Get(MainActivity.this, "https://www.baidu.com/img/bdlogo.png", new JsonEngine.JsonRunable() {
			@Override
			public void runOnUiThread(String Response, Json Data) {
				if (Response==null) {
					Toast.Show("无法连接服务器，请检查网络");
					return;
				}
				if (Data==null) {
					Toast.Show("服务器出现异常，请稍后再试");
					return;
				}
				Toast.Show(Data.JsonString());
				return;
			}
		});
		// Toast.ShowCenter(this, null);
		// Toast.ShowBottom(this, R.drawable.ic_launcher, null);
		// Toast.ShowTop(this, null, R.drawable.ic_launcher, null);
		// HttpClient.DownLoad("http://moonlordapi-moonlord.stor.sinaapp.com/To%20be%20done.txt", My.IO.SDCard.Directory + "/" + "测试.txt");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// final String aString = Http.Post("http://moonlordapi.sinaapp.com/test.php", "A=1");
				// final String aString1 = HttpClient.Post("http://moonlordapi.sinaapp.com/test.php").AddPostParameter("A", "1").Execute();
				// long total1 = 0;
				// long total2 = 0;
				// // HttpGetRequest r = HttpClient.Get("http://moonlordapi.sinaapp.com/test.php");
				// for (int i = 0; i < 20; i++) {
				// long start = My.Time.NowTime();
				// Http.UpLoad("http://moonlordapi.sinaapp.com/test.php", "file", My.IO.SDCard.Directory + "/" + "测试.txt");
				// long end1 = My.Time.NowTime();
				// total1 += end1 - start;
				// end1 = My.Time.NowTime();
				// HttpClient.Post("http://moonlordapi.sinaapp.com/test.php").AddPostParameter("A", "1").AddUploadFile("file", My.IO.SDCard.Directory + "/" + "测试.txt").Execute();
				// long end2 = My.Time.NowTime();
				// total2 += end2 - end1;
				// }
				// final long t1 = total1;
				// final long t2 = total2;
				MainActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						// Intent.ShowMap(100, 50);
						// Notification.ShowIntent(R.drawable.ic_launcher, "标题", "内容", "提示", "气泡", new Intent());
					}
				});
			}
		}).start();
		/*
		 * Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f); // alphaAnimation.setRepeatMode(android.view.animation.Animation.RESTART); // alphaAnimation.setDuration(6000); // MainLayout.startAnimation(alphaAnimation); Animation rotateAnimation =
		 * new RotateAnimation(0f, 360f); // rotateAnimation.setRepeatMode(android.view.animation.Animation.RESTART); // rotateAnimation.setDuration(6000); // MainLayout.startAnimation(rotateAnimation); Animation scaleAnimation = new ScaleAnimation(0.1f,
		 * 1.0f, 0.1f, 1.0f); // scaleAnimation.setRepeatMode(android.view.animation.Animation.RESTART); // scaleAnimation.setDuration(6000); // MainLayout.startAnimation(scaleAnimation); Animation translateAnimation = new TranslateAnimation(0.1f, 100.0f,
		 * 0.1f, 100.0f); // translateAnimation.setRepeatMode(android.view.animation.Animation.RESTART); // translateAnimation.setDuration(6000); // MainLayout.startAnimation(translateAnimation); AnimationSet set = new AnimationSet(true);
		 * set.addAnimation(translateAnimation); set.addAnimation(scaleAnimation); set.addAnimation(rotateAnimation); set.addAnimation(alphaAnimation); set.setDuration(6000); set.setRepeatMode(android.view.animation.Animation.RESTART);
		 * MainLayout.startAnimation(set);
		 */
	}
}
