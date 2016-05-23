package com.MyAndroid;

//Fragment扩展类
//（将项目的所有Fragment继承extends这个类）
public class Fragment extends android.app.Fragment {
	// Fragment生命周期监控
	// 按照执行的先后顺序由上到下依次排列
	@Override
	public void onAttach(android.app.Activity activity) {
		super.onAttach(activity);
		Activity = activity;
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onAttach()");
	}
	@Override
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onCreate(savedInstanceState：" + (savedInstanceState != null && savedInstanceState.size() != 0 ? "NotEmpty" : "Empty") + ")");
	}
	@Override
	public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState) {
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onCreateView(savedInstanceState：" + (savedInstanceState != null && savedInstanceState.size() != 0 ? "NotEmpty" : "Empty") + ")");
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(android.os.Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onActivityCreated()");
	}
	@Override
	public void onStart() {
		super.onStart();
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onStart()");
	}
	@Override
	public void onResume() {
		super.onResume();
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onResume()");
	}
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onHiddenChanged(hidden：" + hidden + ")");
	}
	@Override
	public void onSaveInstanceState(android.os.Bundle outState) {
		super.onSaveInstanceState(outState);
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onSaveInstanceState(outState：" + (outState != null && outState.size() != 0 ? "NotEmpty" : "Empty") + ")");
	}
	@Override
	public void onPause() {
		super.onPause();
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onPause()");
	}
	@Override
	public void onStop() {
		super.onStop();
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onStop()");
	}
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onDestroyView()");
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Activity = null;
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onDestroy()");
	}
	@Override
	public void onDetach() {
		super.onDetach();
		Activity = null;
		android.util.Log.v("Fragment  @" + Integer.toHexString(hashCode()), "Fragment-onDetach()");
	}
	// 保存对Activity的引用（Activity在onAttach、onDetach、onDestroy中调用）
	public android.app.Activity Activity;
}
