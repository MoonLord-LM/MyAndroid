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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.MoonLord.My;
import com.MoonLord.MyFragment;

public class FragmentA extends MyFragment {
	
	//Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static FragmentA MyInstance = null;
	public static FragmentA Instance(){
	    if (MyInstance == null) {MyInstance = new FragmentA();}
		return MyInstance;
	}
	
	public static class ViewHolder {  
        public TextView title;  
        public TextView info;  
        public Button button;  
        public ImageView img;  
    }  
	
	@Override
	public void onClick(View v) {
		My.Toast.Show("点击事件" + v.getTag() + "\r\n" + v.toString());
		((android.widget.Button)v).setText("button"+v.getTag() +"被点击过！");
		list.get((Integer) v.getTag()).put("button", "button"+v.getTag() +"被点击过！");
	}

	SimpleAdapter adapter;
	List<Map<String, Object>> list ;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_a, container, false);
		
		//ListView简单用法
		final ListView listView1 = (ListView)rootView.findViewById(R.id.listView1);
        listView1.setAdapter(
        		new ArrayAdapter<String>(
        				My.MainActivity,
        				android.R.layout.simple_expandable_list_item_1,
        				new String[]{
        										"第一行","第二行","第一行","第二行","第一行","第二行",
        										"第一行","第二行","第一行","第二行","第一行","第二行",
        										"第一行","第二行","第一行","第二行","第一行","第二行",
        										"第一行","第二行","第一行","第二行","第一行","第二行"
        				}
        		)
        );
        
        list = new ArrayList<Map<String, Object>>();
        
        //ListView中级用法
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.ic_launcher);
        map.put("button", "按钮1");
        list.add(map);
        for (int i = 2; i < 20; i++) {
        	map = new HashMap<String, Object>();
        	map.put("title", "G"+ i);
            map.put("info", "google"+ i);
            map.put("img", R.drawable.ic_launcher);
            map.put("button", "按钮"+ i);
            list.add(map);
		}
        adapter = new SimpleAdapter(
        		My.MainActivity,
        		list,
        		R.layout.fragment_a_item,
                new String[]{"title","info","img","button"},
                new int[]{R.id.title,R.id.info,R.id.img,R.id.button}
        ){
        	//ListView针对List中每个item，要求Adapter“给我一个视图” (getView)
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				//My.Toast.Show("getView " + position + " " + convertView);
				
				ViewHolder holder = null;
				if (convertView == null) {
					android.view.LayoutInflater mInflater = (LayoutInflater)My.MainActivity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = mInflater.inflate(R.layout.fragment_a_item, (ViewGroup) My.Const.Null);
	                holder = new ViewHolder();
	                holder.info  = (android.widget.TextView)convertView.findViewById(R.id.info);
	                holder.title  = (android.widget.TextView)convertView.findViewById(R.id.title);
	                holder.img  = (ImageView)convertView.findViewById(R.id.img);
	                holder.button  = (Button)convertView.findViewById(R.id.button);
	                convertView.setTag(holder);
	                //这里的代码只在第一次创建View时发生
	            } else {
	                holder = (ViewHolder)convertView.getTag();
	              //这里的代码只在创建View后再次请求View时发生
	            }
				//这里的代码每次请求View都会发生
				holder.info.setText((CharSequence) list.get(position).get("info"));
				holder.title.setText((CharSequence) list.get(position).get("title"));
				holder.img.setBackgroundResource((Integer) list.get(position).get("img"));
				holder.button.setText((CharSequence) list.get(position).get("button"));
				holder.button.setTag(position);
				holder.button.setOnClickListener(FragmentA.Instance());
	            return convertView;
			}
		};

        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				//position和id都是从0开始的。
				My.Toast.Show("position" + position +"id" + id +My.Const.NewLine + list.get(position).get("info"));
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
	
	
}
