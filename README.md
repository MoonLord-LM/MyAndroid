<H1>MyAndroid 安卓开发中文开源库 </H1>
<pre>MyAndroid, a rapid development framework for android development.</pre>
<H3>   </H3>
<pre>
版本1.0 (2015.2.10) 安卓SDK版本要求：11-21(安卓3.0-安卓5.0.1) 统一编码：UTF-8 代码：5137行 
使用提示：请确保项目的主Activity继承自MyActivity。
代码在Android 4.0环境下编译成功，无错误，无警告。 
GitHub开源地址：http://github.com/MoonLord-LM/MyAndroid 
维护：MoonLord
联系QQ：178910432
交流QQ群：130490067 
技术支持：武汉大学RMC工作室 武汉大学计算机协会
</pre>
<H3>Android（JAVA & Eclipse）开发的面向过程（模块化）的代码，各种封装好的类和函数，加速开发进度。主要模块如下：</H3>
<H4>   </H4>
<H4>主窗体全局静态引用</H4>
<pre>	在任何地方都可以使用My.MainActivity获取主Activity的引用。</pre>
<H4>常用的常量</H4>
<pre>	My.Const.Null，指向JAVA的Null值，可用于取消默认的警告提示（参数不能为Null）。</pre>
<H4>字符串函数</H4>
<pre>	My.Stirng.FromArray(StringArray1)，轻松将字符串数组转化为字符串。</pre>
<H4>记录信息到LogCat</H4>
<pre>	My.LogCat.Log()，可重载函数，支持一系列类型的参数，在输出到LogCat中时还会输出类型。</pre>
<H4>桌面快捷方式</H4>
<pre>	My.ShortCut.Create()，可重载函数，轻松创建多个文本和图片均不相同的安卓桌面图标。</pre>
<H4>Toast输出信息</H4>
<pre>	My.Toast.Show()，可重载函数，支持创建带有图片和标题和文本的Toast提示层。</pre>
<H4>AlertDialog输出信息</H4>
<pre>	new My.AlertDialog.New().show();可创建单选、按钮、多选、图片等各类对话框。</pre>
<H4>网络数据交互</H4>
<pre>	从简单的My.Http.Get("http://www.moonlord.cn")，获取网页源码。</pre>
<pre>	到复杂的My.Http.UpLoadSDCard()，可在上传SD卡的文件的同时发送GET、POST、COOKIE、REFERER参数，并获取响应源码。</pre>
<H4>数学计算</H4>
<pre>	My.Maths.SmoothChangeLightColor.NewColor()，每次调用都会返回一个不同的鲜艳的颜色int值。</pre>
<pre>	不断获取的颜色连贯起来是鲜艳的七色光（源码中有示例效果）。</pre>
<H4>自定义数据结构</H4>
<pre>	My.Class.KeyValue数据结构，自定义的字符串键值对存储结构，提供一系列丰富的增、删、改、查、输出函数。</pre>
<pre>	My.Class.Json数据结构，封装了org.json.JSONArray和org.json.JSONObject，提供更加丰富和便捷的增、删、改、查、输出、转化等功能。</pre>
<pre> 代码示例：Json1.Get("root").Get(1).Get("username").GetInt(0);</pre>
<H4>设备信息</H4>
<pre>	My.Device.ProductTime()，轻松获取安卓产品生产日期。</pre>
<H4>时间信息</H4>
<pre>	My.Time.NowTime()，轻松获取当前设备时间。</pre>
<H4>屏幕信息</H4>
<pre>	My.Screen.Width()，获取屏幕宽度，My.Screen.KeepScreenOn()，使屏幕保持长亮状态。</pre>
<H4>内存信息</H4>
<pre>	My.Memory.AvailableMemory()，获取可用内存，My.Memory.TotalMemory()，获取设备总内存。</pre>
<H4>Fragment管理</H4>
<pre>	My.Fragment.SlideIn()，轻松进行Fragment的切换。</pre>
<H4>Activity管理</H4>
<pre>	My.Activity.Start()，轻松进行Activity的切换。</pre>
<H4>IO操作</H4>
<pre>	My.IO.WriteFile()，My.IO.Rom.TotalSize()，My.IO.SDCard.ReadFile()，IO操作从未如此简单。</pre>
<H4>Camera操作</H4>
<pre>	My.Camera.GetCropPhoto()，轻松调用系统图库获取和裁剪图片。</pre>
<H4>震动操作</H4>
<pre>	My.Vibrator.Repeat()，轻松设定震动模式和速度。</pre>
<H4>UI定时器操作</H4>
<pre>	My.Timer.IntervalTimerTask，可定时执行、并且跨线程操作UI的Runnable扩展类。</pre>
<H4>通知栏操作</H4>
<pre>	My.Notification.Hold()，轻松创建一个不可以被用户左滑删除掉的顶部通知。</pre>
<H3>   </H3>
<pre>友情提示：别忘了有些操作是需要权限的哦，可参照源码示例的AndroidManifest.xml。</pre>
<pre>代码总是少不了BUG，有不足之处还望指出。</pre>
<H3>   </H3>
<H3>更多功能，欢迎导入My.java，然后自行探索。</H3>
<H3>持续更新维护，求Fork，求Star。</H3>
