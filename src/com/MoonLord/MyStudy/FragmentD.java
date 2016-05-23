package com.MoonLord.MyStudy;

import java.util.ArrayList;
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

import com.MoonLord.R;
import com.MyAndroid.Toast;

public class FragmentD extends com.MyAndroid.Fragment implements android.view.View.OnClickListener{
	SimpleAdapter adapter;
	List<Map<String, Object>> list;
	View rootView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		if (rootView != null) {
			return rootView;
		}
		rootView = inflater.inflate(R.layout.fragment_d, container, false);
		int[] ImageId = new int[] { R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1, R.drawable.a1 };
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < ImageId.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", ImageId[i]);
			list.add(listItem);
		}
		final GridView gridView1 = (GridView) rootView.findViewById(R.id.gridView1);
		adapter = new SimpleAdapter(Activity, list, R.layout.fragment_d_item, new String[] { "image" }, new int[] { R.id.itemimage }){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				//My.LogCat.Log("getView " + position + " " + convertView);
				if (convertView == null) {
					android.view.LayoutInflater mInflater = (LayoutInflater)Activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = mInflater.inflate(R.layout.fragment_d_item, (ViewGroup) null);
					
	            } else {
	            }
				ImageView img  = (ImageView)convertView.findViewById(R.id.itemimage);
				img.setBackgroundResource((Integer) list.get(position).get("image"));
				img.setTag(position);
				img.setOnClickListener(FragmentD.this); 
	            return convertView;
			}
		};
		gridView1.setAdapter(adapter);
		gridView1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.Show(Activity,"选中格子位置position+1：" + (position+1));
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {}
		});
		gridView1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.Show(Activity,"点击格子位置position+1：" + (position+1));
			}
		});
		
        return rootView;
	}
	
	//图片的点击事件
	public void onClick(View v) {
		Toast.Show(Activity,"点击图片位置" + ((Integer) v.getTag()+1));
		v.setBackgroundResource(R.drawable.ic_launcher);
		list.get((Integer) v.getTag()).put("image", R.drawable.ic_launcher);
	}
}
