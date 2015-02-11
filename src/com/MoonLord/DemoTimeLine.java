package com.MoonLord;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.MoonLord.MyStudy.R;

public class DemoTimeLine extends Activity {
	private ListView listView;
	java.util.List<String> data;
	private TimeLineAdapter timelineAdapter;
	// Activity初始化
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_line_demo);
		listView = (ListView) this.findViewById(R.id.timelinelist);
		listView.setDividerHeight(0);// 强制Item之间无间隙
		timelineAdapter = new TimeLineAdapter(this, getData());
		listView.setAdapter(timelineAdapter);
	}
	// 填充数据
	private java.util.List<java.util.Map<String, Object>> getData() {
		java.util.List<java.util.Map<String, Object>> list = new java.util.ArrayList<java.util.Map<String, Object>>();
		java.util.HashMap<String, Object> map;
		for (int i = 0; i < 50; i++) {
			map = new java.util.HashMap<String, Object>();
			map.put("title", "这是第" + i + "行文字信息。");
			list.add(map);
		}
		return list;
	}
	// 自定义适配器
	public class TimeLineAdapter extends BaseAdapter {
		private java.util.List<java.util.Map<String, Object>> list;
		public TimeLineAdapter(Context context, java.util.List<java.util.Map<String, Object>> list) {
			super();
			this.list = list;
		}
		public class ViewHolder {
			public TextView title;
		}
		@Override
		public int getCount() {
			return list.size();
		}
		@Override
		public Object getItem(int position) {
			return position;
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(parent.getContext());
				convertView = inflater.inflate(R.layout.time_line_item, (ViewGroup) My.Const.Null);
				viewHolder = new ViewHolder();
				viewHolder.title = (TextView) convertView.findViewById(R.id.title);
				convertView.setTag(viewHolder);
			}
			else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			String titleStr = list.get(position).get("title").toString();
			viewHolder.title.setText(titleStr);
			return convertView;
		}
	}
}
