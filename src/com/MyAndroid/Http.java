package com.MyAndroid;

/**
 * <b>Http 网络访问类</b><br/>
 * By：MoonLord 2015.8.24<br/>
 * <p>
 * 对java.net.HttpURLConnection的简单封装<br/>
 * 需要网络访问的权限android.permission.INTERNET<br/>
 * 注意Android不允许在UI线程执行网络访问操作<br/>
 * <uses-permission android:name="android.permission.INTERNET"></uses-permission>
 * </p>
 */
public class Http {
	/**
	 * java.net.HttpURLConnection的基本参数配置<br/>
	 */
	public static class Setting {
		private static java.lang.String Charset = "UTF-8";// 字符编码：UTF-8
		private static int ConnectTimeout = 30000;// 连接超时时间（毫秒）
		private static int ReadTimeout = 30000;// 读取超时时间（毫秒）
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
		/**
		 * 连接超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 如果设置为0，则不会出现超时异常<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value小于0，则不做任何操作
		 */
		public static void SetConnectTimeout(int Value) {
			if (Value >= 0) {
				ConnectTimeout = Value;
			}
		}
		/**
		 * 读取超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 如果设置为0，则不会出现超时异常<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value小于0，则不做任何操作
		 */
		public static void SetReadTimeout(int Value) {
			if (Value >= 0) {
				ReadTimeout = Value;
			}
		}
	}
	/**
	 * 获取字符串Source的URL编码结果<br/>
	 * Source为null，或者字符集不支持，则返回空字符串""<br/>
	 * 编码的字符集设置在Setting类里，默认"UTF-8"<br/>
	 * 
	 * @see Setting
	 */
	public static java.lang.String UrlEncode(java.lang.String Source) {
		if (Source != null) {
			try {
				return java.net.URLEncoder.encode(Source, Setting.Charset);
			}
			catch (java.io.UnsupportedEncodingException e) {// 字符集不支持
				e.printStackTrace();
			}
			catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
				e.printStackTrace();
			}
		}
		return "";
	}
	/**
	 * 获取字符串Source的URL解码结果<br/>
	 * Source为null，或者字符集不支持，则返回空字符串""<br/>
	 * 编码的字符集设置在Setting类里，默认"UTF-8"<br/>
	 * 
	 * @see Setting
	 */
	public static java.lang.String UrlDecode(java.lang.String Source) {
		if (Source != null) {
			try {
				return java.net.URLDecoder.decode(Source, Setting.Charset);
			}
			catch (java.io.UnsupportedEncodingException e) {// 字符集不支持
				e.printStackTrace();
			}
			catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
				e.printStackTrace();
			}
		}
		return "";
	}
	/**
	 * 将一个java.io.InputStream输入流读取为字节数组<br/>
	 * 流的长度为0时，返回空数组<br/>
	 * 如果发生异常，则会尝试关闭输入流，然后抛出异常<br/>
	 */
	private static byte[] ReadByteArrayFromInputStream(java.io.InputStream InputStream, int Length) throws java.io.IOException {
		java.io.ByteArrayOutputStream ByteStream = null;
		try {
			if (Length > -1 && Length < 102400) {// 响应头部返回了流的长度（且长度小于100KB）
				byte[] buffer = new byte[Length];
				ByteStream = new java.io.ByteArrayOutputStream(Length);
				InputStream.read(buffer, 0, buffer.length);
				ByteStream.write(buffer, 0, buffer.length);
			}
			else {// 流的长度未知（以4KB的缓冲区读取）
				byte[] buffer = new byte[4096];
				ByteStream = new java.io.ByteArrayOutputStream(4096);
				int size;
				while ((size = InputStream.read(buffer, 0, 4096)) > -1) {
					ByteStream.write(buffer, 0, size);
				}
			}
			return ByteStream.toByteArray();
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
			try {
				ByteStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	/**
	 * 将一个java.io.InputStream输入流读取为字符串<br/>
	 * 流的长度为0时，返回空字符串""<br/>
	 * 如果发生异常，则会尝试关闭输入流，然后抛出异常<br/>
	 */
	private static java.lang.String ReadStringFromInputStream(java.io.InputStream InputStream, int Length) throws java.io.IOException {
		java.lang.StringBuffer temp = new java.lang.StringBuffer("");
		java.io.InputStreamReader in = null;
		try {
			in = new java.io.InputStreamReader(InputStream, Setting.Charset);
			if (Length > -1 && Length < 102400) {// 响应头部返回了流的长度（且长度小于100KB）
				char[] buffer = new char[Length];
				in.read(buffer, 0, buffer.length);
				temp.append(buffer);
			}
			else {// 流的长度未知（以4KB的缓冲区读取）
				char[] buffer = new char[4096];
				int size;
				while ((size = in.read(buffer, 0, 4096)) > -1) {
					temp.append(buffer, 0, size);
				}
			}
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				in.close();
			}
			catch (java.lang.Exception e) {}
		}
		return temp.toString();
	}
	/**
	 * 将一个java.io.InputStream输入流读取为字节数组，并保存成文件<br/>
	 * 流的长度为0时，返回空数组<br/>
	 * 如果发生异常，则会尝试关闭输入流和文件流，然后抛出异常<br/>
	 */
	private static byte[] SaveByteArrayFromInputStream(java.io.InputStream InputStream, int Length, java.lang.String FilePath) throws java.io.IOException {
		java.io.FileOutputStream fos = null;
		java.io.ByteArrayOutputStream ByteStream = null;
		try {
			fos = new java.io.FileOutputStream(new java.io.File(FilePath));
			if (Length > -1 && Length < 102400) {// 响应头部返回了流的长度（且长度小于100KB）
				byte[] buffer = new byte[Length];
				ByteStream = new java.io.ByteArrayOutputStream(Length);
				InputStream.read(buffer, 0, buffer.length);
				fos.write(buffer, 0, buffer.length);
				ByteStream.write(buffer, 0, buffer.length);
			}
			else {// 流的长度未知（以4KB的缓冲区读取）
				byte[] buffer = new byte[4096];
				ByteStream = new java.io.ByteArrayOutputStream(4096);
				int size;
				while ((size = InputStream.read(buffer, 0, 4096)) > -1) {
					fos.write(buffer, 0, size);// 写入文件
					ByteStream.write(buffer, 0, size);
				}
			}
			fos.flush();
			return ByteStream.toByteArray();
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
			try {
				fos.close();
			}
			catch (java.lang.Exception e) {}
			try {
				ByteStream.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	/**
	 * 将一个java.io.InputStream输入流保存成文件<br/>
	 * 返回是否保存成功<br/>
	 * 如果发生异常，则会尝试关闭输入流和文件流，然后抛出异常<br/>
	 */
	private static boolean SaveFileFromInputStream(java.io.InputStream InputStream, int Length, java.lang.String FilePath) throws java.io.IOException {
		java.io.FileOutputStream fos = null;
		try {
			fos = new java.io.FileOutputStream(new java.io.File(FilePath));
			if (Length > -1 && Length < 102400) {// 响应头部返回了流的长度（且长度小于100KB）
				byte[] buffer = new byte[Length];
				InputStream.read(buffer, 0, buffer.length);
				fos.write(buffer, 0, buffer.length);
			}
			else {// 流的长度未知（以4KB的缓冲区读取）
				byte[] buffer = new byte[4096];
				int size;
				while ((size = InputStream.read(buffer, 0, 4096)) > -1) {
					fos.write(buffer, 0, size);// 写入文件
				}
			}
			fos.flush();
			return true;
		}
		catch (java.io.IOException e) {
			throw e;
		}
		finally {
			try {
				InputStream.close();
			}
			catch (java.lang.Exception e) {}
			try {
				fos.close();
			}
			catch (java.lang.Exception e) {}
		}
	}
	/**
	 * 发起GET请求，并返回响应主体的字节数组<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static byte[] GetByteArray(java.lang.String URL) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			return ReadByteArrayFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起GET请求，并返回响应主体的字符串<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static java.lang.String Get(java.lang.String URL) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			return ReadStringFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起POST请求，并返回响应主体的字节数组<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL和Parameter不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static byte[] PostByteArray(java.lang.String URL, java.lang.String Parameter) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlConn.setChunkedStreamingMode(0);
			urlConn.getOutputStream().write(Parameter.getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return ReadByteArrayFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起POST请求，并返回响应主体的字符串<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL和Parameter不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static java.lang.String Post(java.lang.String URL, java.lang.String Parameter) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlConn.setChunkedStreamingMode(0);
			urlConn.getOutputStream().write(Parameter.getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return ReadStringFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起GET请求，并将响应主体保存到FilePath<br/>
	 * 返回响应主体的字节数组，表明下载成功<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static byte[] DownLoadByteArray(java.lang.String URL, java.lang.String FilePath) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			return SaveByteArrayFromInputStream(urlConn.getInputStream(), urlConn.getContentLength(), FilePath);
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起GET请求，并将响应主体保存到FilePath<br/>
	 * 返回是否下载成功<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static boolean DownLoad(java.lang.String URL, java.lang.String FilePath) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			return SaveFileFromInputStream(urlConn.getInputStream(), urlConn.getContentLength(), FilePath);
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return false;
	}
	/**
	 * 发起POST请求，并将响应主体保存到FilePath<br/>
	 * 返回响应主体的字节数组，表明下载成功<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL和Parameter不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static byte[] DownLoadByteArray(java.lang.String URL, java.lang.String Parameter, java.lang.String FilePath) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlConn.setChunkedStreamingMode(0);
			urlConn.getOutputStream().write(Parameter.getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return SaveByteArrayFromInputStream(urlConn.getInputStream(), urlConn.getContentLength(), FilePath);
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起POST请求，并将响应主体保存到FilePath<br/>
	 * 返回是否下载成功<br/>
	 * 调用UrlEncode进行URL编码，确保URL和Parameter不包含中文或特殊符号<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static boolean DownLoad(java.lang.String URL, java.lang.String Parameter, java.lang.String FilePath) {
		java.net.HttpURLConnection urlConn = null;
		try {
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlConn.setChunkedStreamingMode(0);
			urlConn.getOutputStream().write(Parameter.getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return SaveFileFromInputStream(urlConn.getInputStream(), urlConn.getContentLength(), FilePath);
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
		}
		return false;
	}
	/**
	 * 发起POST请求，上传FilePath处的文件，并返回响应主体的字符串<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 注意ParameterName是指文件参数的名称，而不是文件名，可以包含中文，通常设置为"file"<br/>
	 * 注意ParameterName可以包含双引号"之外的/\\*<>|?:等特殊符号，不可以包含双引号！<br/>
	 * 注意ParameterName中的[]是具有特殊含义且只能用在字符串末尾的，表示上传的多个文件都对应一个参数名称<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static java.lang.String UpLoad(java.lang.String URL, java.lang.String ParameterName, java.lang.String FilePath) {
		java.net.HttpURLConnection urlConn = null;
		java.io.InputStream FileInputStream = null;
		try {
			java.lang.String Boundary = java.util.UUID.randomUUID().toString();// 和时间、机器网卡等相关的一个唯一字符串（36字节）
			java.lang.String FileName = new java.io.File(FilePath).getName();// 文件名
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setChunkedStreamingMode(0);
			urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + Boundary);
			urlConn.getOutputStream().write(("--" + Boundary + "\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().write(("Content-Disposition: form-data; name=\"" + ParameterName + "\"; filename=\"" + FileName + "\"" + "\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().write(("Content-Type: application/octet-stream" + "\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().write(("\r\n").getBytes(Setting.Charset));
			FileInputStream = new java.io.FileInputStream(FilePath);
			byte[] buffer = new byte[4096];
			int size = 0;
			while ((size = FileInputStream.read(buffer, 0, 4096)) > -1) {
				urlConn.getOutputStream().write(buffer, 0, size);
			}
			FileInputStream.close();
			urlConn.getOutputStream().write(("\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().write(("--" + Boundary + "--" + "\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return ReadStringFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
			try {
				FileInputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
	/**
	 * 发起POST请求，上传FilePath处的所有文件，并返回响应主体的字符串<br/>
	 * 请求发生异常则返回null值<br/>
	 * 调用UrlEncode进行URL编码，确保URL不包含中文或特殊符号<br/>
	 * 注意ParameterName是指文件参数的名称，而不是文件名，可以包含中文，通常设置为"file[]"<br/>
	 * 注意ParameterName可以包含双引号"之外的/\\*<>|?:等特殊符号，不可以包含双引号！<br/>
	 * 注意ParameterName中的[]是具有特殊含义且只能用在字符串末尾的，表示上传的多个文件都对应一个参数名称<br/>
	 * 忽略所有异常<br/>
	 * 
	 * @see #UrlEncode
	 */
	public static java.lang.String UpLoad(java.lang.String URL, java.lang.String ParameterName, java.lang.String[] FilePath) {
		java.net.HttpURLConnection urlConn = null;
		java.io.InputStream FileInputStream = null;
		try {
			java.lang.String Boundary = java.util.UUID.randomUUID().toString();// 和时间、机器网卡等相关的一个唯一字符串（36字节）
			urlConn = (java.net.HttpURLConnection) new java.net.URL(URL).openConnection();
			urlConn.setConnectTimeout(Setting.ConnectTimeout);
			urlConn.setReadTimeout(Setting.ReadTimeout);
			urlConn.setRequestMethod("POST");
			urlConn.setChunkedStreamingMode(0);
			urlConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + Boundary);
			for (int i = 0; i < FilePath.length; i++) {
				java.lang.String FileName = new java.io.File(FilePath[i]).getName();// 文件名
				urlConn.getOutputStream().write(("--" + Boundary + "\r\n").getBytes(Setting.Charset));
				urlConn.getOutputStream().write(("Content-Disposition: form-data; name=\"" + ParameterName + "\"; filename=\"" + FileName + "\"" + "\r\n").getBytes(Setting.Charset));
				urlConn.getOutputStream().write(("Content-Type: application/octet-stream" + "\r\n").getBytes(Setting.Charset));
				urlConn.getOutputStream().write(("\r\n").getBytes(Setting.Charset));
				FileInputStream = new java.io.FileInputStream(FilePath[i]);
				byte[] buffer = new byte[4096];
				int size = 0;
				while ((size = FileInputStream.read(buffer, 0, 4096)) > -1) {
					urlConn.getOutputStream().write(buffer, 0, size);
				}
				FileInputStream.close();
				urlConn.getOutputStream().write(("\r\n").getBytes(Setting.Charset));
			}
			urlConn.getOutputStream().write(("--" + Boundary + "--" + "\r\n").getBytes(Setting.Charset));
			urlConn.getOutputStream().flush();
			urlConn.getOutputStream().close();
			return ReadStringFromInputStream(urlConn.getInputStream(), urlConn.getContentLength());
		}
		catch (java.lang.Exception e) {
			// android.os.NetworkOnMainThreadException UI线程不支持网络操作
			// java.net.MalformedURLException URL格式错误
			// java.io.UnsupportedEncodingException 字符集不支持
			// java.nio.charset.UnsupportedCharsetException 无效的字符编码
			// java.net.UnknownHostException 域名解析失败（未连接网络）
			// java.net.SocketException 系统连接池的异常（连接超时等）
			// java.io.IOException IO的其他异常
			e.printStackTrace();
		}
		finally {
			try {
				urlConn.disconnect();
			}
			catch (java.lang.Exception e) {}
			try {
				FileInputStream.close();
			}
			catch (java.lang.Exception e) {}
		}
		return null;
	}
}
