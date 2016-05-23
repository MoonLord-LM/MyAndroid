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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.MoonLord.R;
import com.MyAndroid.LogCat;
import com.MyAndroid.Toast;
import com.MyAndroid.Frame.MyActivity;

public class FragmentA extends com.MyAndroid.Fragment implements android.view.View.OnClickListener {
	public static class ViewHolder {
		public TextView title;
		public TextView info;
		public Button button;
		public ImageView img;
	}
	@Override
	public void onClick(View v) {
		Toast.Show(Activity, "点击事件" + v.getTag() + "\r\n" + v.toString());
		((android.widget.Button) v).setText("button" + v.getTag() + "被点击过！");
		Map<String, Object> aMap = list.get((Integer) v.getTag());
		aMap.put("button", "button" + v.getTag() + "被点击过！");
		list.set((Integer) v.getTag(), aMap);
	}
	SimpleAdapter adapter;
	List<Map<String, Object>> list;
	ListView listView1;
	View rootView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		if (rootView != null) {
			return rootView;
		}
		LogCat.Error("rootView = inflater.inflate(R.layout.fragment_a, container, false);");
		rootView = inflater.inflate(R.layout.fragment_a, container, false);
		// ListView简单用法
		listView1 = (ListView) rootView.findViewById(R.id.listView1);
		listView1.setAdapter(new ArrayAdapter<String>(Activity, android.R.layout.simple_expandable_list_item_1, new String[] { "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行", "第一行", "第二行" }));
		list = new ArrayList<Map<String, Object>>();
		// ListView中级用法
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "G1");
		map.put("info", "google 1");
		map.put("img", R.drawable.ic_launcher);
		map.put("button", "按钮1");
		list.add(map);
		for (int i = 2; i < 20; i++) {
			map = new HashMap<String, Object>();
			map.put("title", "G" + i);
			map.put("info", "google" + i);
			map.put("img", R.drawable.ic_launcher);
			map.put("button", "按钮" + i);
			list.add(map);
		}
		adapter = new SimpleAdapter(Activity, list, R.layout.fragment_a_item, new String[] { "title", "info", "img", "button" }, new int[] { R.id.title, R.id.info, R.id.img, R.id.button }) {
			// ListView针对List中每个item，要求Adapter“给我一个视图” (getView)
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// My.Toast.Show("getView " + position + " " + convertView);
				ViewHolder holder = null;
				if (convertView == null) {
					android.view.LayoutInflater mInflater = (LayoutInflater) Activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = mInflater.inflate(R.layout.fragment_a_item, (ViewGroup) null);
					holder = new ViewHolder();
					holder.info = (android.widget.TextView) convertView.findViewById(R.id.info);
					holder.title = (android.widget.TextView) convertView.findViewById(R.id.title);
					holder.img = (ImageView) convertView.findViewById(R.id.img);
					holder.button = (Button) convertView.findViewById(R.id.button);
					convertView.setTag(holder);
					// 这里的代码只在第一次创建View时发生
				}
				else {
					holder = (ViewHolder) convertView.getTag();
					// 这里的代码只在创建View后再次请求View时发生
				}
				// 这里的代码每次请求View都会发生
				holder.info.setText((CharSequence) list.get(position).get("info"));
				holder.title.setText((CharSequence) list.get(position).get("title"));
				holder.img.setBackgroundResource((Integer) list.get(position).get("img"));
				holder.button.setText((CharSequence) list.get(position).get("button"));
				holder.button.setTag(position);
				holder.button.setOnClickListener(FragmentA.this);
				return convertView;
			}
		};
		listView1.setAdapter(adapter);
		listView1.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
					((MyActivity) getActivity()).Toast.Show("空闲");
				}
				if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
					((MyActivity) getActivity()).Toast.Show("低速滑动");
				}
				if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
					((MyActivity) getActivity()).Toast.Show("飞速滑动");
				}
				// 判断滚动到底部
				if (listView1.getLastVisiblePosition() == (listView1.getCount() - 1)) {
					((MyActivity) getActivity()).Toast.Show("滑到了底部");
				}
				// 判断滚动到顶部
				if (listView1.getFirstVisiblePosition() == 0) {
					((MyActivity) getActivity()).Toast.Show("滑到了顶部");
				}
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				((MyActivity) getActivity()).Toast.Show("onScroll：firstVisibleItem" + firstVisibleItem + "：visibleItemCount" + visibleItemCount);
			}
		});
		return rootView;
	}
}
