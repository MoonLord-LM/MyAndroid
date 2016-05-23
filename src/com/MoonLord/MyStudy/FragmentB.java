package com.MoonLord.MyStudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.MoonLord.R;
import com.MyAndroid.Toast;

public class FragmentB extends com.MyAndroid.Fragment implements android.view.View.OnClickListener{
	
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
            	Toast.Show(Activity,"textView1");
            	//Activity.Start(DemoTimeLine.class);
            	//Activity.Start(DemoViewPager.class);
            	//Activity.Start(DemoViewPager2.class);
            	//Activity.Start(DemoViewPager3.class);
            	//My.Vibrator.Repeat(100, 200,5);
                break;
            case R.id.scrollView1:
            	Toast.Show(Activity,"scrollView1");
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
		
        return rootView;
        
    }
	
}
