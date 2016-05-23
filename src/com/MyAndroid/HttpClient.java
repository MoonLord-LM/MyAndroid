package com.MyAndroid;

/**
 * <b>HttpClient 网络访问类</b><br/>
 * By：MoonLord 2015.8.24<br/>
 * <p>
 * 基于org.apache.http.client.HttpClient的单个实例执行请求<br/>
 * 需要网络访问的权限android.permission.INTERNET<br/>
 * 注意Android不允许在UI线程执行网络访问操作<br/>
 * <uses-permission android:name="android.permission.INTERNET"></uses-permission>
 * </p>
 */
public class HttpClient {
	/**
	 * org.apache.http.client.HttpClient的基本参数配置<br/>
	 * <b>注意：</b><br/>
	 * 使用Set类函数修改参数后，HttpClient的原实例会被重置为null值<br/>
	 */
	public static class Setting {
		private static java.lang.String Charset = "UTF-8";// 字符编码：UTF-8
		private static int ConnectTimeout = 30000;// 连接超时时间（毫秒）
		private static int ReadTimeout = 30000;// 读取超时时间（毫秒）
		private static int MaxTotalConnections = 20;// 连接池的连接总数限制
		private static int MaxConnectionsPerRoute = 5; // 连接池里对于单个IP的连接数限制
		private static long WaitTimeout = 30000; // 从连接池中取连接的等待超时时间（毫秒）
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
				MyClient = null;
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
				MyClient = null;
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
				MyClient = null;
			}
		}
		/**
		 * 连接池的连接总数限制<br/>
		 * 默认20，表示最多有20个请求在同时执行<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value小于或等于0，则不做任何操作
		 */
		public static void SetMaxTotalConnections(int Value) {
			if (Value > 0) {
				MaxTotalConnections = Value;
				MyClient = null;
			}
		}
		/**
		 * 连接池里对于单个IP的连接数限制<br/>
		 * 默认5，表示最多对同一个服务器可以有5个请求在同时执行<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value小于或等于0，则不做任何操作
		 */
		public static void SetMaxConnectionsPerRoute(int Value) {
			if (Value > 0) {
				MaxConnectionsPerRoute = Value;
				MyClient = null;
			}
		}
		/**
		 * 从连接池中取连接的等待超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 
		 * @param Value
		 *            要设置的值，若Value小于或等于0，则不做任何操作
		 */
		public static void SetWaitTimeout(long Value) {
			if (Value > 0) {
				WaitTimeout = Value;
				MyClient = null;
			}
		}
		/**
		 * 字符编码<br/>
		 * 用于编码和解析字符串，默认为"UTF-8"<br/>
		 * 
		 * @return 字符编码
		 */
		public static java.lang.String GetCharset() {
			return Charset;
		}
		/**
		 * 连接超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 
		 * @return 连接超时时间
		 */
		public static int GetConnectTimeout() {
			return ConnectTimeout;
		}
		/**
		 * 读取超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 
		 * @return 读取超时时间
		 */
		public static int GetReadTimeout() {
			return ReadTimeout;
		}
		/**
		 * 连接池的连接总数限制<br/>
		 * 默认20，表示最多有20个请求在同时执行<br/>
		 * 
		 * @return 连接池的连接总数限制
		 */
		public static int GetMaxTotalConnections() {
			return MaxTotalConnections;
		}
		/**
		 * 连接池里对于单个IP的连接数限制<br/>
		 * 默认5，表示最多对同一个服务器可以有5个请求在同时执行<br/>
		 * 
		 * @return 连接池里对于单个IP的连接数限制
		 */
		public static int GetMaxConnectionsPerRoute() {
			return MaxConnectionsPerRoute;
		}
		/**
		 * 从连接池中取连接的等待超时时间<br/>
		 * 单位毫秒，默认30000毫秒（30秒）<br/>
		 * 
		 * @return 从连接池中取连接的等待超时时间
		 */
		public static long GetWaitTimeout() {
			return WaitTimeout;
		}
	}
	/**
	 * 用于保存HttpClient的静态私有实例
	 */
	private static org.apache.http.client.HttpClient MyClient;
	/**
	 * 获取HttpClient静态实例<br/>
	 * <b>注意：</b><br/>
	 * 当Setting里的设置被改变，或者连接池被清空后，本方法会返回HttpClient的新实例<br/>
	 * synchronized保证类的该静态方法同时只能有1个线程在执行<br/>
	 * 
	 * @see Setting
	 * @return HttpClient的当前可用实例
	 */
	private static synchronized org.apache.http.client.HttpClient Instance() {
		if (MyClient == null) {
			org.apache.http.params.BasicHttpParams httpParams = new org.apache.http.params.BasicHttpParams();
			org.apache.http.params.HttpConnectionParams.setConnectionTimeout(httpParams, Setting.ConnectTimeout);
			org.apache.http.params.HttpConnectionParams.setSoTimeout(httpParams, Setting.ReadTimeout);
			org.apache.http.params.HttpProtocolParams.setContentCharset(httpParams, Setting.Charset);
			org.apache.http.conn.params.ConnManagerParams.setMaxTotalConnections(httpParams, Setting.MaxTotalConnections);
			org.apache.http.conn.params.ConnManagerParams.setMaxConnectionsPerRoute(httpParams, new org.apache.http.conn.params.ConnPerRouteBean(Setting.MaxConnectionsPerRoute));
			org.apache.http.conn.params.ConnManagerParams.setTimeout(httpParams, Setting.WaitTimeout);
			org.apache.http.conn.scheme.SchemeRegistry schemeRegistry = new org.apache.http.conn.scheme.SchemeRegistry();
			schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("http", org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
			schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
			org.apache.http.conn.ClientConnectionManager cm = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(httpParams, schemeRegistry);
			MyClient = new org.apache.http.impl.client.DefaultHttpClient(cm, httpParams);
		}
		return MyClient;
	}
	/**
	 * 清空连接池<br/>
	 * <b>注意：</b><br/>
	 * 清空连接池后，保存的HttpClient的实例会被设置为null值<br/>
	 * 调用时可能导致HttpClient的原实例在其它线程的正在处理的请求发生异常<br/>
	 */
	public static synchronized void CloseAllConnections() {
		if (MyClient != null && MyClient.getConnectionManager() != null) {
			MyClient.getConnectionManager().shutdown();
			MyClient.getConnectionManager().getSchemeRegistry().unregister("http");
			MyClient.getConnectionManager().getSchemeRegistry().unregister("https");
			MyClient = null;
		}
	}
	/**
	 * HTTP请求基类（包含公共函数）<br/>
	 */
	public static abstract class HttpRequest {
		private org.apache.http.HttpResponse httpResponse;
		private java.lang.String ResponseBody;// 响应主体字符串
		/**
		 * 下载文件<br/>
		 * 将httpResponse读取为文件，保存到FilePath的位置<br/>
		 * 返回空字符串""，表示下载成功，返回null值，表示下载失败<br/>
		 * 下载完文件之后，才会将连接返回给连接池，可自动识别gzip编码<br/>
		 * 忽略所有异常<br/>
		 */
		protected static java.lang.String DownLoadFile(org.apache.http.HttpResponse httpResponse, java.lang.String FilePath) {
			java.io.InputStream in = null;
			java.io.FileOutputStream fos = null;
			if (httpResponse != null && httpResponse.getEntity() != null) {
				try {
					if (httpResponse.getEntity().getContentEncoding() != null && httpResponse.getEntity().getContentEncoding().getValue().contains("gzip")) {
						in = new java.util.zip.GZIPInputStream(httpResponse.getEntity().getContent());
					}
					else {
						in = httpResponse.getEntity().getContent();
					}
					fos = new java.io.FileOutputStream(new java.io.File(FilePath));
					byte[] buffer = new byte[4096];
					int size;
					while ((size = in.read(buffer, 0, 4096)) > -1) {
						fos.write(buffer, 0, size);
					}
					fos.flush();
					return "";
				}
				catch (android.os.NetworkOnMainThreadException e) { // UI线程不支持网络操作
					e.printStackTrace();
				}
				catch (org.apache.http.MalformedChunkCodingException e) { // HttpClient的连接池被关闭
					e.printStackTrace();
				}
				catch (java.io.IOException e) {// IO的其他异常
					e.printStackTrace();
				}
				catch (java.lang.Exception e) { // 其它未知异常
					e.printStackTrace();
				}
				finally {// 保证将连接返回给连接池
					try {
						in.close();
					}
					catch (java.lang.Exception e) {}
					try {
						fos.close();
					}
					catch (java.lang.Exception e) {}
				}
			}
			return null;
		}
		/**
		 * 获取响应主体字符串<br/>
		 * 将httpResponse读取为字符串并返回，如果读取失败则返回null值<br/>
		 * 读取完响应主体之后，才会将连接返回给连接池，可自动识别gzip编码<br/>
		 * 忽略所有异常<br/>
		 */
		protected static java.lang.String GetResponseBodyString(org.apache.http.HttpResponse httpResponse) {
			if (httpResponse != null && httpResponse.getEntity() != null) {
				try {
					if (httpResponse.getEntity().getContentEncoding() != null && httpResponse.getEntity().getContentEncoding().getValue().contains("gzip")) {
						StringBuffer temp = new StringBuffer();
						java.io.InputStreamReader in = new java.io.InputStreamReader(new java.util.zip.GZIPInputStream(httpResponse.getEntity().getContent()), Setting.Charset);
						char[] buffer = new char[4096];
						int size;
						while ((size = in.read(buffer, 0, 4096)) > -1) {
							temp.append(buffer, 0, size);
						}
						return temp.toString();
					}
					else {
						return org.apache.http.util.EntityUtils.toString(httpResponse.getEntity(), Setting.Charset);
					}
				}
				catch (android.os.NetworkOnMainThreadException e) { // UI线程不支持网络操作
					e.printStackTrace();
				}
				catch (org.apache.http.ParseException e) { // 解析异常
					e.printStackTrace();
				}
				catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
					e.printStackTrace();
				}
				catch (org.apache.http.MalformedChunkCodingException e) { // HttpClient的连接池被关闭
					e.printStackTrace();
				}
				catch (java.io.IOException e) {// IO的其他异常
					e.printStackTrace();
				}
				catch (java.lang.Exception e) { // 其它未知异常
					e.printStackTrace();
				}
				finally {// 保证将连接返回给连接池
					try {
						httpResponse.getEntity().getContent().close();
					}
					catch (java.lang.Exception e) {}
				}
			}
			return null;
		}
		/**
		 * 获取响应状态<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 通常返回"200 OK"，获取失败返回null值<br/>
		 */
		public java.lang.String GetResponseStatusLine() {
			if (httpResponse != null && httpResponse.getStatusLine() != null) {
				return httpResponse.getStatusLine().getStatusCode() + " " + httpResponse.getStatusLine().getReasonPhrase();
			}
			return null;
		}
		/**
		 * 获取响应码<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 通常返回200，获取失败返回-1<br/>
		 */
		public int GetResponseStatusCode() {
			if (httpResponse != null && httpResponse.getStatusLine() != null) {
				return httpResponse.getStatusLine().getStatusCode();
			}
			return -1;
		}
		/**
		 * 获取响应Header的值<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 返回根据Name查找到的第一个匹配的Header的值，获取失败返回null值<br/>
		 */
		public java.lang.String GetResponseHeader(java.lang.String Name) {
			if (httpResponse != null && httpResponse.getHeaders(Name).length > 0) {
				return httpResponse.getHeaders(Name)[0].getValue();
			}
			return null;
		}
		/**
		 * 获取响应Header的Content-Type<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 等效于GetResponseHeader("Content-Type")<br/>
		 * 通常返回"text/html;charset=utf-8"，获取失败返回null值<br/>
		 * 
		 * @see GetResponseHeader
		 */
		public java.lang.String GetResponseContentType() {
			if (httpResponse != null && httpResponse.getEntity() != null && httpResponse.getEntity().getContentType() != null) {
				return httpResponse.getEntity().getContentType().getValue();
			}
			return null;
		}
		/**
		 * 获取响应Header的Content-Encoding<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 等效于GetResponseHeader("Content-Encoding")<br/>
		 * 通常返回"gzip"，获取失败返回null值<br/>
		 * 
		 * @see GetResponseHeader
		 */
		public java.lang.String GetResponseContentEncoding() {
			if (httpResponse != null && httpResponse.getEntity() != null && httpResponse.getEntity().getContentEncoding() != null) {
				return httpResponse.getEntity().getContentEncoding().getValue();
			}
			return null;
		}
		/**
		 * 获取响应Header的Content-Length<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 类似于GetResponseHeader("Content-Length")<br/>
		 * 获取失败返回-1<br/>
		 * 
		 * @see GetResponseHeader
		 */
		public long GetResponseContentLength() {
			if (httpResponse != null && httpResponse.getEntity() != null) {
				return httpResponse.getEntity().getContentLength();
			}
			return -1;
		}
		/**
		 * 获取响应设置的Cookie字符串<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 通常返回的格式类似于"abc=123;def=456;"，获取失败返回null值<br/>
		 */
		public java.lang.String GetResponseCookie() {
			if (httpResponse != null && httpResponse.getHeaders("Set-Cookie").length > 0) {
				StringBuffer temp = new StringBuffer();
				org.apache.http.Header[] Cookies = httpResponse.getHeaders("Set-Cookie");
				for (int i = 0; i < Cookies.length; i++) {
					temp.append(Cookies[i].getValue().substring(0, Cookies[i].getValue().indexOf(";") + 1));
				}
				return temp.toString();
			}
			return null;
		}
		/**
		 * 获取响应主体的字符串<br/>
		 * 要在执行请求后才会获取成功<br/>
		 * 如果请求尚未执行，或者执行请求过程中发生了异常，则返回null值<br/>
		 * 如果设置了文件保存路径，HTTP请求是一个文件下载请求，则返回空字符串""，表示下载成功，返回null值，表示下载失败<br/>
		 * 如果设置了忽略响应主体，HTTP请求是一个只读取Header就终止的请求，则返回空字符串""，表示请求成功，返回null值，表示请求失败<br/>
		 */
		public java.lang.String GetResponseBody() {
			return ResponseBody;
		}
	}
	/**
	 * GET请求类<br/>
	 */
	public static class HttpGetRequest extends HttpRequest {
		private org.apache.http.client.methods.HttpPost httpRequest;
		private java.lang.String DownloadPath;// 保存文件的路径
		private boolean IgnoreResponseBody;// 是否忽略响应主体
		/**
		 * 构造GET请求<br/>
		 * URL可以含有中文或URL编码的字符串，会自动识别并进行URL转码<br/>
		 * 例如，URL可以为：http://www.abc.com/index.php?参数=值&name=value#page1<br/>
		 * 上面的URL等效于：http://www.abc.com/index.php?%E5%8F%82%E6%95%B0=%E5%80%BC&name=value#page1<br/>
		 * 可以使用IsValidRequest函数，判断请求是否正常构造<br/>
		 * 
		 * @see #IsValidRequest
		 */
		public HttpGetRequest(java.lang.String URL) {
			try {
				httpRequest = new org.apache.http.client.methods.HttpPost(URL);
			}
			catch (java.lang.IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 判断GET请求是否有效<br/>
		 * 无效的GET请求通常是由于构造函数传入的URL格式不符导致的<br/>
		 */
		public boolean IsValidRequest() {
			return httpRequest != null;
		}
		/**
		 * 设置请求头Header的键值对<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * 
		 * @see #AddHeader
		 */
		public HttpGetRequest SetHeader(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				httpRequest.setHeader(Name, Value);
			}
			return this;
		}
		/**
		 * 设置请求的Cookie值<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * CookieString的null值等效于空字符串""<br/>
		 * CookieString的格式应该类似于"abc=123;def=456;"<br/>
		 */
		public HttpGetRequest SetCookie(java.lang.String CookieString) {
			if (httpRequest != null) {
				httpRequest.setHeader("Cookie", CookieString);
			}
			return this;
		}
		/**
		 * 设置请求的Referer值<br/>
		 * 等效于SetHeader("Referer", RefererURL)<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * RefererURL的null值等效于空字符串""<br/>
		 * RefererURL应该是符合URL格式，且参数经过URL编码的字符串，否则会导致请求发生异常<br/>
		 * 例如：<br/>
		 * http://www.abc.com/index.php?%E5%8F%82%E6%95%B0=%E5%80%BC&name=value#page1<br/>
		 * 
		 * @see #SetHeader
		 */
		public HttpGetRequest SetReferer(java.lang.String RefererURL) {
			if (httpRequest != null) {
				httpRequest.setHeader("Referer", RefererURL);
			}
			return this;
		}
		/**
		 * 设置请求的Accept-Encoding值<br/>
		 * 等效于SetHeader("Accept-Encoding", AcceptEncodingString)<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * AcceptEncodingString的null值等效于空字符串""<br/>
		 * AcceptEncodingString的常见值有"gzip"、"gzip, deflate, sdch"
		 * 
		 * @see #SetHeader
		 */
		public HttpGetRequest SetAcceptEncoding(java.lang.String AcceptEncodingString) {
			if (httpRequest != null) {
				httpRequest.setHeader("Accept-Encoding", AcceptEncodingString);
			}
			return this;
		}
		/**
		 * 添加请求头Header的键值对<br/>
		 * 添加到Header的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * 
		 * @see #SetHeader
		 */
		public HttpGetRequest AddHeader(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				httpRequest.addHeader(Name, Value);
			}
			return this;
		}
		/**
		 * 添加请求的Cookie参数<br/>
		 * 添加到Header的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * Name和Value可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * 忽略URL编码异常<br/>
		 * 
		 * @see #SetCookie
		 */
		public HttpGetRequest AddCookie(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				StringBuffer temp = new StringBuffer();
				if (httpRequest.getHeaders("Cookie").length > 0) {
					temp.append(httpRequest.getHeaders("Cookie")[0].getValue());
				}
				try {
					temp.append(java.net.URLEncoder.encode(Name, Setting.Charset));
					temp.append("=");
					temp.append(java.net.URLEncoder.encode(Value, Setting.Charset));
				}
				catch (java.io.UnsupportedEncodingException e) { // 编码不支持
					e.printStackTrace();
				}
				catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
					e.printStackTrace();
				}
				temp.append(";");
				httpRequest.setHeader("Cookie", temp.toString());
			}
			return this;
		}
		/**
		 * 添加请求的GET参数<br/>
		 * 添加到URL的参数部分的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * Name和Value可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * 忽略URL编码异常<br/>
		 */
		public HttpGetRequest AddGetParameter(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				StringBuffer URL = new StringBuffer();
				try {
					Name = java.net.URLEncoder.encode(Name, Setting.Charset);
					Value = java.net.URLEncoder.encode(Value, Setting.Charset);
				}
				catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if (httpRequest.getURI().getScheme() != null) {
					URL.append(httpRequest.getURI().getScheme());
					URL.append(':');
				}
				if (httpRequest.getURI().isOpaque()) {
					URL.append(httpRequest.getURI().getRawSchemeSpecificPart());
				}
				else {
					if (httpRequest.getURI().getRawAuthority() != null) {
						URL.append("//");
						URL.append(httpRequest.getURI().getRawAuthority());
					}
					if (httpRequest.getURI().getRawPath() != null) {
						URL.append(httpRequest.getURI().getRawPath());
					}
					if (httpRequest.getURI().getRawQuery() != null) {
						URL.append('?');
						URL.append(httpRequest.getURI().getRawQuery());
						URL.append('&');
						URL.append(Name);
						URL.append('=');
						URL.append(Value);
					}
					else {
						URL.append('?');
						URL.append(Name);
						URL.append('=');
						URL.append(Value);
					}
				}
				if (httpRequest.getURI().getRawFragment() != null) {
					URL.append('#');
					URL.append(httpRequest.getURI().getRawFragment());
				}
				try {
					httpRequest.setURI(new java.net.URI(URL.toString()));
				}
				catch (java.net.URISyntaxException e) {
					e.printStackTrace();
				}
			}
			return this;
		}
		/**
		 * 设置文件保存路径<br/>
		 * FilePath为文件保存位置的绝对路径<br/>
		 * FilePath为null值，则表示不下载文件<br/>
		 * 
		 * @see #IsDownloadRequest
		 */
		public HttpGetRequest SetDownloadPath(java.lang.String FilePath) {
			DownloadPath = FilePath;
			return this;
		}
		/**
		 * 判断GET请求是否是一个文件下载请求<br/>
		 * 默认是获取响应主体的字符串的请求，通过调用SetDownloadPath可设定为文件下载的请求<br/>
		 * 
		 * @see #SetDownloadPath
		 */
		public boolean IsDownloadRequest() {
			return DownloadPath != null;
		}
		/**
		 * 设置是否忽略响应主体（只读取Header就终止请求）
		 * 
		 * @see #IsIgnoreBodyRequest
		 */
		public HttpGetRequest SetIgnoreResponseBody(boolean IgnoreBody) {
			IgnoreResponseBody = IgnoreBody;
			return this;
		}
		/**
		 * 判断GET请求是否是一个忽略响应主体（只读取Header就终止）的请求<br/>
		 * 默认是获取响应主体的字符串的请求，通过调用SetIgnoreResponseBody可设定为忽略响应主体的请求<br/>
		 * 
		 * @see #SetIgnoreResponseBody
		 */
		public boolean IsIgnoreBodyRequest() {
			return IgnoreResponseBody;
		}
		/**
		 * 执行请求，默认返回响应主体字符串<br/>
		 * 如果执行请求过程中发生了异常，则返回null值<br/>
		 * 如果调用SetDownloadPath设置了文件保存路径，GET请求是一个文件下载请求，则返回空字符串""，表示下载成功，返回null值，表示下载失败<br/>
		 * 如果调用SetIgnoreResponseBody设置了忽略响应主体，GET请求是一个只读取Header就终止的请求，则返回空字符串""，表示请求成功，返回null值，表示请求失败<br/>
		 * 多次调用本函数，会发送多次请求<br/>
		 * 函数内部完成了连接的请求和返还操作，不会造成连接池的资源泄露<br/>
		 * 忽略所有异常<br/>
		 * 
		 * @see #SetDownloadPath
		 * @see #SetIgnoreResponseBody
		 */
		public synchronized java.lang.String Execute() {
			try {
				if (httpRequest != null) {
					super.httpResponse = Instance().execute(httpRequest);
					if (IgnoreResponseBody == true) {
						super.ResponseBody = "";
					}
					else if (DownloadPath != null) {
						super.ResponseBody = DownLoadFile(super.httpResponse, DownloadPath);
					}
					else {
						super.ResponseBody = GetResponseBodyString(super.httpResponse);
					}
					return super.ResponseBody;
				}
			}
			catch (android.os.NetworkOnMainThreadException e) { // UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (org.apache.http.conn.ConnectionPoolTimeoutException e) { // 连接池等待超时
				e.printStackTrace();
			}
			catch (org.apache.http.client.ClientProtocolException e) { // HTTP协议错误
				e.printStackTrace();
			}
			catch (java.io.UnsupportedEncodingException e) {// 字符集不支持
				e.printStackTrace();
			}
			catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
				e.printStackTrace();
			}
			catch (java.net.UnknownHostException e) {// 域名解析失败（未连接网络）
				e.printStackTrace();
			}
			catch (java.lang.IllegalStateException e) {// HttpClient的连接池被关闭
				e.printStackTrace();
			}
			catch (java.io.IOException e) {// IO的其他异常
				e.printStackTrace();
			}
			catch (java.lang.Exception e) { // 其它未知异常
				e.printStackTrace();
			}
			finally {// 保证将连接返回给连接池
				if (super.httpResponse != null && super.httpResponse.getEntity() != null) {
					try {
						super.httpResponse.getEntity().getContent().close();
					}
					catch (java.lang.Exception e) {}
				}
			}
			super.ResponseBody = null;
			return super.ResponseBody;
		}
	}
	/**
	 * POST请求类<br/>
	 */
	public static class HttpPostRequest extends HttpRequest {
		private org.apache.http.client.methods.HttpPost httpRequest;
		private java.util.List<org.apache.http.NameValuePair> PostParameter = new java.util.ArrayList<org.apache.http.NameValuePair>();
		private java.util.List<org.apache.http.NameValuePair> UploadFile = new java.util.ArrayList<org.apache.http.NameValuePair>();
		private java.lang.String DownloadPath;// 保存文件的路径
		private boolean IgnoreResponseBody;// 是否忽略响应主体
		private java.lang.String PostParameterString;// 保存要发送的完整字符串
		/**
		 * 构造POST请求<br/>
		 * URL可以含有中文或URL编码的字符串，会自动识别并进行URL转码<br/>
		 * 例如，URL可以为：http://www.abc.com/index.php?参数=值&name=value#page1<br/>
		 * 上面的URL等效于：http://www.abc.com/index.php?%E5%8F%82%E6%95%B0=%E5%80%BC&name=value#page1<br/>
		 * 可以使用IsValidRequest函数，判断请求是否正常构造<br/>
		 * 
		 * @see #IsValidRequest
		 */
		public HttpPostRequest(java.lang.String URL) {
			try {
				httpRequest = new org.apache.http.client.methods.HttpPost(URL);
			}
			catch (java.lang.IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 判断POST请求是否有效<br/>
		 * 无效的POST请求通常是由于构造函数传入的URL格式不符导致的<br/>
		 */
		public boolean IsValidRequest() {
			return httpRequest != null;
		}
		/**
		 * 设置请求头Header的键值对<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * 
		 * @see #AddHeader
		 */
		public HttpPostRequest SetHeader(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				httpRequest.setHeader(Name, Value);
			}
			return this;
		}
		/**
		 * 设置请求的Cookie值<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * CookieString的null值等效于空字符串""<br/>
		 * CookieString的格式应该类似于"abc=123;def=456;"<br/>
		 */
		public HttpPostRequest SetCookie(java.lang.String CookieString) {
			if (httpRequest != null) {
				httpRequest.setHeader("Cookie", CookieString);
			}
			return this;
		}
		/**
		 * 设置请求的Referer值<br/>
		 * 等效于SetHeader("Referer", RefererURL)<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * RefererURL的null值等效于空字符串""<br/>
		 * RefererURL应该是符合URL格式，且参数经过URL编码的字符串，否则会导致请求发生异常<br/>
		 * 例如：<br/>
		 * http://www.abc.com/index.php?%E5%8F%82%E6%95%B0=%E5%80%BC&name=value#page1<br/>
		 * 
		 * @see #SetHeader
		 */
		public HttpPostRequest SetReferer(java.lang.String RefererURL) {
			if (httpRequest != null) {
				httpRequest.setHeader("Referer", RefererURL);
			}
			return this;
		}
		/**
		 * 设置请求的Accept-Encoding值<br/>
		 * 等效于SetHeader("Accept-Encoding", AcceptEncodingString)<br/>
		 * 已存在则修改，不存在则添加<br/>
		 * AcceptEncodingString的null值等效于空字符串""<br/>
		 * AcceptEncodingString的常见值有"gzip"、"gzip, deflate, sdch"
		 * 
		 * @see #SetHeader
		 */
		public HttpPostRequest SetAcceptEncoding(java.lang.String AcceptEncodingString) {
			if (httpRequest != null) {
				httpRequest.setHeader("Accept-Encoding", AcceptEncodingString);
			}
			return this;
		}
		/**
		 * 添加请求头Header的键值对<br/>
		 * 添加到Header的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * 
		 * @see #SetHeader
		 */
		public HttpPostRequest AddHeader(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				httpRequest.addHeader(Name, Value);
			}
			return this;
		}
		/**
		 * 添加请求的Cookie参数<br/>
		 * 添加到Header的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * Name和Value可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * 忽略URL编码异常<br/>
		 * 
		 * @see #SetCookie
		 */
		public HttpPostRequest AddCookie(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				StringBuffer temp = new StringBuffer();
				if (httpRequest.getHeaders("Cookie").length > 0) {
					temp.append(httpRequest.getHeaders("Cookie")[0].getValue());
				}
				try {
					temp.append(java.net.URLEncoder.encode(Name, Setting.Charset));
					temp.append("=");
					temp.append(java.net.URLEncoder.encode(Value, Setting.Charset));
				}
				catch (java.io.UnsupportedEncodingException e) { // 编码不支持
					e.printStackTrace();
				}
				catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
					e.printStackTrace();
				}
				temp.append(";");
				httpRequest.setHeader("Cookie", temp.toString());
			}
			return this;
		}
		/**
		 * 添加请求的GET参数<br/>
		 * 添加到URL的参数部分的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * Name和Value可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * 忽略URL编码异常<br/>
		 */
		public HttpPostRequest AddGetParameter(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				StringBuffer URL = new StringBuffer();
				try {
					Name = java.net.URLEncoder.encode(Name, Setting.Charset);
					Value = java.net.URLEncoder.encode(Value, Setting.Charset);
				}
				catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if (httpRequest.getURI().getScheme() != null) {
					URL.append(httpRequest.getURI().getScheme());
					URL.append(':');
				}
				if (httpRequest.getURI().isOpaque()) {
					URL.append(httpRequest.getURI().getRawSchemeSpecificPart());
				}
				else {
					if (httpRequest.getURI().getRawAuthority() != null) {
						URL.append("//");
						URL.append(httpRequest.getURI().getRawAuthority());
					}
					if (httpRequest.getURI().getRawPath() != null) {
						URL.append(httpRequest.getURI().getRawPath());
					}
					if (httpRequest.getURI().getRawQuery() != null) {
						URL.append('?');
						URL.append(httpRequest.getURI().getRawQuery());
						URL.append('&');
						URL.append(Name);
						URL.append('=');
						URL.append(Value);
					}
					else {
						URL.append('?');
						URL.append(Name);
						URL.append('=');
						URL.append(Value);
					}
				}
				if (httpRequest.getURI().getRawFragment() != null) {
					URL.append('#');
					URL.append(httpRequest.getURI().getRawFragment());
				}
				try {
					httpRequest.setURI(new java.net.URI(URL.toString()));
				}
				catch (java.net.URISyntaxException e) {
					e.printStackTrace();
				}
			}
			return this;
		}
		/**
		 * 添加请求的POST参数<br/>
		 * 添加到POST键值对参数的末尾<br/>
		 * Name为null值则不做任何操作，Value的null值等效于空字符串""<br/>
		 * Name和Value可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * 忽略URL编码异常<br/>
		 */
		public HttpPostRequest AddPostParameter(java.lang.String Name, java.lang.String Value) {
			if (httpRequest != null && Name != null) {
				PostParameter.add(new org.apache.http.message.BasicNameValuePair(Name, Value));
			}
			return this;
		}
		/**
		 * 添加请求的上传文件参数<br/>
		 * Name为null值则不做任何操作，通常的值为"file"或"file[]"<br/>
		 * Name可以包含中文和特殊符号，会自动进行URL编码<br/>
		 * FilePath的值为文件在磁盘的绝对路径<br/>
		 * 上传时，如果某一个FilePath处文件不存在或不可读等等，则会导致请求发送失败<br/>
		 */
		public HttpPostRequest AddUploadFile(java.lang.String Name, java.lang.String FilePath) {
			if (httpRequest != null && Name != null) {
				UploadFile.add(new org.apache.http.message.BasicNameValuePair(Name, FilePath));
			}
			return this;
		}
		/**
		 * 设置文件保存路径<br/>
		 * FilePath为文件保存位置的绝对路径<br/>
		 * FilePath为null值，则表示不下载文件<br/>
		 * 
		 * @see #IsDownloadRequest
		 */
		public HttpPostRequest SetDownloadPath(java.lang.String FilePath) {
			DownloadPath = FilePath;
			return this;
		}
		/**
		 * 判断POST请求是否是一个文件下载请求<br/>
		 * 默认是获取响应主体的字符串的请求，通过调用SetDownloadPath可设定为文件下载的请求<br/>
		 * 
		 * @see #SetDownloadPath
		 */
		public boolean IsDownloadRequest() {
			return DownloadPath != null;
		}
		/**
		 * 设置是否忽略响应主体（只读取Header就终止请求）
		 * 
		 * @see #IsIgnoreBodyRequest
		 */
		public HttpPostRequest SetIgnoreResponseBody(boolean IgnoreBody) {
			IgnoreResponseBody = IgnoreBody;
			return this;
		}
		/**
		 * 判断POST请求是否是一个忽略响应主体（只读取Header就终止）的请求<br/>
		 * 默认是获取响应主体的字符串的请求，通过调用SetIgnoreResponseBody可设定为忽略响应主体的请求<br/>
		 * 
		 * @see #SetIgnoreResponseBody
		 */
		public boolean IsIgnoreBodyRequest() {
			return IgnoreResponseBody;
		}
		/**
		 * 设置要发送的POST参数为一段指定的字符串<br/>
		 * 通常是JSON或者XML格式的字符串<br/>
		 * ParameterString为null值，则表示不发送字符串，而发送POST键值对和上传文件的参数（默认）<br/>
		 * ParameterString不为null值，则已保存的键值对参数不会被发送<br/>
		 * 
		 * @see #IsPostParameterStringRequest
		 */
		public HttpPostRequest SetPostParameterString(java.lang.String ParameterString) {
			PostParameterString = ParameterString;
			return this;
		}
		/**
		 * 判断请求要发送的的POST参数是否为一段指定的字符串<br/>
		 * 如果是，则发送一段字符串作为POST参数，已保存的POST键值对参数不会被发送<br/>
		 * 如果不是，则已保存的POST键值对和上传文件的参数会被发送（默认）<br/>
		 * 
		 * @see #SetPostParameterString
		 */
		public boolean IsPostParameterStringRequest() {
			return PostParameterString != null;
		}
		/**
		 * 执行请求，默认返回响应主体字符串<br/>
		 * 如果执行请求过程中发生了异常，则返回null值<br/>
		 * 如果调用SetDownloadPath设置了文件保存路径，POST请求是一个文件下载请求，则返回空字符串""，表示下载成功，返回null值，表示下载失败<br/>
		 * 如果调用SetIgnoreResponseBody设置了忽略响应主体，POST请求是一个只读取Header就终止的请求，则返回空字符串""，表示请求成功，返回null值，表示请求失败<br/>
		 * 如果调用SetPostParameterString设置了POST参数为一段字符串，则已保存的POST键值对和上传文件的参数会被忽略<br/>
		 * 多次调用本函数，会发送多次请求<br/>
		 * 函数内部完成了连接的请求和返还操作，不会造成连接池的资源泄露<br/>
		 * 忽略所有异常<br/>
		 * 
		 * @see #SetDownloadPath
		 * @see #SetIgnoreResponseBody
		 * @see #SetPostParameterString
		 */
		public synchronized java.lang.String Execute() {
			try {
				if (httpRequest != null) {
					if (PostParameterString != null) {
						httpRequest.setEntity(new org.apache.http.entity.StringEntity(PostParameterString, Setting.Charset));
					}
					else if (UploadFile.size() != 0) {
						httpRequest.setEntity(new org.apache.http.HttpEntity() {
							// 必须实现的方法：
							@Override
							public void consumeContent() throws java.io.IOException {
								throw new UnsupportedOperationException("consumeContent does not supported");
							}
							@Override
							public java.io.InputStream getContent() throws java.io.IOException, IllegalStateException {
								throw new UnsupportedOperationException("getContent does not supported");
							}
							@Override
							public org.apache.http.Header getContentEncoding() {
								return null;
							}
							@Override
							public org.apache.http.Header getContentType() {
								return new org.apache.http.message.BasicHeader("Content-Type", "multipart/form-data;boundary=" + Boundary);
							}
							@Override
							public long getContentLength() {
								return -1;
							}
							@Override
							public boolean isChunked() {
								return false;
							}
							@Override
							public boolean isRepeatable() {
								return true;
							}
							@Override
							public boolean isStreaming() {
								return false;
							}
							// 上传文件的主要代码：
							private java.lang.String Boundary = java.util.UUID.randomUUID().toString();// 和时间、机器网卡等相关的一个唯一字符串（36字节）
							java.lang.String ParameterName;
							java.lang.String FilePath;
							java.lang.String FileName;
							java.io.InputStream FileInputStream;
							@Override
							public void writeTo(java.io.OutputStream outstream) throws java.io.IOException {
								java.io.DataOutputStream out = new java.io.DataOutputStream(outstream);
								for (org.apache.http.NameValuePair Pair : UploadFile) {
									out.writeBytes("--" + Boundary + "\r\n");
									ParameterName = Pair.getName();// 参数名
									FilePath = Pair.getValue(); // 文件路径
									FileName = new java.io.File(FilePath).getName();// 文件名
									out.write(("Content-Disposition: form-data; name=\"" + ParameterName + "\"; filename=\"" + FileName + "\"" + "\r\n").getBytes(Setting.Charset));
									out.writeBytes("Content-Type: application/octet-stream" + "\r\n");
									out.writeBytes("\r\n");
									try {
										FileInputStream = new java.io.FileInputStream(FilePath);// 将文件读入输入流中
										byte[] buffer = new byte[4096];
										int size = 0;
										while ((size = FileInputStream.read(buffer, 0, 4096)) > -1) {
											out.write(buffer, 0, size);// 写入到输出流中
										}
									}
									catch (java.io.IOException e) {
										throw e;
									}
									finally {
										try {
											FileInputStream.close();
										}
										catch (java.lang.Exception e) {}
									}
									out.writeBytes("\r\n");
								}
								for (org.apache.http.NameValuePair Pair : PostParameter) {
									out.writeBytes("--" + Boundary + "\r\n");
									out.write(("Content-Disposition: form-data; name=\"" + Pair.getName() + "\"" + "\r\n").getBytes(Setting.Charset));
									out.writeBytes("\r\n");
									out.write(Pair.getValue().getBytes(Setting.Charset));
									out.writeBytes("\r\n");
								}
								out.writeBytes("--" + Boundary + "--" + "\r\n");
								out.flush();
								out.close();
							}
						});
					}
					else {
						httpRequest.setEntity(new org.apache.http.client.entity.UrlEncodedFormEntity(PostParameter, Setting.Charset));
					}
					super.httpResponse = Instance().execute(httpRequest);
					if (IgnoreResponseBody == true) {
						super.ResponseBody = "";
					}
					else if (DownloadPath != null) {
						super.ResponseBody = DownLoadFile(super.httpResponse, DownloadPath);
					}
					else {
						super.ResponseBody = GetResponseBodyString(super.httpResponse);
					}
					return super.ResponseBody;
				}
			}
			catch (android.os.NetworkOnMainThreadException e) { // UI线程不支持网络操作
				e.printStackTrace();
			}
			catch (org.apache.http.conn.ConnectionPoolTimeoutException e) { // 连接池等待超时
				e.printStackTrace();
			}
			catch (org.apache.http.client.ClientProtocolException e) { // HTTP协议错误
				e.printStackTrace();
			}
			catch (java.io.UnsupportedEncodingException e) {// 字符集不支持
				e.printStackTrace();
			}
			catch (java.nio.charset.UnsupportedCharsetException e) { // 无效的字符编码
				e.printStackTrace();
			}
			catch (java.net.UnknownHostException e) {// 域名解析失败（未连接网络）
				e.printStackTrace();
			}
			catch (java.lang.IllegalStateException e) {// HttpClient的连接池被关闭
				e.printStackTrace();
			}
			catch (java.io.IOException e) {// IO的其他异常
				e.printStackTrace();
			}
			catch (java.lang.Exception e) { // 其它未知异常
				e.printStackTrace();
			}
			finally {// 保证将连接返回给连接池
				if (super.httpResponse != null && super.httpResponse.getEntity() != null) {
					try {
						super.httpResponse.getEntity().getContent().close();
					}
					catch (java.lang.Exception e) {}
				}
			}
			return null;
		}
	}
	/**
	 * 用指定的URL构造一个新的GET请求，并返回其引用<br/>
	 * 代码：return new HttpGetRequest(URL);<br/>
	 * 
	 * @see HttpGetRequest
	 */
	public static HttpGetRequest Get(java.lang.String URL) {
		return new HttpGetRequest(URL);
	}
	/**
	 * 用指定的URL构造一个新的POST请求，并返回其引用<br/>
	 * 代码：return new HttpPostRequest(URL);<br/>
	 * 
	 * @see HttpPostRequest
	 */
	public static HttpPostRequest Post(java.lang.String URL) {
		return new HttpPostRequest(URL);
	}
	/**
	 * 将URL处的文件下载至FilePath处<br/>
	 * 返回是否下载成功<br/>
	 * 代码：return HttpClient.Get(URL).SetDownloadPath(FilePath).Execute() != null;<br/>
	 * 
	 * @see #Get
	 */
	public static boolean DownLoad(java.lang.String URL, java.lang.String FilePath) {
		return HttpClient.Get(URL).SetDownloadPath(FilePath).Execute() != null;
	}
	/**
	 * 将FilePath处的文件上传至URL处<br/>
	 * 返回是否上传成功<br/>
	 * 代码：return HttpClient.Post(URL).AddUploadFile("file", FilePath).Execute() != null;<br/>
	 * 
	 * @see #Post
	 */
	public static boolean UpLoad(java.lang.String URL, java.lang.String FilePath) {
		return HttpClient.Post(URL).AddUploadFile("file", FilePath).Execute() != null;
	}
}
