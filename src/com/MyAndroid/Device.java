package com.MyAndroid;

// 获取设备信息
//（纯静态函数库）
public class Device {
	public static int SDK() {//安卓SDK版本号
		return android.os.Build.VERSION.SDK_INT;
	}
	public static java.lang.String AndroidVersion() {// 安卓版本号
		return android.os.Build.VERSION.RELEASE;
	}
	public static java.lang.String Brand() {// 商标
		return android.os.Build.BRAND;
	}
	public static java.lang.String Design() {//设计名称
		return android.os.Build.DEVICE;
	}
	public static java.lang.String Name() {//设备展示名称
		return android.os.Build.DISPLAY;
	}
	public static java.lang.String FingerPrint() {// 产品指纹（唯一）
		return android.os.Build.FINGERPRINT;
	}
	public static java.lang.String ID() {//设备型号
		return android.os.Build.ID;
	}
	public static java.lang.String KernelHardware() {// 核心硬件型号
		return android.os.Build.HARDWARE;
	}
	public static java.lang.String Manufacturer() {// 制造商
		return android.os.Build.MANUFACTURER;
	}
	public static java.lang.String SerialNumber() {// 序列号
		return android.os.Build.SERIAL;
	}
	public static java.lang.String User() {//用户名称
		return android.os.Build.USER;
	}
	public static java.lang.String ProductName() {// 商品名称
		return android.os.Build.MODEL;
	}
	public static java.lang.String ProductTime() {// 生产日期（中国时区，标准日期格式）
		java.util.Date date = new java.util.Date(android.os.Build.TIME);
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.PRC);
		return formatter.format(date);
	}
	public static java.lang.String ProductTimeInChinese() {// 生产日期（中国时区，中文日期格式）
		java.util.Date date = new java.util.Date(android.os.Build.TIME);
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", java.util.Locale.PRC);
		return formatter.format(date);
	}
}
