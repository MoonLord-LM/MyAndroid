package com.MyAndroid;

// WIFI管理
//（动态类+静态函数库）
//需要权限：<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"></uses-permission>
//需要权限：<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"></uses-permission>
public class WIFI {
	private android.app.Activity MyActivity;
	public WIFI(android.app.Activity Activity) {
		MyActivity = Activity;
	}
	// 开启设备WIFI
	public void Open() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		MyWifiManager.setWifiEnabled(true);
	}
	// 关闭设备WIFI
	public void Close() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		MyWifiManager.setWifiEnabled(false);
	}
	// 判断WIFI是否开启
	public boolean IsOpen() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.isWifiEnabled();
	}
	// 获取当前连接信息
	public android.net.wifi.WifiInfo Info() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.getConnectionInfo();
	}
	// 获取当前连接状态
	public int State() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.getWifiState();
	}
	// 获取已连接的WIFI名称（实测未连接则返回"<unknown ssid>"等值）
	public java.lang.String ConnectedName() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getSSID();
	}
	// 获取已连接的IP地址（实测未连接则返回"0.0.0.0"，连接成功则返回"192.168.191.2"等值）
	public java.lang.String ConnectedIP() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		int IPAddress = MyWifiInfo.getIpAddress();
		return (IPAddress & 0xff) + "." + (IPAddress >> 8 & 0xff) + "." + (IPAddress >> 16 & 0xff) + "." + (IPAddress >> 24 & 0xff);
	}
	// 获取已连接的MAC地址（实测未连接则会返回MAC地址，例如"00:08:22:05:3b:61"）
	public java.lang.String ConnectedMac() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getMacAddress();
	}
	// 获取已连接的信号强度（-113以下表示无信号，0表示最佳信号，也有说范围是-100到0，实测未连接则返回-200）
	public int ConnectedRssi() {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getRssi();
	}
	// 连接指定的WIFI（同时停用其它的账号密码，参数Type为加密类型，取值1-3，注意有延迟，且不一定能连接成功）
	public boolean Connect(java.lang.String SSID, java.lang.String Password, int Type, boolean disableOthers) {
		try {
			android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) MyActivity.getSystemService(android.content.Context.WIFI_SERVICE);
			//开启WIFI
			MyWifiManager.setWifiEnabled(true);
			android.net.wifi.WifiConfiguration config = new android.net.wifi.WifiConfiguration();
			config.allowedAuthAlgorithms.clear();
			config.allowedGroupCiphers.clear();
			config.allowedKeyManagement.clear();
			config.allowedPairwiseCiphers.clear();
			config.allowedProtocols.clear();
			config.SSID = "\"" + SSID + "\"";
			// 删除已经保存的密码
			java.util.List<android.net.wifi.WifiConfiguration> existingConfigs = MyWifiManager.getConfiguredNetworks();
			for (android.net.wifi.WifiConfiguration existingConfig : existingConfigs) {
				if (existingConfig.SSID.equals("\"" + SSID + "\"")) {
					MyWifiManager.removeNetwork(existingConfig.networkId);
				}
			}
			// WIFI加密类型
			if (Type == 1) // WIFICIPHER_NOPASS
			{
				config.wepKeys[0] = "";
				config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.NONE);
				config.wepTxKeyIndex = 0;
			}
			if (Type == 2) // WIFICIPHER_WEP
			{
				config.hiddenSSID = true;
				config.wepKeys[0] = "\"" + Password + "\"";
				config.allowedAuthAlgorithms.set(android.net.wifi.WifiConfiguration.AuthAlgorithm.SHARED);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.CCMP);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.TKIP);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.WEP40);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.WEP104);
				config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.NONE);
				config.wepTxKeyIndex = 0;
			}
			if (Type == 3) // WIFICIPHER_WPA
			{
				config.preSharedKey = "\"" + Password + "\"";
				config.hiddenSSID = true;
				config.allowedAuthAlgorithms.set(android.net.wifi.WifiConfiguration.AuthAlgorithm.OPEN);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.TKIP);
				config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.WPA_PSK);
				config.allowedPairwiseCiphers.set(android.net.wifi.WifiConfiguration.PairwiseCipher.TKIP);
				// config.allowedProtocols.set(android.net.wifi.WifiConfiguration.Protocol.WPA);
				config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.CCMP);
				config.allowedPairwiseCiphers.set(android.net.wifi.WifiConfiguration.PairwiseCipher.CCMP);
				config.status = android.net.wifi.WifiConfiguration.Status.ENABLED;
			}
			MyWifiManager.addNetwork(config);
			existingConfigs = MyWifiManager.getConfiguredNetworks();
			MyWifiManager.enableNetwork(existingConfigs.get(existingConfigs.size() - 1).networkId, disableOthers);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void Open(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		MyWifiManager.setWifiEnabled(true);
	}
	public static void Close(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		MyWifiManager.setWifiEnabled(false);
	}
	public static boolean IsOpen(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.isWifiEnabled();
	}
	public static android.net.wifi.WifiInfo Info(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.getConnectionInfo();
	}
	public static int State(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		return MyWifiManager.getWifiState();
	}
	public static java.lang.String ConnectedName(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getSSID();
	}
	public static java.lang.String ConnectedIP(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		int IPAddress = MyWifiInfo.getIpAddress();
		return (IPAddress & 0xff) + "." + (IPAddress >> 8 & 0xff) + "." + (IPAddress >> 16 & 0xff) + "." + (IPAddress >> 24 & 0xff);
	}
	public static java.lang.String ConnectedMac(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getMacAddress();
	}
	public static int ConnectedRssi(android.app.Activity Activity) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiInfo MyWifiInfo = MyWifiManager.getConnectionInfo();
		return MyWifiInfo.getRssi();
	}
	public static void Connect(android.app.Activity Activity, java.lang.String SSID, java.lang.String Password, int Type, boolean disableOthers) {
		android.net.wifi.WifiManager MyWifiManager = (android.net.wifi.WifiManager) Activity.getSystemService(android.content.Context.WIFI_SERVICE);
		android.net.wifi.WifiConfiguration config = new android.net.wifi.WifiConfiguration();
		config.allowedAuthAlgorithms.clear();
		config.allowedGroupCiphers.clear();
		config.allowedKeyManagement.clear();
		config.allowedPairwiseCiphers.clear();
		config.allowedProtocols.clear();
		config.SSID = "\"" + SSID + "\"";
		// 删除已经保存的密码
		java.util.List<android.net.wifi.WifiConfiguration> existingConfigs = MyWifiManager.getConfiguredNetworks();
		for (android.net.wifi.WifiConfiguration existingConfig : existingConfigs) {
			if (existingConfig.SSID.equals("\"" + SSID + "\"")) {
				MyWifiManager.removeNetwork(existingConfig.networkId);
			}
		}
		// WIFI加密类型
		if (Type == 1) // WIFICIPHER_NOPASS
		{
			config.wepKeys[0] = "";
			config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.NONE);
			config.wepTxKeyIndex = 0;
		}
		if (Type == 2) // WIFICIPHER_WEP
		{
			config.hiddenSSID = true;
			config.wepKeys[0] = "\"" + Password + "\"";
			config.allowedAuthAlgorithms.set(android.net.wifi.WifiConfiguration.AuthAlgorithm.SHARED);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.CCMP);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.TKIP);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.WEP40);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.WEP104);
			config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.NONE);
			config.wepTxKeyIndex = 0;
		}
		if (Type == 3) // WIFICIPHER_WPA
		{
			config.preSharedKey = "\"" + Password + "\"";
			config.hiddenSSID = true;
			config.allowedAuthAlgorithms.set(android.net.wifi.WifiConfiguration.AuthAlgorithm.OPEN);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.TKIP);
			config.allowedKeyManagement.set(android.net.wifi.WifiConfiguration.KeyMgmt.WPA_PSK);
			config.allowedPairwiseCiphers.set(android.net.wifi.WifiConfiguration.PairwiseCipher.TKIP);
			// config.allowedProtocols.set(android.net.wifi.WifiConfiguration.Protocol.WPA);
			config.allowedGroupCiphers.set(android.net.wifi.WifiConfiguration.GroupCipher.CCMP);
			config.allowedPairwiseCiphers.set(android.net.wifi.WifiConfiguration.PairwiseCipher.CCMP);
			config.status = android.net.wifi.WifiConfiguration.Status.ENABLED;
		}
		MyWifiManager.addNetwork(config);
		existingConfigs = MyWifiManager.getConfiguredNetworks();
		MyWifiManager.enableNetwork(existingConfigs.get(existingConfigs.size() - 1).networkId, disableOthers);
	}
}
