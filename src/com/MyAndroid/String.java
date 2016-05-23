package com.MyAndroid;

//字符串处理
//（纯静态函数库）
public class String {
	public static java.lang.String FromArray(java.lang.String[] StringArray, java.lang.String Separator) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("");
		if (StringArray != null && StringArray.length > 0) {
			for (int i = 0; i < StringArray.length - 1; i++) {
				sb.append(StringArray[i]);
				sb.append(Separator);
			}
			sb.append(StringArray[StringArray.length - 1]);
		}
		return sb.toString();
	}
	public static java.lang.String FromArray(java.lang.String[] StringArray) {
		return FromArray(StringArray, "\r\n");
	}
	public static java.lang.String FromList(java.util.List<java.lang.String> StringList, java.lang.String Separator) {
		java.lang.StringBuffer sb = new StringBuffer("");
		if (StringList != null && StringList.size() > 0) {
			for (int i = 0; i < StringList.size() - 1; i++) {
				sb.append(StringList.get(i));
				sb.append(Separator);
			}
			sb.append(StringList.get(StringList.size() - 1));
		}
		return sb.toString();
	}
	public static java.lang.String FromList(java.util.List<java.lang.String> StringList) {
		return FromList(StringList, "\r\n");
	}
	public static java.lang.String FromSet(java.util.Set<java.lang.String> StringSet, java.lang.String Separator) {
		java.lang.StringBuffer sb = new StringBuffer("");
		if (StringSet != null && StringSet.size() > 0) {
			java.util.Iterator<java.lang.String> it = StringSet.iterator();
			sb.append(it.next());
			while (it.hasNext()) {
				sb.append(Separator);
				sb.append(it.next());
			}
		}
		return sb.toString();
	}
	public static java.lang.String FromSet(java.util.Set<java.lang.String> StringSet) {
		return FromSet(StringSet, "\r\n");
	}
	// 从前向后，搜索第一个Begin字符串，然后搜索第一个End字符串，截取出中间的字符串，失败返回""
	public static java.lang.String FindFirst(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		if (Source == null || Begin == null || End == null) {
			return "";
		}
		int index = Source.indexOf(Begin);
		if (index == -1) {
			return "";
		}
		Source = Source.substring(index + Begin.length());
		index = Source.indexOf(End);
		if (index == -1) {
			return "";
		}
		return Source.substring(0, index);
	}
	// 从前向后，搜索最后一个Begin字符串，然后搜索第一个End字符串，截取出中间的字符串，失败返回""
	public static java.lang.String FindLast(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		if (Source == null || Begin == null || End == null) {
			return "";
		}
		int index = Source.lastIndexOf(Begin);
		if (index == -1) {
			return "";
		}
		Source = Source.substring(index + Begin.length());
		index = Source.indexOf(End);
		if (index == -1) {
			return "";
		}
		return Source.substring(0, index);
	}
	// 从前向后，搜索第一个Begin字符串，然后搜索最后一个End字符串，截取出中间的字符串，失败返回""
	public static java.lang.String FindMiddle(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		if (Source == null || Begin == null || End == null) {
			return "";
		}
		int index = Source.indexOf(Begin);
		if (index == -1) {
			return "";
		}
		Source = Source.substring(index + Begin.length());
		index = Source.lastIndexOf(End);
		if (index == -1) {
			return "";
		}
		return Source.substring(0, index);
	}
	// 从前向后，依次搜索Begin字符串和End字符串，然后依次截取出中间的字符串，返回截取出的字符串的数组，失败返回空数组
	public static java.util.List<java.lang.String> FindList(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		java.util.List<java.lang.String> temp = new java.util.ArrayList<java.lang.String>();
		if (Source == null || Begin == null || End == null) {
			return temp;
		}
		int index = Source.indexOf(Begin);
		while (index != -1) {
			Source = Source.substring(index + Begin.length());
			index = Source.indexOf(End);
			if (index == -1) {
				break;
			}
			else {
				temp.add(Source.substring(0, index));
				Source = Source.substring(index + End.length());
				index = Source.indexOf(Begin);
			}
		}
		return temp;
	}
	public static java.lang.String[] FindArray(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		return FindList(Source, Begin, End).toArray(new java.lang.String[0]);
	}
	public static java.util.Set<java.lang.String> FindSet(java.lang.String Source, java.lang.String Begin, java.lang.String End) {
		return new java.util.HashSet<java.lang.String>(FindList(Source, Begin, End));
	}
}
