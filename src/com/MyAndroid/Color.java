package com.MyAndroid;

// 颜色计算
//（纯静态函数库）
public class Color {
	// 随机颜色（不透明）
	public static int RandomRGBColor() {
		java.util.Random random = new java.util.Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return android.graphics.Color.rgb(r, g, b);
	}
	// 随机颜色（透明度也随机）
	public static int RandomARGBColor() {
		java.util.Random random = new java.util.Random();
		int a = random.nextInt(256);
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return android.graphics.Color.argb(a, r, g, b);
	}
	// 随机颜色（指定的透明度）
	public static int RandomARGBColor(int Alpha) {
		java.util.Random random = new java.util.Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return android.graphics.Color.argb(Alpha, r, g, b);
	}
	// 鲜艳的随机颜色（R、G、B的值必须有一个为0，有一个为255，另一个分量的值随机，不透明）
	public static int RandomLightColor() {
		java.util.Random random = new java.util.Random();
		int r, g, b;
		switch (random.nextInt(6)) {
			case 0:
				r = 0;
				g = 255;
				b = random.nextInt(256);
				break;
			case 1:
				r = 0;
				g = random.nextInt(256);
				b = 255;
				break;
			case 2:
				r = 255;
				g = 0;
				b = random.nextInt(256);
				break;
			case 3:
				r = random.nextInt(256);
				g = 0;
				b = 255;
				break;
			case 4:
				r = random.nextInt(256);
				g = 255;
				b = 0;
				break;
			case 5:
				r = 255;
				g = random.nextInt(256);
				b = 0;
				break;
			default:
				r = 0;
				g = 0;
				b = 0;
		}
		return android.graphics.Color.rgb(r, g, b);
	}
	// 鲜艳的随机颜色（R、G、B的值必须有一个为0，有一个为255，另一个分量的值随机，指定的透明度）
	public static int RandomLightColor(int Alpha) {
		java.util.Random random = new java.util.Random();
		int r, g, b;
		switch (random.nextInt(6)) {
			case 0:
				r = 0;
				g = 255;
				b = random.nextInt(256);
				break;
			case 1:
				r = 0;
				g = random.nextInt(256);
				b = 255;
				break;
			case 2:
				r = 255;
				g = 0;
				b = random.nextInt(256);
				break;
			case 3:
				r = random.nextInt(256);
				g = 0;
				b = 255;
				break;
			case 4:
				r = random.nextInt(256);
				g = 255;
				b = 0;
				break;
			case 5:
				r = 255;
				g = random.nextInt(256);
				b = 0;
				break;
			default:
				r = 0;
				g = 0;
				b = 0;
		}
		return android.graphics.Color.argb(Alpha, r, g, b);
	}
	// 彩虹色生成
	public static class RainbowColor {
		public int BeginColor; // 初始的随机彩虹色
		public int Alpha = 255;// 透明度（默认不透明）
		public int Red;// RGB颜色分量的值
		public int Green;
		public int Blue;
		public int ChangeSpeed = -1; // 每次计算新颜色时改变的某一个颜色分量的值（值为负数，则颜色变化顺序为红橙黄绿青蓝紫，值为正数则为相反顺序）
		public int ChangeMinValue = 0;// 颜色分量的最低值（为0时产生标准纯色，值越高，颜色越亮，颜色变化幅度也越小）
		public int ChangeMaxValue = 255;// 颜色分量的最高值（为255时产生标准纯色，值越高，颜色越亮，颜色变化幅度也越大）
		public int LastColor; // 上一次计算出的彩虹色
		// 内部记录的值
		private int ZeroColor;// 当前保持为0的颜色分量（值1、2、3，分别代表R、G、B）
		private int ChangeColor;// 当前变化的颜色分量（值1、2、3，分别代表R、G、B）
		private int FullColor;// 当前保持为255的颜色分量（值1、2、3，分别代表R、G、B）
		// 初始化
		public RainbowColor() {
			java.util.Random random = new java.util.Random();
			switch (random.nextInt(6)) {
				case 0:
					Red = 0;
					Green = 255;
					Blue = random.nextInt(256);
					ZeroColor = 1;
					ChangeColor = 3;
					FullColor = 2;
					break;
				case 1:
					Red = 0;
					Green = random.nextInt(256);
					Blue = 255;
					ZeroColor = 1;
					ChangeColor = 2;
					FullColor = 3;
					break;
				case 2:
					Red = 255;
					Green = 0;
					Blue = random.nextInt(256);
					ZeroColor = 2;
					ChangeColor = 3;
					FullColor = 1;
					break;
				case 3:
					Red = random.nextInt(256);
					Green = 0;
					Blue = 255;
					ZeroColor = 2;
					ChangeColor = 1;
					FullColor = 3;
					break;
				case 4:
					Red = random.nextInt(256);
					Green = 255;
					Blue = 0;
					ZeroColor = 3;
					ChangeColor = 1;
					FullColor = 2;
					break;
				case 5:
					Red = 255;
					Green = random.nextInt(256);
					Blue = 0;
					ZeroColor = 3;
					ChangeColor = 2;
					FullColor = 1;
					break;
				default:
					Red = 0;
					Green = 0;
					Blue = 0;
					ZeroColor = 0;
					ChangeColor = 0;
					FullColor = 0;
			}
			BeginColor = android.graphics.Color.argb(Alpha, Red, Green, Blue);
			LastColor = BeginColor;
		}
		// 计算产生下一个彩虹色
		public int NextColor() {
			switch (ChangeColor) {
				case 1:
					Red += ChangeSpeed;
					break;
				case 2:
					Green += ChangeSpeed;
					break;
				case 3:
					Blue += ChangeSpeed;
					break;
			}
			if (Red > ChangeMaxValue) {
				Red = ChangeMaxValue;
				ChangeSpeed = -ChangeSpeed;
				SwapFullColor();
			}
			else if (Green > ChangeMaxValue) {
				Green = ChangeMaxValue;
				ChangeSpeed = -ChangeSpeed;
				SwapFullColor();
			}
			else if (Blue > ChangeMaxValue) {
				Blue = ChangeMaxValue;
				ChangeSpeed = -ChangeSpeed;
				SwapFullColor();
			}
			else if (Red < ChangeMinValue) {
				Red = ChangeMinValue;
				ChangeSpeed = -ChangeSpeed;
				SwapZeroColor();
			}
			else if (Green < ChangeMinValue) {
				Green = ChangeMinValue;
				ChangeSpeed = -ChangeSpeed;
				SwapZeroColor();
			}
			else if (Blue < ChangeMinValue) {
				Blue = ChangeMinValue;
				ChangeSpeed = -ChangeSpeed;
				SwapZeroColor();
			}
			LastColor = android.graphics.Color.rgb(Red, Green, Blue);
			return LastColor;
		}
		// 交换ChangeColor和FullColor的值
		private void SwapFullColor() {
			int temp = ChangeColor;
			ChangeColor = FullColor;
			FullColor = temp;
			// ChangeColor = ChangeColor ^ FullColor;
			// FullColor = ChangeColor ^ FullColor;
			// ChangeColor = ChangeColor ^ FullColor;
		}
		// 交换ChangeColor和ZeroColor的值
		private void SwapZeroColor() {
			int temp = ChangeColor;
			ChangeColor = ZeroColor;
			ZeroColor = temp;
			// ChangeColor = ChangeColor ^ ZeroColor;
			// ZeroColor = ChangeColor ^ ZeroColor;
			// ChangeColor = ChangeColor ^ ZeroColor;
		}
	}
}
