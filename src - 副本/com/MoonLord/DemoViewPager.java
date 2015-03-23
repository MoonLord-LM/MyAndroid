package com.MoonLord;

import com.MoonLord.R;
//如果android-support-v4.jar包在LIBS目录下，先将它移除。
//然后点选中项目右键 --->properties-->JavaBuildPath-->Libraries-->Add External JARs。
//选择你SDK目录下的\extras\android\compatibility\v4\android-support-v4.jar.点击OK。这样就导入了jar包。
//选择Referenced Libraries中的android-support-v4.jar包，右键--->properties-->java Source Attachment--->Location path中的路径。
//即为源代码路径/extras/android/compatibility/v4/SRC。

public class DemoViewPager extends android.app.Activity{
	private android.support.v4.view.ViewPager MyViewPager;// 页面内容
	private android.widget.ImageView LineImage;// 横线图片
	private int offset = 0;// 动画图片偏移量（左边距）
	private int LineImageWidth;// 动画图片宽度
	private int PageIndex = 0;// 当前页卡编号
	private android.widget.TextView TitleText1,TitleText2,TitleText3;//3个标题
	private android.view.View view1,view2,view3;//3个页面
	private java.util.List<android.view.View> views;// Tab页面列表
	//Activity初始化
	@Override
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager_demo);
		InitImageView();
		InitTextView();
		InitViewPager();
	}
	//适配器初始化
	private void InitViewPager() {
		MyViewPager=(android.support.v4.view.ViewPager) findViewById(R.id.vPager);
		views=new java.util.ArrayList<android.view.View>();
		android.view.LayoutInflater inflater=getLayoutInflater();
		view1=inflater.inflate(R.layout.view_pager_page1, (android.view.ViewGroup)My.Const.Null);
		view2=inflater.inflate(R.layout.view_pager_page2, (android.view.ViewGroup)My.Const.Null);
		view3=inflater.inflate(R.layout.view_pager_page3, (android.view.ViewGroup)My.Const.Null);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		MyViewPager.setAdapter(new MyViewPagerAdapter(views));
		MyViewPager.setCurrentItem(0);
		MyViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	//标题初始化
	private void InitTextView() {
		TitleText1 = (android.widget.TextView) findViewById(R.id.title1);
		TitleText2 = (android.widget.TextView) findViewById(R.id.title2);
		TitleText3 = (android.widget.TextView) findViewById(R.id.title3);
		TitleText1.setOnClickListener(new MyOnClickListener(0));
		TitleText2.setOnClickListener(new MyOnClickListener(1));
		TitleText3.setOnClickListener(new MyOnClickListener(2));
	}
	//横线图片初始化
	private void InitImageView() {
		LineImage= (android.widget.ImageView) findViewById(R.id.line);
		LineImageWidth = android.graphics.BitmapFactory.decodeResource(getResources(), R.drawable.line).getWidth();// 获取图片宽度
		offset = (My.Screen.ScreenWidth() / 3 - LineImageWidth) / 2;// 计算偏移量
		android.graphics.Matrix matrix = new android.graphics.Matrix();
		matrix.postTranslate(offset, 0);
		LineImage.setImageMatrix(matrix);// 设置横线图片初始位置
	}
	//标题点击事件
	private class MyOnClickListener implements android.view.View.OnClickListener{
        private int index=0;
        public MyOnClickListener(int i){
        	index=i;
        }
		public void onClick(android.view.View v) {
			MyViewPager.setCurrentItem(index);			
		}
	}
	//自定义适配器
	public class MyViewPagerAdapter extends android.support.v4.view.PagerAdapter{
		private java.util.List<android.view.View> mListViews;
		public MyViewPagerAdapter(java.util.List<android.view.View> mListViews) {
			this.mListViews = mListViews;
		}
		@Override
		public void destroyItem(android.view.ViewGroup container, int position, Object object) 	{	
			container.removeView(mListViews.get(position));
		}@Override
		public Object instantiateItem(android.view.ViewGroup container, int position) {			
			 container.addView(mListViews.get(position), 0);
			 return mListViews.get(position);
		}
		@Override
		public int getCount() {			
			return  mListViews.size();
		}
		@Override
		public boolean isViewFromObject(android.view.View arg0, Object arg1) {			
			return arg0==arg1;
		}
	}
	//切换动画
    public class MyOnPageChangeListener implements android.support.v4.view.ViewPager.OnPageChangeListener{
    	int one = offset * 2 + LineImageWidth;// 页卡1 -> 页卡2 偏移量（单倍）
		int two = one * 2;// 页卡1 -> 页卡3 偏移量（双倍）
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
		}
		public void onPageSelected(int arg0) {
			android.view.animation.Animation animation = new android.view.animation.TranslateAnimation(one*PageIndex, one*arg0, 0, 0);
			PageIndex = arg0;
			animation.setFillAfter(true);// True：图片停在动画结束位置
			animation.setDuration(300);//动画时间300毫秒
			LineImage.startAnimation(animation);
		}
    	
    }
}
