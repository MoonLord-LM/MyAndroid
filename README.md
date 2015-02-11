# MyAndroid
A rapid development framework for android development.

<H1>MyAndroid 安卓开发中文开源库 </H1>

<pre>
版本1.0 （2015.2.10） 安卓SDK版本要求：11-21（安卓3.0-安卓5.0.1） 统一编码：UTF-8 代码：5137行 
使用提示：请确保项目的主Activity继承自MyActivity。 代码在Android 4.0环境下编译成功，无错误，无警告。 
GitHub开源地址：http://github.com/MoonLord-LM/MyAndroid 
MoonLord 联系QQ：178910432 交流QQ群：130490067 
技术支持：武汉大学RMC工作室 武汉大学计算机协会
</pre>

主要功能：Android（JAVA & Eclipse）开发的面向过程（模块化）的代码，各种封装好的类和函数，方便编码，加速开发进度。

目前的主要模块：
// 主窗体全局静态引用
	在任何地方都可以使用My.MainActivity获取主Activity的引用。
// 常用的常量
	My.Const.Null，指向JAVA的Null值，可用于取消默认的警告提示（参数不能为Null）。
// 字符串函数
	My.Stirng.FromArray(StringArray1)，轻松将字符串数组转化为字符串。
// 记录信息到LogCat
	My.LogCat.Log()，可重载函数，支持一系列类型的参数，在输出到LogCat中时还会输出类型。
// 桌面快捷方式
	My.ShortCut.Create()，可重载函数，轻松创建多个文本和图片均不相同的安卓桌面图标。
// Toast输出信息
	My.Toast.Show()，可重载函数，支持创建带有图片和标题和文本的Toast提示层。
// AlertDialog输出信息
	new My.AlertDialog.New().show();可创建单选、按钮、多选、图片等各类对话框。
// 网络数据交互
	从简单的My.Http.Get("http://www.moonlord.cn")，获取网页源码，到最复杂的My.Http.UpLoadSDCard()，可以支持在上传SD卡的文件的同时发送GET、POST、COOKIE、REFERER参数，并获取响应的源码。
// 数学计算
	My.Maths.SmoothChangeLightColor.NewColor()，每次调用都会返回一个不同的鲜艳的颜色int值，不断获取的颜色连贯起来是鲜艳的七色光（源码中有示例效果）。
// 自定义数据结构
	My.Class.KeyValue数据结构，自定义的字符串键值对存储结构，提供一系列丰富的增、删、改、查、输出函数。
	My.Class.Json数据结构，自定义的JSON数据结构，封装了org.json.JSONArray和org.json.JSONObject，提供更加丰富和便捷的增、删、改、查、输出、转化等功能，代码示例：Json1.Get("root").Get(1).Get("username").GetInt(0);
// 设备信息
	My.Device.ProductTime()，轻松获取安卓产品生产日期。
// 时间信息
	My.Time.NowTime()，轻松获取当前设备时间。
// 屏幕信息
	My.Screen.Width()，获取屏幕宽度，My.Screen.KeepScreenOn()，使屏幕保持长亮状态。
// 内存信息
	My.Memory.AvailableMemory()，获取可用内存，My.Memory.TotalMemory()，获取设备总内存。
// Fragment管理
	My.Fragment.SlideIn()，轻松进行Fragment的切换。
// Activity管理
	My.Activity.Start()，轻松进行Activity的切换。
// IO操作
	My.IO.WriteFile()，My.IO.Rom.TotalSize()，My.IO.SDCard.ReadFile()，IO操作从未如此简单。
// Camera操作
	My.Camera.GetCropPhoto()，轻松调用系统图库获取和裁剪图片。
// 震动操作
	My.Vibrator.Repeat()，轻松设定震动模式和速度。
// UI定时器操作
	My.Timer.IntervalTimerTask，可定时执行、并且跨线程操作UI的Runnable扩展类。
// 通知栏操作
	My.Notification.Hold()，轻松创建一个不可以被用户左滑删除掉的顶部通知。

更多功能，欢迎导入My.java然后自行探索。持续更新，欢迎关注。

友情提示，别忘了有些操作是需要权限的哟：
<uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
<uses-permission android:name="com.android.launcher.permission.UNINSTALL_SHORTCUT" />
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.VIBRATE"/>
