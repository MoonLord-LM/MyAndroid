package com.MoonLord;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener, DialogInterface.OnMultiChoiceClickListener {
	// 示例写法，建议Copy到子类中并修改后使用。
	// Instance方法，使得在全局内可以访问到Fragment的当前实例。
	private static MyFragment MyInstance = null;
	public static MyFragment Instance() {
		if (MyInstance == null) {
			MyInstance = new MyFragment();
		}
		return MyInstance;
	}
	// OnClickListener接口实现
	@Override
	public void onClick(View v) {}
	@Override
	public void onClick(DialogInterface dialog, int which) {}
	@Override
	public void onClick(DialogInterface dialog, int which, boolean isChecked) {}
	// 生命周期事件监控（发生顺序由上到下）
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		My.LogCat.Log("MyFragment-onAttach");
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		My.LogCat.Log("MyFragment-onCreate");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		My.LogCat.Log("MyFragment-onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		My.LogCat.Log("MyFragment-onActivityCreated");
	}
	@Override
	public void onStart() {
		super.onStart();
		My.LogCat.Log("MyFragment-onStart");
	}
	@Override
	public void onResume() {
		super.onResume();
		My.LogCat.Log("MyFragment-onResume");
	}
	@Override
	public void onPause() {
		super.onPause();
		My.LogCat.Log("MyFragment-onPause");
	}
	@Override
	public void onStop() {
		super.onStop();
		My.LogCat.Log("MyFragment-onStop");
	}
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		My.LogCat.Log("MyFragment-onDestroyView");
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		My.LogCat.Log("MyFragment-onDestroy");
	}
	@Override
	public void onDetach() {
		super.onDetach();
		My.LogCat.Log("MyFragment-onDetach");
	}
}
