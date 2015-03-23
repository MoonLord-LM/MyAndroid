package com.MoonLord.MyStudy;

import java.util.ArrayList;
import com.MoonLord.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.MoonLord.My;
import com.MoonLord.MyFragment;

public class FragmentD extends MyFragment {
	// Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static FragmentD MyInstance = null;
	public static FragmentD Instance() {
		if (MyInstance == null) {
			MyInstance = new FragmentD();
		}
		return MyInstance;
	}
	SimpleAdapter adapter;
	List<Map<String, Object>> list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_d, container, false);
		int[] ImageId = new int[] { R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1 };
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < ImageId.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", ImageId[i]);
			list.add(listItem);
		}
		final GridView gridView1 = (GridView) rootView.findViewById(R.id.gridView1);
		adapter = new SimpleAdapter(My.MainActivity, list, R.layout.fragment_d_item, new String[] { "image" }, new int[] { R.id.itemimage }){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				//My.LogCat.Log("getView " + position + " " + convertView);
				if (convertView == null) {
					android.view.LayoutInflater mInflater = (LayoutInflater)My.MainActivity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = mInflater.inflate(R.layout.fragment_d_item, (ViewGroup) My.Const.Null);
					
	            } else {
	            }
				ImageView img  = (ImageView)convertView.findViewById(R.id.itemimage);
				img.setBackgroundResource((Integer) list.get(position).get("image"));
				img.setTag(position);
				img.setOnClickListener(FragmentD.Instance()); 
	            return convertView;
			}
		};
		gridView1.setAdapter(adapter);
		gridView1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				My.Toast.Show("选中格子位置position+1：" + (position+1));
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});
		gridView1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				My.Toast.Show("点击格子位置position+1：" + (position+1));
			}
		});
		
		
		rootView.setBackgroundColor(My.Maths.SmoothChangeLightColor.LastColor);
		new My.Timer.IntervalTimerTask(20){
        	@Override
			public void run() {
        		rootView.setBackgroundColor(My.Maths.SmoothChangeLightColor.LastColor);
			}
        };		
        return rootView;
	}
	
	//图片的点击事件
	@Override
	public void onClick(View v) {
		My.Toast.Show("点击图片位置" + ((Integer) v.getTag()+1));
		v.setBackgroundResource(R.drawable.ic_launcher);
		list.get((Integer) v.getTag()).put("image", R.drawable.ic_launcher);
	}
}
