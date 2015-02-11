package com.MoonLord;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.MoonLord.MyStudy.R;

public class DemoViewPager2 extends android.app.Activity {
	private View view1, view2, view3;
	private ViewPager viewPager;
	private PagerTabStrip pagerTabStrip;
	private java.util.List<View> viewList;
	private java.util.List<String> titleList;
	//Activity初始化
	@Override
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager_demo2);
		initView();
	}
	//适配器初始化
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		pagerTabStrip=(PagerTabStrip) findViewById(R.id.pagertab);
		pagerTabStrip.setTabIndicatorColor(Color.YELLOW); 
		pagerTabStrip.setDrawFullUnderline(false);
		pagerTabStrip.setBackgroundColor(Color.CYAN);
		pagerTabStrip.setTextSpacing(50);
		//
		viewList=new java.util.ArrayList<android.view.View>();
		android.view.LayoutInflater inflater=getLayoutInflater();
		view1=inflater.inflate(R.layout.view_pager_page1, (android.view.ViewGroup)My.Const.Null);
		view2=inflater.inflate(R.layout.view_pager_page2, (android.view.ViewGroup)My.Const.Null);
		view3=inflater.inflate(R.layout.view_pager_page3, (android.view.ViewGroup)My.Const.Null);
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		//
		titleList = new java.util.ArrayList<String>();// 每个页面的Title数据
		titleList.add("标题一");
		titleList.add("标题二");
		titleList.add("标题三");
		//
		PagerAdapter pagerAdapter = new PagerAdapter() {
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			@Override
			public int getCount() {
				return viewList.size();
			}
			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView(viewList.get(position));
			}
			@Override
			public int getItemPosition(Object object) {
				return super.getItemPosition(object);
			}
			@Override
			public CharSequence getPageTitle(int position) {
				return titleList.get(position);
			}
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(viewList.get(position));
				return viewList.get(position);
			}
		};
		viewPager.setAdapter(pagerAdapter);
	}
}
