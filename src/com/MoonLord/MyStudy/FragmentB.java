package com.MoonLord.MyStudy;

import android.os.Bundle;
import com.MoonLord.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.MoonLord.DemoTimeLine;
import com.MoonLord.DemoViewPager;
import com.MoonLord.DemoViewPager2;
import com.MoonLord.DemoViewPager3;
import com.MoonLord.My;
import com.MoonLord.My.Activity;
import com.MoonLord.MyFragment;

public class FragmentB extends MyFragment {
	
	//Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static FragmentB MyInstance = null;
	public static FragmentB Instance(){
	    if (MyInstance == null) {MyInstance = new FragmentB();}
		return MyInstance;
	}
	
	//OnClickListener接口实现
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
            case R.id.textView1:
            	My.Toast.Show("textView1");
            	Activity.Start(DemoTimeLine.class);
            	Activity.Start(DemoViewPager.class);
            	Activity.Start(DemoViewPager2.class);
            	Activity.Start(DemoViewPager3.class);
            	//My.Vibrator.Repeat(100, 200,5);
                break;
            case R.id.scrollView1:
            	My.Toast.Show("scrollView1");
                break;
            default:
                break;
        }
	}
		
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_b, container, false);
		
		TextView textView1 = (TextView) rootView.findViewById(R.id.textView1);
		textView1.setOnClickListener(this);
		ScrollView scrollView1 = (ScrollView) rootView.findViewById(R.id.scrollView1);
		scrollView1.setOnClickListener(this);
		
		new Thread(new Runnable() {
        	@Override
        	public void run() {
        		//final String aString = My.Http.CookieByPost("http://moonlordapi.sinaapp.com/test.php?中文GET&参数=中文233","中文POST=中文233","C中文=V中文; X=Y","http://www.moonlord.cn?参数=123");
        		final String aString = My.Http.Get("http://www.baidu.com");
        		My.IO.SDCard.MakeDirectory("123/456");
        		My.IO.SDCard.WriteFile("123/456/123.txt","123/456");
        		//final String a = My.Http.UpLoadSDCard("http://moonlordapi.sinaapp.com/test.php?java.lang.String=中文&参数=中文233","参数1=中文233&参数2=中文233","参数1=中文233&参数2=中文233","参数1=中文233&参数2=中文233", new String[]{"123/456/123.txt","123/456/123.txt","123/456/123.txt"});
        		final String a = My.Http.ClientPost("http://moonlordapi.sinaapp.com/test.php?中文GET&参数=中文233","中文POST=中文233",aString,"http://www.moonlord.cn?参数=123");
        		//下面的代码在UI线程中执行
        		My.MainActivity.Handler.postDelayed(new Runnable() {
        			@Override
        			public void run() {
        				TextView textView1=(TextView)rootView.findViewById(R.id.textView1);
        				textView1.setText(
        						My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine 
        						+"点击屏幕可以切换到其它Activity示例。"
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        						+My.Const.NewLine
        					+ "获取到的源码：" +My.Const.NewLine + aString+My.Const.NewLine
        					+ "总内存：" + My.Memory.TotalMemoryMB()+My.Const.NewLine
        					+ "SD卡路径：" + My.IO.SDCard.Directory+My.Const.NewLine
        					+ "SD卡状态" + My.IO.SDCard.IsReady() +My.Const.NewLine
        					+ "SD卡总空间" + My.IO.SDCard.TotalSizeString() +My.Const.NewLine
        					+ "SD卡可用空间" + My.IO.SDCard.AvailableSizeString() +My.Const.NewLine
        					+ "ROM总空间" + My.IO.Rom.TotalSizeString() +My.Const.NewLine
        					+ "ROM可用空间" + My.IO.Rom.AvailableSizeString() +My.Const.NewLine
        					+ "SD卡Directory创建" + My.IO.SDCard.MakeDirectory("123/456") +My.Const.NewLine
        					+ "SD卡File创建" + My.IO.SDCard.WriteFile("123/456/123.txt","123/456") +My.Const.NewLine
        					+ "SD卡File大小" + My.IO.SDCard.FileLength("123/456/123.txt") +My.Const.NewLine
        					+ "SD卡下载文件" + a + My.Const.NewLine
        					+ "SD卡File删除" + My.IO.SDCard.DeleteFile("123/456/123.txt") +My.Const.NewLine
        					+ "SD卡Directory删除" + My.IO.SDCard.DeleteDirectory("123/456") +My.Const.NewLine
        					+ "SD卡Directory删除" + My.IO.SDCard.DeleteDirectory("123") +My.Const.NewLine
        					+ My.String.FromArray(My.IO.SDCard.FileList("")) +My.Const.NewLine
        				);
        					
        			}
        			},0);
        	}
        	}).start();		

		rootView.setBackgroundColor(My.Maths.SmoothChangeLightColor.LastColor);
		new My.Timer.IntervalTimerTask(20){
        	@Override
			public void run() {
        		rootView.setBackgroundColor(My.Maths.SmoothChangeLightColor.LastColor);
			}
        };
        return rootView;
        
    }
	
}
