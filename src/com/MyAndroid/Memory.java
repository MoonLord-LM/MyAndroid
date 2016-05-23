package com.MyAndroid;

// 内存管理
//（动态类+静态函数库）
public class Memory {
	private android.app.Activity MyActivity;
	public Memory(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 可用内存（单位B）
	public long AvailableMemory() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.availMem;
	}
	// 可用内存（单位KB）
	public long AvailableMemoryKB() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.availMem / 1024;
	}
	// 可用内存（单位MB）
	public int AvailableMemoryMB() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return (int) (outInfo.availMem / 1024 / 1024);
	}
	// 内存临界值（单位B）
	public long ThresholdMemory() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.threshold;
	}
	// 内存临界值（单位KB）
	public long ThresholdMemoryKB() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.threshold / 1024;
	}
	// 内存临界值（单位MB）
	public int ThresholdMemoryMB() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return (int) (outInfo.threshold / 1024 / 1024);
	}
	// 系统是否处于低内存状态
	public boolean IsLowMemory() {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.lowMemory;
	}
	// 物理总内存（单位B）
	public static long TotalMemory() {
		return (int) (TotalMemoryKB() * 1024);
	}
	// 物理总内存（单位KB）
	public static long TotalMemoryKB() {
		// 以下是android:minSdkVersion在16以上的写法：
		// android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		// ((android.app.ActivityManager) MyActivity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		// return outInfo.totalMem;
		java.lang.StringBuffer res = new java.lang.StringBuffer("");
		java.io.BufferedReader in = null;
		try {
			// "/proc/meminfo"为系统内存信息文件
			// 文件第一行内容如下（每行固定长度27）：
			// MemTotal: 94096 kB
			// Log(My.IO.ReadLine(info).replaceAll("MemTotal:", "").replaceAll(" kB", "").trim());
			in = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/meminfo"), "UTF-8"));
			java.lang.String inputLine = null;
			if ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
			}
			catch (Exception e) {}
		}
		return Long.valueOf("0" + res.toString().replaceAll("MemTotal:", "").toLowerCase(java.util.Locale.PRC).replaceAll("kb", "").trim());
	}
	// 物理总内存（单位MB）
	public static int TotalMemoryMB() {
		return (int) (TotalMemoryKB() / 1024);
	}
	// 强制结束自身（结束进程）
	public static void KillMyself() {
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	// 强制结束自身（关闭JAVA虚拟机）
	public static void ExitProgram() {
		System.exit(0);
	}
	public static long AvailableMemory(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.availMem;
	}
	public static long AvailableMemoryKB(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.availMem / 1024;
	}
	public static int AvailableMemoryMB(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return (int) (outInfo.availMem / 1024 / 1024);
	}
	public static long ThresholdMemory(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.threshold;
	}
	public static long ThresholdMemoryKB(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.threshold / 1024;
	}
	public static int ThresholdMemoryMB(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return (int) (outInfo.threshold / 1024 / 1024);
	}
	public static boolean IsLowMemory(android.app.Activity Activity) {
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		((android.app.ActivityManager) Activity.getSystemService(android.content.Context.ACTIVITY_SERVICE)).getMemoryInfo(outInfo);
		return outInfo.lowMemory;
	}
}
