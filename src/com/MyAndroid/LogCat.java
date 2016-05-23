package com.MyAndroid;

//使用LogCat记录信息
//（纯静态函数库）
public class LogCat {
	public static void Verbose(Object Variable) {
		android.util.Log.v(GetVariableType(Variable), java.lang.String.valueOf(Variable));
	}
	public static void Debug(Object Variable) {
		android.util.Log.d(GetVariableType(Variable), java.lang.String.valueOf(Variable));
	}
	public static void Info(Object Variable) {
		android.util.Log.i(GetVariableType(Variable), java.lang.String.valueOf(Variable));
	}
	public static void Warn(Object Variable) {
		android.util.Log.w(GetVariableType(Variable), java.lang.String.valueOf(Variable));
	}
	public static void Error(Object Variable) {
		android.util.Log.e(GetVariableType(Variable), java.lang.String.valueOf(Variable));
	}
	private static java.lang.String GetVariableType(Object Variable) {
		if (Variable == null) {
			return "空指针";
		}
		java.lang.StringBuffer Buffer = new java.lang.StringBuffer();
		if (Variable instanceof java.lang.String) {
			Buffer.append("java.lang.String 长度：");
			Buffer.append(((java.lang.String) Variable).length());
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof Integer) {
			Buffer.append("Integer");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof Boolean) {
			Buffer.append("Boolean");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof Long) {
			Buffer.append("Long");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof Double) {
			Buffer.append("Double");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof Float) {
			Buffer.append("Float");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof android.app.Activity) {
			Buffer.append("Activity");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof android.app.Fragment) {
			Buffer.append("Fragment");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof java.util.Date) {
			Buffer.append("Date");
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else if (Variable instanceof android.graphics.Bitmap) {
			Buffer.append("Bitmap 宽度：");
			Buffer.append(((android.graphics.Bitmap) Variable).getWidth());
			Buffer.append(" 高度：");
			Buffer.append(((android.graphics.Bitmap) Variable).getHeight());
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		else {
			Buffer.append(Variable.getClass().getName());
			Buffer.append(" @");
			Buffer.append(Integer.toString(Variable.hashCode()));
		}
		return Buffer.toString();
	}
	public static void Verbose(java.lang.String Tag, Object Msg) {
		if (Tag != null && Msg != null && !Tag.equals("") && !Msg.equals("")) {
			android.util.Log.v(java.lang.String.valueOf(Tag), java.lang.String.valueOf(Msg));
		}
	}
	public static void Debug(java.lang.String Tag, Object Msg) {
		if (Tag != null && Msg != null && !Tag.equals("") && !Msg.equals("")) {
			android.util.Log.d(java.lang.String.valueOf(Tag), java.lang.String.valueOf(Msg));
		}
	}
	public static void Info(java.lang.String Tag, Object Msg) {
		if (Tag != null && Msg != null && !Tag.equals("") && !Msg.equals("")) {
			android.util.Log.i(java.lang.String.valueOf(Tag), java.lang.String.valueOf(Msg));
		}
	}
	public static void Warn(java.lang.String Tag, Object Msg) {
		if (Tag != null && Msg != null && !Tag.equals("") && !Msg.equals("")) {
			android.util.Log.w(java.lang.String.valueOf(Tag), java.lang.String.valueOf(Msg));
		}
	}
	public static void Error(java.lang.String Tag, Object Msg) {
		if (Tag != null && Msg != null && !Tag.equals("") && !Msg.equals("")) {
			android.util.Log.e(java.lang.String.valueOf(Tag), java.lang.String.valueOf(Msg));
		}
	}
}
