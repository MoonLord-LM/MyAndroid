package com.MyAndroid;

// 各种加密解密函数
// （纯静态函数库）
public class Security {
	/**
	 * Security的基本参数配置<br/>
	 */
	public static class Setting {
		private static java.lang.String Charset = "UTF-8";// 字符编码：UTF-8
		/**
		 * 字符编码<br/>
		 * 用于编码和解析字符串，默认为"UTF-8"<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value为null值，则不做任何操作
		 */
		public static void SetCharset(java.lang.String Value) {
			if (Value != null) {
				Charset = Value;
			}
		}
	}
	/**
	 * Base64编码<br/>
	 * 编码失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String Base64_Encode(java.lang.String Source) {
		try {
		 	return new java.lang.String(android.util.Base64.encode(Source.getBytes(Setting.Charset),android.util.Base64.DEFAULT),Setting.Charset);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Base64解码<br/>
	 * 解码失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String Base64_Decode(java.lang.String Source) {
		try {
		 	return new java.lang.String(android.util.Base64.decode(Source.getBytes(Setting.Charset),android.util.Base64.DEFAULT),Setting.Charset);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * URL安全的Base64编码（URL安全编码，-_ 替换了+/）<br/>
	 * 编码失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String Base64_URL_Encode(java.lang.String Source) {
		try {
		 	return new java.lang.String(android.util.Base64.encode(Source.getBytes(Setting.Charset),android.util.Base64.URL_SAFE),Setting.Charset);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * URL安全的Base64解码（URL安全编码，-_ 替换了+/）<br/>
	 * 解码失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String Base64_URL_Decode(java.lang.String Source) {
		try {
		 	return new java.lang.String(android.util.Base64.decode(Source.getBytes(Setting.Charset),android.util.Base64.URL_SAFE),Setting.Charset);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * MD5摘要算法<br/>
	 * 返回32位小写字母+数字<br/>
	 * 失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String MD5(java.lang.String Source) {
		try {
			byte[] m = java.security.MessageDigest.getInstance("MD5").digest(Source.getBytes(Setting.Charset));
			StringBuffer Buffer = new StringBuffer();       
		      for (int i = 0; i < m.length; i++) {                   
		          if (Integer.toHexString(0xFF & m[i]).length() == 1)       
		              Buffer.append("0").append(Integer.toHexString(0xFF & m[i]));       
		          else       
		              Buffer.append(Integer.toHexString(0xFF & m[i]));       
		      }
		      return Buffer.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * SHA1摘要算法<br/>
	 * 返回40位小写字母+数字<br/>
	 * 失败则返回null值<br/>
	 * 忽略所有异常<br/>
	 */
	public static java.lang.String SHA1(java.lang.String Source) {
		try {
			byte[] m = java.security.MessageDigest.getInstance("SHA-1").digest(Source.getBytes(Setting.Charset)) ;
			StringBuffer Buffer = new StringBuffer();       
		      for (int i = 0; i < m.length; i++) {                   
		          if (Integer.toHexString(0xFF & m[i]).length() == 1)       
		              Buffer.append("0").append(Integer.toHexString(0xFF & m[i]));       
		          else       
		              Buffer.append(Integer.toHexString(0xFF & m[i]));       
		      }
		      return Buffer.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//代码示例：
	/*
	AlertDialog.Show("1", Time.NowString());
	AlertDialog.Show("2", Security.Base64_Encode(Time.NowString()));
	AlertDialog.Show("3", Security.Base64_Decode(Security.Base64_Encode(Time.NowString())));
	AlertDialog.Show("4", Security.Base64_URL_Encode(Time.NowString()));
	AlertDialog.Show("5", Security.Base64_URL_Decode(Security.Base64_URL_Encode(Time.NowString())));
	AlertDialog.Show("6", Security.MD5(Time.NowString()));
	AlertDialog.Show("7", Security.SHA1(Time.NowString()));
	*/
}
