package com.MyAndroid;

//Activity扩展类
//（将项目的所有Activity继承extends这个类）
public class Activity extends android.app.Activity {
	// 用于跨线程通信的Hander
	// 其它的可以跨线程访问UI的方法还有：
	// Activity.runOnUiThread(Runnable)，View.post(Runnable)，View.postDelayed(Runnable, long)，UserTask/AsyncTask等
	public ActivityHandler Handler = new ActivityHandler();
	public static class ActivityHandler extends android.os.Handler {
		@Override
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
		}
	}
	// Activity生命周期监控
	// 按照执行的先后顺序由上到下依次排列
	@Override
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onCreate(savedInstanceState：" + (savedInstanceState != null && savedInstanceState.size() != 0 ? "NotEmpty" : "Empty") + ")");
	}
	@Override
	protected void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onRestoreInstanceState(savedInstanceState：" + (savedInstanceState != null && savedInstanceState.size() != 0 ? "NotEmpty" : "Empty") + ")");
	}
	@Override
	protected void onStart() {
		super.onStart();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onStart()");
	}
	@Override
	protected void onResume() {
		super.onResume();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onResume()");
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onWindowFocusChanged(hasFocus：" + hasFocus + ")");
	}
	@Override
	protected void onSaveInstanceState(android.os.Bundle outState) {
		super.onSaveInstanceState(outState);
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onSaveInstanceState(outState：" + (outState != null && outState.size() != 0 ? "NotEmpty" : "Empty") + ")");
	}
	@Override
	protected void onPause() {
		super.onPause();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onPause(isFinishing：" + isFinishing() + ")");
	}
	@Override
	protected void onStop() {
		super.onStop();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onStop()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onRestart()");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onDestroy()");
	}
	@Override
	public void onAttachFragment(android.app.Fragment fragment) {
		super.onAttachFragment(fragment);
		android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "Activity-onAttachFragment(fragment：" + fragment + ")");
	}
	// Activity的名称（依次分别为：类名，包名，全部名称。例如，依次为：MainActivity，com.MoonLord.MyStudy，com.MoonLord.MyStudy.MainActivity）
	public java.lang.String ClassName() {
		return this.getClass().getSimpleName();
	}
	public java.lang.String PackageName() {
		return this.getPackageName();
	}
	public java.lang.String FullClassName() {
		return this.getClass().getName();
	}
	// 内部的Fragment切换函数
	// 可在AndroidManifest.xml的activity节点下使用android:configChanges="orientation|keyboardHidden|screenSize"，阻止Activity在切换横竖屏时候的重建，但是要注意此时并没有解决Activity因为内存不足而重启导致的Fragment问题
	public android.app.Fragment FadeFragment(int containerViewId, android.app.Fragment showFragment, java.lang.String showFragmentTag, android.app.Fragment hideFragment, java.lang.String hideFragmentTag) {
		try {
			if (hideFragmentTag == null) {// hideFragmentTag为null，第一次加载
				if (hideFragment != null) {
					android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error1：hideFragment is not null！");
				}
				else {
					if (showFragmentTag == null) {
						android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error2：showFragmentTag is null！");
					}
					else {
						if (showFragment == null) {
							showFragment = this.getFragmentManager().findFragmentByTag(showFragmentTag);
						}
						if (showFragment == null) {
							android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error3：showFragment is null！");
						}
						else {
							if (showFragment.isAdded()) {
								android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment()：showFragment is added！");
							}
							else {
								this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).commit();
							}
						}
					}
				}
			}
			else {// hideFragmentTag不为null，进行切换
				if (hideFragment == null) {
					hideFragment = this.getFragmentManager().findFragmentByTag(hideFragmentTag);
				}
				if (hideFragment == null) {
					android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error4：hideFragment is null！");
				}
				else {
					if (showFragmentTag == null) {
						android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error5：showFragmentTag is null！");
					}
					else {
						if (showFragmentTag == hideFragmentTag) {
							android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment()：showFragmentTag is hideFragmentTag！");
						}
						else {
							if (showFragment == null) {
								showFragment = this.getFragmentManager().findFragmentByTag(showFragmentTag);
							}
							if (showFragment == null) {
								android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error6：showFragment is null！");
							}
							else {
								if (showFragment == hideFragment) {
									android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment()：showFragment is hideFragment！");
								}
								else {
									if (showFragment.isAdded()) {
										if (hideFragment.isAdded()) {// 正常切换
											this.getFragmentManager().beginTransaction().show(showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
										}
										else {
											this.getFragmentManager().beginTransaction().show(showFragment).commit();
											android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error7：hideFragment is not added！");
										}
									}
									else {
										if (hideFragment.isAdded()) {// 载入新的
											this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).hide(hideFragment).setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
										}
										else {
											this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).commit();
											android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "FadeFragment() Error8：hideFragment is not added！");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return showFragment;// 返回当前显示的Fragment
	}
	public android.app.Fragment SlideFragment(int containerViewId, android.app.Fragment showFragment, java.lang.String showFragmentTag, android.app.Fragment hideFragment, java.lang.String hideFragmentTag) {
		try {
			if (hideFragmentTag == null) {// hideFragmentTag为null，第一次加载
				if (hideFragment != null) {
					android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error1：hideFragment is not null！");
				}
				else {
					if (showFragmentTag == null) {
						android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error2：showFragmentTag is null！");
					}
					else {
						if (showFragment == null) {
							showFragment = this.getFragmentManager().findFragmentByTag(showFragmentTag);
						}
						if (showFragment == null) {
							android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error3：showFragment is null！");
						}
						else {
							if (showFragment.isAdded()) {
								android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment()：showFragment is added！");
							}
							else {
								this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).commit();
							}
						}
					}
				}
			}
			else {// hideFragmentTag不为null，进行切换
				if (hideFragment == null) {
					hideFragment = this.getFragmentManager().findFragmentByTag(hideFragmentTag);
				}
				if (hideFragment == null) {
					android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error4：hideFragment is null！");
				}
				else {
					if (showFragmentTag == null) {
						android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error5：showFragmentTag is null！");
					}
					else {
						if (showFragmentTag == hideFragmentTag) {
							android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment()：showFragmentTag is hideFragmentTag！");
						}
						else {
							if (showFragment == null) {
								showFragment = this.getFragmentManager().findFragmentByTag(showFragmentTag);
							}
							if (showFragment == null) {
								android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error6：showFragment is null！");
							}
							else {
								if (showFragment == hideFragment) {
									android.util.Log.v("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment()：showFragment is hideFragment！");
								}
								else {
									if (showFragment.isAdded()) {
										if (hideFragment.isAdded()) {// 正常切换
											this.getFragmentManager().beginTransaction().show(showFragment).hide(hideFragment).setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).commit();
										}
										else {
											this.getFragmentManager().beginTransaction().show(showFragment).commit();
											android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error7：hideFragment is not added！");
										}
									}
									else {
										if (hideFragment.isAdded()) {// 载入新的
											this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).hide(hideFragment).setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).commit();
										}
										else {
											this.getFragmentManager().beginTransaction().add(containerViewId, showFragment, showFragmentTag).commit();
											android.util.Log.w("Activity  @" + Integer.toHexString(hashCode()), "SlideFragment() Error8：hideFragment is not added！");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return showFragment;// 返回当前显示的Fragment
	}
	// Fragment切换代码示例1：
	// 使用findFragmentByTag进行Fragment的状态恢复，注意因为没有保存Fragment的显示隐藏状态，所以要保证背景不透明
	/*
	 * public Fragment ContentFragment; public String ContentFragmentTag; public FragmentA FragmentA; public FragmentB FragmentB; public FragmentC FragmentC; public FragmentD FragmentD;
	 * 
	 * @Override public void onClick(View v) { switch (v.getId()) { case R.id.button1: if(FragmentA==null && getFragmentManager().findFragmentByTag("FragmentA")==null){ FragmentA = new FragmentA(); } ContentFragment = FadeFragment(R.id.content, FragmentA,
	 * "FragmentA", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentA"; break; case R.id.button2: if(FragmentB==null&& getFragmentManager().findFragmentByTag("FragmentB")==null){ FragmentB = new FragmentB(); } ContentFragment =
	 * FadeFragment(R.id.content, FragmentB, "FragmentB", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentB"; break; case R.id.button3: if(FragmentC==null&& getFragmentManager().findFragmentByTag("FragmentC")==null){ FragmentC = new
	 * FragmentC(); } ContentFragment = FadeFragment(R.id.content, FragmentC, "FragmentC", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentC"; break; case R.id.button4: if(FragmentD==null&&
	 * getFragmentManager().findFragmentByTag("FragmentD")==null){ FragmentD = new FragmentD(); } ContentFragment = FadeFragment(R.id.content, FragmentD, "FragmentD", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentD"; break; default:
	 * break; } }
	 */
	// Fragment切换代码示例2：
	// 使用getFragmentManager()的putFragment和getFragment，进行Fragment的状态恢复，注意因为没有保存Fragment的显示隐藏状态，所以要保证背景不透明
	/*
	 * public Fragment ContentFragment; public String ContentFragmentTag; public FragmentA FragmentA; public FragmentB FragmentB; public FragmentC FragmentC; public FragmentD FragmentD;
	 * 
	 * @Override public void onClick(View v) { switch (v.getId()) { case R.id.button1: if(FragmentA==null){ FragmentA = new FragmentA(); } ContentFragment = FadeFragment(R.id.content, FragmentA, "FragmentA", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentA"; break; case R.id.button2: if(FragmentB==null){ FragmentB = new FragmentB(); } ContentFragment = FadeFragment(R.id.content, FragmentB, "FragmentB", ContentFragment, ContentFragmentTag); ContentFragmentTag =
	 * "FragmentB"; break; case R.id.button3: if(FragmentC==null){ FragmentC = new FragmentC(); } ContentFragment = FadeFragment(R.id.content, FragmentC, "FragmentC", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentC"; break; case
	 * R.id.button4: if(FragmentD==null){ FragmentD = new FragmentD(); } ContentFragment = FadeFragment(R.id.content, FragmentD, "FragmentD", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentD"; break; default: break; } } protected void
	 * onSaveInstanceState(android.os.Bundle outState) { if (FragmentA !=null) { getFragmentManager().putFragment(outState, "FragmentA", FragmentA); } if (FragmentB !=null) { getFragmentManager().putFragment(outState, "FragmentB", FragmentB); } if
	 * (FragmentC !=null) { getFragmentManager().putFragment(outState, "FragmentC", FragmentC); } if (FragmentD !=null) { getFragmentManager().putFragment(outState, "FragmentD", FragmentD); } super.onSaveInstanceState(outState); }
	 * 
	 * @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); if (savedInstanceState != null) { FragmentA = (FragmentA) getFragmentManager().getFragment(savedInstanceState, "FragmentA"); FragmentB =(FragmentB)
	 * getFragmentManager().getFragment(savedInstanceState, "FragmentB"); FragmentC = (FragmentC) getFragmentManager().getFragment(savedInstanceState, "FragmentC"); FragmentD =(FragmentD) getFragmentManager().getFragment(savedInstanceState, "FragmentD");
	 * } setContentView(R.layout.activity_main); }
	 */
	// Fragment切换代码示例3：
	// 使用onAttachFragment，进行Fragment的状态恢复，注意因为没有保存Fragment的显示隐藏状态，所以要保证背景不透明
	/*
	 * public Fragment ContentFragment; public String ContentFragmentTag; public FragmentA FragmentA; public FragmentB FragmentB; public FragmentC FragmentC; public FragmentD FragmentD;
	 * 
	 * @Override public void onClick(View v) { switch (v.getId()) { case R.id.button1: if (FragmentA == null) { FragmentA = new FragmentA(); } ContentFragment = FadeFragment(R.id.content, FragmentA, "FragmentA", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentA"; break; case R.id.button2: if (FragmentB == null) { FragmentB = new FragmentB(); } ContentFragment = FadeFragment(R.id.content, FragmentB, "FragmentB", ContentFragment, ContentFragmentTag); ContentFragmentTag =
	 * "FragmentB"; break; case R.id.button3: if (FragmentC == null) { FragmentC = new FragmentC(); } ContentFragment = FadeFragment(R.id.content, FragmentC, "FragmentC", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentC"; break; case
	 * R.id.button4: if (FragmentD == null) { FragmentD = new FragmentD(); } ContentFragment = FadeFragment(R.id.content, FragmentD, "FragmentD", ContentFragment, ContentFragmentTag); ContentFragmentTag = "FragmentD"; break; default: break; } }
	 * 
	 * @Override public void onAttachFragment(Fragment fragment) { super.onAttachFragment(fragment); if (FragmentA == null && fragment instanceof FragmentA) { FragmentA = (FragmentA) fragment; } else if (FragmentB == null && fragment instanceof FragmentB)
	 * { FragmentB = (FragmentB) fragment; } else if (FragmentC == null && fragment instanceof FragmentC) { FragmentC = (FragmentC) fragment; } else if (FragmentD == null && fragment instanceof FragmentD) { FragmentD = (FragmentD) fragment; } }
	 */
	// Fragment切换代码示例4：
	// 在代码示例3的基础上保存了Fragment的显示隐藏状态，所以即使背景透明也不会有重叠发生
	/*
	 * public Fragment ContentFragment; public String ContentFragmentTag; public FragmentA FragmentA; public FragmentB FragmentB; public FragmentC FragmentC; public FragmentD FragmentD; public int ShowIndex;
	 * 
	 * @Override public void onClick(View v) { switch (v.getId()) { case R.id.button1: if (FragmentA == null) { FragmentA = new FragmentA(); } ContentFragment = FadeFragment(R.id.content, FragmentA, "FragmentA", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentA"; ShowIndex =1; break; case R.id.button2: if (FragmentB == null) { FragmentB = new FragmentB(); } ContentFragment = FadeFragment(R.id.content, FragmentB, "FragmentB", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentB"; ShowIndex =2; break; case R.id.button3: if (FragmentC == null) { FragmentC = new FragmentC(); } ContentFragment = FadeFragment(R.id.content, FragmentC, "FragmentC", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentC"; ShowIndex =3; break; case R.id.button4: if (FragmentD == null) { FragmentD = new FragmentD(); } ContentFragment = FadeFragment(R.id.content, FragmentD, "FragmentD", ContentFragment, ContentFragmentTag);
	 * ContentFragmentTag = "FragmentD"; ShowIndex =4; break; default: break; } }
	 * 
	 * @Override public void onAttachFragment(Fragment fragment) { super.onAttachFragment(fragment); if (FragmentA == null && fragment instanceof FragmentA) { FragmentA = (FragmentA) fragment; } else if (FragmentB == null && fragment instanceof FragmentB)
	 * { FragmentB = (FragmentB) fragment; } else if (FragmentC == null && fragment instanceof FragmentC) { FragmentC = (FragmentC) fragment; } else if (FragmentD == null && fragment instanceof FragmentD) { FragmentD = (FragmentD) fragment; } } protected
	 * void onSaveInstanceState(android.os.Bundle outState) { outState.putInt("ShowIndex", ShowIndex); super.onSaveInstanceState(outState); }
	 * 
	 * @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); if (savedInstanceState != null) { ShowIndex = savedInstanceState.getInt("ShowIndex"); if (ShowIndex != 0) { FragmentTransaction HideTransaction =
	 * this.getFragmentManager().beginTransaction(); if (ShowIndex != 1) { HideTransaction.hide(FragmentA); } else { ContentFragment = FragmentA; ContentFragmentTag = "FragmentA"; } if (ShowIndex != 2) { HideTransaction.hide(FragmentB); } else {
	 * ContentFragment = FragmentB; ContentFragmentTag = "FragmentB"; } if (ShowIndex != 3) { HideTransaction.hide(FragmentC); } else { ContentFragment = FragmentC; ContentFragmentTag = "FragmentC"; } if (ShowIndex != 4) { HideTransaction.hide(FragmentD);
	 * } else { ContentFragment = FragmentD; ContentFragmentTag = "FragmentD"; } HideTransaction.commit(); } } setContentView(R.layout.activity_main); }
	 */
}
