package com.MyAndroid.Frame;

import com.MyAndroid.Json;

//基于Json数据的通用适配器
//注意：
//Json数据应为数组格式
//适用于GridView和ListView等
public abstract class JsonAdapter extends android.widget.BaseAdapter{
	//公共变量
	public android.view.LayoutInflater Inflater = null;
	public Json Content = null;
	public android.content.Context Acvivity = null;
	public android.content.Context getAcvivity() { return Acvivity; }
	public android.view.LayoutInflater getInflater() { return Inflater; }
	public Json getContent() { return Content; }
	//构造函数（Activity和Json数据）
	public JsonAdapter(android.content.Context context, Json content){
		Acvivity = context;
		Inflater = android.view.LayoutInflater.from(context);
		Content = new Json(content);
	}
	//需要实现的方法
	@Override
	public int getCount() { return Content.Length; }
	@Override
	public Object getItem(int position) { return Content.GetJson(position); }
	@Override
	public long getItemId(int position) { return position; }
	//必须重写以下方法，完成视图的创建
	@Override
	public abstract android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent);
}
