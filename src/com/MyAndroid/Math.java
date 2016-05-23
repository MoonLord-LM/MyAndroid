package com.MyAndroid;

// 数学运算
//（纯静态函数库）
public class Math {
	public static int RandomInt(int Min, int Max) {
		return (new java.util.Random()).nextInt(Max - Min + 1) + Min;
	}
	public static double RandomDouble(double Min, double Max) {
		return (new java.util.Random()).nextDouble() * (Max - Min) + Min;
	}
	public static float RandomFloat(float Min, float Max) {
		return (new java.util.Random()).nextFloat() * (Max - Min) + Min;
	}
	public static long RandomLong(long Min, long Max) {
		return (new java.util.Random()).nextLong() * (Max - Min) + Min;
	}
	public static boolean RandomBoolean() {
		return (new java.util.Random()).nextBoolean();
	}
}
