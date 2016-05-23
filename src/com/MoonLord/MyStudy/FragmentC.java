package com.MoonLord.MyStudy;

import android.os.Bundle;
import com.MoonLord.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
 

public class FragmentC extends com.MyAndroid.Fragment implements android.view.View.OnClickListener{
	
	//Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static FragmentC MyInstance = null;
	public static FragmentC Instance(){
	    if (MyInstance == null) {MyInstance = new FragmentC();}
		return MyInstance;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_c, container, false); 
        return rootView;
        
    }

	@Override
	public void onClick(View v) { 
	}
	
	
}
