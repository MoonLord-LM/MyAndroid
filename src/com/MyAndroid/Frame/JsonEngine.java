package com.MyAndroid.Frame;

import com.MyAndroid.HttpClient;
import com.MyAndroid.Json;

// 网络交互引擎（Json API）
//
// 注意：
// 需要保证后端API接口返回的数据为标准Json格式的字符串
// 请求发生异常（获取不到响应字符串）时，Runable.run(Response, Data)中的Response会为null值
// 请求发生异常（响应字符串无法转换为Json）时，Runable.run(Response, Data)中的Data会为null值
//
// 提示：
// 网络访问使用com.MyAndroid.HttpClient执行（默认30秒超时）
//
public class JsonEngine {
	// 线程池
	private static java.util.concurrent.ExecutorService ThreadPool;
	private static java.util.concurrent.ExecutorService ThreadPool() {
		if (ThreadPool == null) {
			ThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
		}
		return ThreadPool;
	}
	// 更新UI
	private static void Return(android.app.Activity Activity, final String Response, final Json Data, final JsonRunable JsonRunable) {
		if (Activity != null) {
			Activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					JsonRunable.runOnUiThread(Response, Data);
				}
			});
		}
	}
	// 加载Json（主要函数，可在UI线程调用）
	public static void Get(final android.app.Activity Activity, final java.lang.String URL, final JsonRunable JsonRunable) {
		ThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				java.lang.String Response = HttpClient.Get(URL).Execute();
				Json Data = (Response != null) ? new Json(Response) : null;
				if (Data != null && Data.IsValidJson() == false) {
					Data = null;
				}
				Return(Activity, Response, Data, JsonRunable);
			}
		});
	}
	public static void Get(final android.app.Activity Activity, final HttpClient.HttpGetRequest Request, final JsonRunable JsonRunable) {
		ThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				java.lang.String Response = Request.Execute();
				Json Data = (Response != null) ? new Json(Response) : null;
				if (Data != null && Data.IsValidJson() == false) {
					Data = null;
				}
				Return(Activity, Response, Data, JsonRunable);
			}
		});
	}
	public static void Post(final android.app.Activity Activity, final java.lang.String URL, final JsonRunable JsonRunable) {
		ThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				java.lang.String Response = HttpClient.Post(URL).Execute();
				Json Data = (Response != null) ? new Json(Response) : null;
				if (Data != null && Data.IsValidJson() == false) {
					Data = null;
				}
				Return(Activity, Response, Data, JsonRunable);
			}
		});
	}
	public static void Post(final android.app.Activity Activity, final HttpClient.HttpPostRequest Request, final JsonRunable JsonRunable) {
		ThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				java.lang.String Response = Request.Execute();
				Json Data = (Response != null) ? new Json(Response) : null;
				if (Data != null && Data.IsValidJson() == false) {
					Data = null;
				}
				Return(Activity, Response, Data, JsonRunable);
			}
		});
	}
	public static abstract class JsonRunable {
		public abstract void runOnUiThread(java.lang.String Response, Json Data);
	}
	//代码示例：
	/*
	JsonEngine.Get(MainActivity.this, "https://www.baidu.com/img/bdlogo.png", new JsonEngine.JsonRunable() {
		@Override
		public void runOnUiThread(String Response, Json Data) {
			if (Response==null) {
				Toast.Show("无法连接服务器，请检查网络");
				return;
			}
			if (Data==null) {
				Toast.Show("服务器出现异常，请稍后再试");
				return;
			}
			Toast.Show(Data.JsonString());
			return;
		}
	});
	*/
}
