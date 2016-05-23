package com.MyAndroid;

// 获取时间
//（纯静态函数库）
public class Time {
	public static long Now() {// 当前时间（毫秒单位）
		return java.lang.System.currentTimeMillis();
	}
	public static java.lang.String NowString() {// 当前时间（中国时区，标准日期格式）
		java.util.Date date = new java.util.Date(java.lang.System.currentTimeMillis());
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.PRC);
		return formatter.format(date);
	}
	public static java.lang.String NowStringInChinese() {// 当前时间（中国时区，中文日期格式）
		java.util.Date date = new java.util.Date(java.lang.System.currentTimeMillis());
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", java.util.Locale.PRC);
		return formatter.format(date);
	}
	public static long SystemElapsedTime() {// 从开机到现在，系统一共过去的时间（毫秒单位）
		return android.os.SystemClock.elapsedRealtime();
	}
	public static long SystemUpTime() {// 从开机到现在，系统的非睡眠状态时间（毫秒单位）
		return android.os.SystemClock.uptimeMillis();
	}
	public static long CurrentThreadTime() {// 当前线程的运行时间（毫秒单位）
		return android.os.SystemClock.currentThreadTimeMillis();
	}
	public static java.lang.String SystemElapsedTimeString() {// 从开机到现在，系统的非睡眠状态时间（精确到秒）
		return PastTimeInChinese(android.os.SystemClock.elapsedRealtime());
	}
	public static java.lang.String SystemUpTimeString() {// 从开机到现在，系统的非睡眠状态时间（精确到秒）
		return PastTimeInChinese(android.os.SystemClock.uptimeMillis());
	}
	public static java.lang.String CurrentThreadTimeString() {// 当前线程的运行时间（精确到秒）
		return PastTimeInChinese(android.os.SystemClock.currentThreadTimeMillis());
	}
	private static java.lang.String PastTimeInChinese(long Time) {// 将时间差转换为字符串（精确到秒）
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTimeInMillis(Time);
		java.lang.String returnString = "";
		// 原始时间格式1970-01-01 08:00:00
		int year = calendar.get(java.util.Calendar.YEAR) - 1970;
		int month = calendar.get(java.util.Calendar.MONTH) - 1;
		int day = calendar.get(java.util.Calendar.DAY_OF_MONTH) - 1;
		int hour = calendar.get(java.util.Calendar.HOUR_OF_DAY) - 8;
		int minute = calendar.get(java.util.Calendar.MINUTE);
		int second = calendar.get(java.util.Calendar.SECOND);
		if (day > 0 && hour < 0) {
			day = day - 1;
			hour = 24 + hour;
		}
		if (year > 0) {
			returnString += year + "年";
		}
		if (year > 0 || month > 0) {
			returnString += month + "月";
		}
		if (year > 0 || month > 0 || day > 0) {
			returnString += day + "日";
		}
		if (year > 0 || month > 0 || day > 0 || hour > 0) {
			returnString += hour + "时";
		}
		if (year > 0 || month > 0 || day > 0 || hour > 0 || minute > 0) {
			returnString += minute + "分";
		}
		if (year > 0 || month > 0 || day > 0 || hour > 0 || minute > 0 || second > 0) {
			returnString += second + "秒";
		}
		else {
			returnString = "0秒";
		}
		return returnString;
	}
}
