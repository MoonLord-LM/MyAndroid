package com.MoonLord;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.MoonLord.R;

public class DemoViewPager3 extends android.app.Activity {
	java.util.ArrayList<ImageInfo> data;
	// Activity初始化
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager_demo3);
		initData();
		ViewPager vpager = (ViewPager) findViewById(R.id.demo_viewpager);
		vpager.setAdapter(new MyPagerAdapter(DemoViewPager3.this, data));
		vpager.setPageMargin(50);
	}
	// 数据初始化
	private void initData() {
		data = new java.util.ArrayList<ImageInfo>();
		data.add(new ImageInfo("标题1-1", R.drawable.a1,0));
		data.add(new ImageInfo("标题1-2", R.drawable.a1,1));
		data.add(new ImageInfo("标题1-3", R.drawable.a1,2));
		data.add(new ImageInfo("标题1-4", R.drawable.a1,3));
		data.add(new ImageInfo("标题1-5", R.drawable.a1,4));
		data.add(new ImageInfo("标题1-6", R.drawable.a1,5));
		data.add(new ImageInfo("标题1-7", R.drawable.a1,6));
		data.add(new ImageInfo("标题1-8", R.drawable.a1,7));
		data.add(new ImageInfo("标题2-1", R.drawable.a1,8));
		data.add(new ImageInfo("标题2-2", R.drawable.a1,9));
		data.add(new ImageInfo("标题2-3", R.drawable.a1,10));
		data.add(new ImageInfo("标题2-4", R.drawable.a1,11));
		data.add(new ImageInfo("标题2-5", R.drawable.a1,12));
		data.add(new ImageInfo("标题2-6", R.drawable.a1,13));
		data.add(new ImageInfo("标题2-7", R.drawable.a1,14));
		data.add(new ImageInfo("标题2-8", R.drawable.a1,15));
		data.add(new ImageInfo("标题3-1", R.drawable.a1,16));
		data.add(new ImageInfo("标题3-2", R.drawable.a1,17));
		data.add(new ImageInfo("标题3-3", R.drawable.a1,18));
		data.add(new ImageInfo("标题3-4", R.drawable.a1,19));
		data.add(new ImageInfo("标题3-5", R.drawable.a1,20));
		data.add(new ImageInfo("标题3-6", R.drawable.a1,21));
		data.add(new ImageInfo("标题3-7", R.drawable.a1,22));
		data.add(new ImageInfo("标题3-8", R.drawable.a1,23));
		data.add(new ImageInfo("标题4-1", R.drawable.a1,24));
		data.add(new ImageInfo("标题4-2", R.drawable.a1,25));
		data.add(new ImageInfo("标题4-3", R.drawable.a1,26));
		data.add(new ImageInfo("标题4-4", R.drawable.a1,27));
		data.add(new ImageInfo("标题4-5", R.drawable.a1,28));
		data.add(new ImageInfo("标题4-6", R.drawable.a1,29));
		data.add(new ImageInfo("标题4-7", R.drawable.a1,30));
		data.add(new ImageInfo("标题4-8", R.drawable.a1,31));
		data.add(new ImageInfo("标题5-1", R.drawable.a1,32));
		data.add(new ImageInfo("标题5-2", R.drawable.a1,33));
		data.add(new ImageInfo("标题5-3", R.drawable.a1,34));
		data.add(new ImageInfo("标题5-4", R.drawable.a1,35));
		data.add(new ImageInfo("标题5-5", R.drawable.a1,36));
		data.add(new ImageInfo("标题5-6", R.drawable.a1,37));
		data.add(new ImageInfo("标题5-7", R.drawable.a1,38));
		data.add(new ImageInfo("标题5-8", R.drawable.a1,39));
	}
	// 自定义数据结构
	public class ImageInfo {
		public String textString;
		public int imageId;
		public Boolean visiable;
		public int index;
		public ImageInfo(String msg, int id, int indexinfo) {
			imageId = id;
			textString = msg;
			visiable = true;
			index = indexinfo;
		}
	}
	// 适配器初始化
	public class MyPagerAdapter extends PagerAdapter {
		java.util.ArrayList<ImageInfo> data;
		Activity activity;
		private java.util.List<View> viewList;
		public MyPagerAdapter(Activity activity, java.util.ArrayList<ImageInfo> data) {
			this.activity = activity;
			this.data = data;
			viewList=new java.util.ArrayList<android.view.View>();
			for (int i = 0; i < getCount(); i++) {
				View view = activity.getLayoutInflater().inflate(R.layout.view_pager_demo3_grid, (ViewGroup) null);
				viewList.add(view);
			}
		}
		@Override
		public int getCount() {
			return 5;
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//My.Toast.Show("destroyItem" + position );
			container.removeView(viewList.get(position));
			return;
		}
		@Override
		public Object instantiateItem(ViewGroup container, final int index) {
			GridView gridView = (GridView) viewList.get(index).findViewById(R.id.gridView2);
			gridView.setNumColumns(2);
			gridView.setVerticalSpacing(5);
			gridView.setHorizontalSpacing(5);
			gridView.setAdapter(new BaseAdapter() {
				@Override
				public int getCount() {
					return 8;
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
					//index为页数，position为页内的序号，都是从0开始。
					if (convertView == null) {
						convertView = LayoutInflater.from(activity).inflate(R.layout.view_pager_demo3_item, (ViewGroup) null);
					}
					ImageView iv = (ImageView) convertView.findViewById(R.id.demo_image);
					iv.setImageResource((data.get(index * 8 + position)).imageId);
					TextView tv = (TextView) convertView.findViewById(R.id.demo_text);
					tv.setText((data.get(index * 8 + position)).textString);
					convertView.setVisibility(data.get(index * 8 + position).visiable?View.VISIBLE:View.INVISIBLE);//判断是否隐藏
					return convertView;
				}
			});
			gridView.setOnItemLongClickListener(new OnItemLongClickListener() {
				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					arg1.setVisibility(View.INVISIBLE);//长按隐藏
					//My.Toast.Show(arg1);
					data.get(index * 8 + arg2).visiable = false;//保存隐藏状态
					return true;
				}
			});
			((ViewPager) container).addView(viewList.get(index));
			return viewList.get(index);
		}
	}
}
