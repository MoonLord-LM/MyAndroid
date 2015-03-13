package com.MoonLord.MyStudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.MoonLord.My;
import com.MoonLord.MyFragment;

public class FragmentC extends MyFragment {
	
	//Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static FragmentC MyInstance = null;
	public static FragmentC Instance(){
	    if (MyInstance == null) {MyInstance = new FragmentC();}
		return MyInstance;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_c, container, false);
		
		new My.Timer.NewUIRunnable() {
			@Override
			public void run() {
				ImageView imageView1 = (ImageView) rootView.findViewById(R.id.imageView1);
				//My.Camera.GetPhoto(imageView1);
				My.Camera.GetCropPhoto(imageView1);
			}
		};
        
        return rootView;
        
    }
	
	
}
