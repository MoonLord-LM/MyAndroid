package com.MyAndroid;

// 定时器任务
// 注意：定时器使用单线程执行任务，加法计算执行任务的时间点，所以循环任务的平均执行间隔为：Max（任务耗费的时间，设定的执行间隔）
// 注意：不建议在外部使用cancel()，因为会使Task的线程在进入就绪状态后结束，不可以再重用
// 注意：不建议在外部使用schedule()和purge()函数进行任务的添加和清除，Task类是为单一任务的时间调度设计的
// 注意：在Activity中使用定时器任务时，应当在Activity的onResume，onPause，onStop中分别调用Resume，Pause，Stop
// 注意：Task的run函数在Task创建的线程中执行，UITask的run函数在UI线程中运行
public class Timer {
	public static abstract class Task extends java.util.Timer implements Runnable {
		java.util.TimerTask TimerTask;
		long TaskDelay = -1;
		long TaskPeriod = -1;
		// 循环多次的任务，参数为第一次执行任务的延迟时间和执行任务的间隔时间
		public Task(long delay, long period) {
			super(true);
			TaskDelay = delay;
			TaskPeriod = period;
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					Task.this.run();
				}
			};
			this.scheduleAtFixedRate(TimerTask, TaskDelay, TaskPeriod);
		}
		// 循环多次的任务，参数为执行任务的间隔时间（也是第一次执行任务的延迟时间）
		public Task(long period) {
			super(true);
			TaskPeriod = period;
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					Task.this.run();
				}
			};
			this.scheduleAtFixedRate(TimerTask, TaskPeriod, TaskPeriod);
		}
		// 单次执行的任务（可使用Restart函数，再执行一次）
		public Task() {
			super(true);
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					Task.this.Pause();
					Task.this.run();
				}
			};
			this.scheduleAtFixedRate(TimerTask, 0, 1);
		}
		// 暂停当前的所有任务（正在执行的任务还是会执行完成，多次调用本函数无作用）
		public void Pause() {
			if (TimerTask != null) {
				TimerTask.cancel();
			}
			this.purge();
			TimerTask = null;
		}
		// 彻底停止任务并销毁定时器（正在执行的任务还是会执行完成，调用本函数后再调用Resume会发生异常）
		public void Stop() {
			this.cancel();
			TimerTask = null;
		}
		// 重新启动任务调度（正在执行的任务还是会执行完成，本函数会为Timer创建新线程）
		public void Resume() {
			this.Pause();
			if (TaskDelay < 0 && TaskPeriod < 0) {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						Task.this.run();
					}
				};
				this.scheduleAtFixedRate(TimerTask, 0, 1);
			}
			else if (TaskDelay < 0) {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						Task.this.run();
					}
				};
				this.scheduleAtFixedRate(TimerTask, TaskPeriod, TaskPeriod);
			}
			else {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						Task.this.run();
					}
				};
				this.scheduleAtFixedRate(TimerTask, TaskDelay, TaskPeriod);
			}
		}
		// 线程暂停
		public void ThreadSleep(long time) {
			try {
				Thread.sleep(time);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 需要实现的接口
		@Override
		public abstract void run();
	}
	public static abstract class UITask extends java.util.Timer implements Runnable {
		java.util.TimerTask TimerTask;
		long TaskDelay = -1;
		long TaskPeriod = -1;
		private android.app.Activity MyActivity;
		// 循环多次的任务，参数为第一次执行任务的延迟时间和执行任务的间隔时间
		public UITask(android.app.Activity Activity, long delay, long period) {
			super(true);
			MyActivity = Activity;
			TaskDelay = delay;
			TaskPeriod = period;
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					MyActivity.runOnUiThread(UITask.this);
				}
			};
			this.scheduleAtFixedRate(TimerTask, TaskDelay, TaskPeriod);
		}
		// 循环多次的任务，参数为执行任务的间隔时间（也是第一次执行任务的延迟时间）
		public UITask(android.app.Activity Activity, long period) {
			super(true);
			MyActivity = Activity;
			TaskPeriod = period;
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					MyActivity.runOnUiThread(UITask.this);
				}
			};
			this.scheduleAtFixedRate(TimerTask, TaskPeriod, TaskPeriod);
		}
		// 单次执行的任务（可使用Restart函数，再执行一次）
		public UITask(android.app.Activity Activity) {
			super(true);
			MyActivity = Activity;
			TimerTask = new java.util.TimerTask() {
				@Override
				public void run() {
					UITask.this.Pause();
					MyActivity.runOnUiThread(UITask.this);
				}
			};
			this.scheduleAtFixedRate(TimerTask, 0, 1);
		}
		// 暂停当前的所有任务（正在执行的任务还是会执行完成，多次调用本函数无作用）
		public void Pause() {
			if (TimerTask != null) {
				TimerTask.cancel();
			}
			this.purge();
			TimerTask = null;
		}
		// 彻底停止任务并销毁定时器（正在执行的任务还是会执行完成，调用本函数后再调用Resume会发生异常）
		public void Stop() {
			this.cancel();
			TimerTask = null;
			MyActivity = null;
		}
		// 重新启动任务调度（正在执行的任务还是会执行完成，本函数会为Timer创建新线程）
		public void Resume() {
			this.Pause();
			if (TaskDelay < 0 && TaskPeriod < 0) {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						MyActivity.runOnUiThread(UITask.this);
					}
				};
				this.scheduleAtFixedRate(TimerTask, 0, 1);
			}
			else if (TaskDelay < 0) {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						MyActivity.runOnUiThread(UITask.this);
					}
				};
				this.scheduleAtFixedRate(TimerTask, TaskPeriod, TaskPeriod);
			}
			else {
				TimerTask = new java.util.TimerTask() {
					@Override
					public void run() {
						MyActivity.runOnUiThread(UITask.this);
					}
				};
				this.scheduleAtFixedRate(TimerTask, TaskDelay, TaskPeriod);
			}
		}
		// 线程暂停
		public void ThreadSleep(long time) {
			try {
				Thread.sleep(time);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 需要实现的接口
		@Override
		public abstract void run();
	}
	// 代码示例（3种写法都是，先等待10秒执行一次Log.w，然后每隔10秒执行一次Log.w）：
	/*
	 * new Task(10000, 10000) {
	 * 
	 * @Override public void run() { android.util.Log.w("Task  @" + Integer.toHexString(hashCode()), "Task1    " + Time.Now()); this.ThreadSleep(10000); } }; new Task(10000) {
	 * 
	 * @Override public void run() { android.util.Log.w("Task  @" + Integer.toHexString(hashCode()), "Task2    " + Time.Now()); } }; new Task() {
	 * 
	 * @Override public void run() { this.ThreadSleep(10000); android.util.Log.w("Task  @" + Integer.toHexString(hashCode()), "Task3    " + Time.Now()); this.Restart(); } };
	 */
	// 代码示例（写在UI线程中，等效于不使用UITask）：
	/*
	 * new UITask(this) {
	 * 
	 * @Override public void run() { ((LinearLayout) findViewById(R.id.MAIN)).setBackgroundColor((new RainbowColor()).NextColor()); this.Stop(); } };
	 */
}
