package com.MyAndroid;

// 图片裁剪操作
//（纯静态函数库）
// 注意，裁剪大小比原图还大时，会将图片放大
public class ImageCut {
	// 需要取出的图片大小已确定，不拉伸变形，尽量取出最大范围的原图（高质量，透明抗锯齿）
	public static android.graphics.Bitmap CenterCrop(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
		int SourceHeight = SourceBitmap.getHeight();// 原始图大小
		int SourceWidth = SourceBitmap.getWidth();
		float SourceRatio = (float) SourceHeight / (float) SourceWidth;// 图片高宽比率
		float Ratio = (float) Height / (float) Width;
		android.graphics.Rect srcRect;// 裁剪范围
		android.graphics.Rect dstRect = new android.graphics.Rect(0, 0, Width, Height);
		if (SourceRatio > Ratio) {// 原始图较高（以宽度为限制，尽量取出最高）
			final int srcRectHeight = (int) (SourceWidth * Ratio); // 高度
			final int scrRectTop = (int) (SourceHeight - srcRectHeight) / 2; // 上边距
			srcRect = new android.graphics.Rect(0, scrRectTop, SourceWidth, scrRectTop + srcRectHeight);
		}
		else {// 原始图较宽（以高度为限制，尽量取出最宽）
			final int srcRectWidth = (int) (SourceHeight / Ratio); // 宽度
			final int srcRectLeft = (int) (SourceWidth - srcRectWidth) / 2; // 左边距
			srcRect = new android.graphics.Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, SourceHeight); // 左边距，上边距，宽度，高度
		}
		android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(Width, Height, android.graphics.Bitmap.Config.ARGB_8888);// 最佳质量
		android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
		canvas.drawBitmap(SourceBitmap, srcRect, dstRect, new android.graphics.Paint(android.graphics.Paint.FILTER_BITMAP_FLAG | android.graphics.Paint.ANTI_ALIAS_FLAG));// 抗锯齿
		return TargetBitmap;
	}
	// 需要取出的图片大小已确定，不拉伸变形，尽量取出最大范围的原图（低质量，不透明不抗锯齿）
	public static android.graphics.Bitmap CenterCropLowQuality(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
		int SourceHeight = SourceBitmap.getHeight();// 原始图大小
		int SourceWidth = SourceBitmap.getWidth();
		float SourceRatio = (float) SourceHeight / (float) SourceWidth;// 图片高宽比率
		float Ratio = (float) Height / (float) Width;
		android.graphics.Rect srcRect;// 裁剪范围
		android.graphics.Rect dstRect = new android.graphics.Rect(0, 0, Width, Height);
		if (SourceRatio > Ratio) {// 原始图较高（以宽度为限制，尽量取出最高）
			final int srcRectHeight = (int) (SourceWidth * Ratio); // 高度
			final int scrRectTop = (int) (SourceHeight - srcRectHeight) / 2; // 上边距
			srcRect = new android.graphics.Rect(0, scrRectTop, SourceWidth, scrRectTop + srcRectHeight);
		}
		else {// 原始图较宽（以高度为限制，尽量取出最宽）
			final int srcRectWidth = (int) (SourceHeight / Ratio); // 宽度
			final int srcRectLeft = (int) (SourceWidth - srcRectWidth) / 2; // 左边距
			srcRect = new android.graphics.Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, SourceHeight); // 左边距，上边距，宽度，高度
		}
		android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(Width, Height, android.graphics.Bitmap.Config.RGB_565);// 降低质量
		android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
		canvas.drawBitmap(SourceBitmap, srcRect, dstRect, null);// 不抗锯齿
		return TargetBitmap;
	}
	// 需要取出的图片大小有限制，不拉伸变形，将原图缩放到最大范围（高质量，透明抗锯齿）
	public static android.graphics.Bitmap FitSize(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
		int SourceHeight = SourceBitmap.getHeight();// 原始图大小
		int SourceWidth = SourceBitmap.getWidth();
		float SourceRatio = (float) SourceHeight / (float) SourceWidth;// 图片高宽比率
		float Ratio = (float) Height / (float) Width;
		android.graphics.Rect srcRect = new android.graphics.Rect(0, 0, SourceWidth, SourceHeight);// 裁剪范围
		android.graphics.Rect dstRect;
		if (SourceRatio > Ratio) {// 原始图较高（以宽度为限制，尽量取出最高）
			dstRect = new android.graphics.Rect(0, 0, (int) (Height / SourceRatio), Height);
		}
		else {// 原始图较宽（以高度为限制，尽量取出最宽）
			dstRect = new android.graphics.Rect(0, 0, Width, (int) (Width * SourceRatio)); // 左边距，上边距，宽度，高度
		}
		android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(dstRect.width(), dstRect.height(), android.graphics.Bitmap.Config.ARGB_8888);// 最佳质量
		android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
		canvas.drawBitmap(SourceBitmap, srcRect, dstRect, new android.graphics.Paint(android.graphics.Paint.FILTER_BITMAP_FLAG | android.graphics.Paint.ANTI_ALIAS_FLAG));// 抗锯齿
		return TargetBitmap;
	}
	// 需要取出的图片大小有限制，不拉伸变形，将原图缩放到最大范围（低质量，不透明不抗锯齿）
	public static android.graphics.Bitmap FitSizeLowQuality(android.graphics.Bitmap SourceBitmap, int Width, int Height) {
		int SourceHeight = SourceBitmap.getHeight();// 原始图大小
		int SourceWidth = SourceBitmap.getWidth();
		float SourceRatio = (float) SourceHeight / (float) SourceWidth;// 图片高宽比率
		float Ratio = (float) Height / (float) Width;
		android.graphics.Rect srcRect = new android.graphics.Rect(0, 0, SourceWidth, SourceHeight);// 裁剪范围
		android.graphics.Rect dstRect;
		if (SourceRatio > Ratio) {// 原始图较高（以宽度为限制，尽量取出最高）
			dstRect = new android.graphics.Rect(0, 0, (int) (Height / SourceRatio), Height);
		}
		else {// 原始图较宽（以高度为限制，尽量取出最宽）
			dstRect = new android.graphics.Rect(0, 0, Width, (int) (Width * SourceRatio)); // 左边距，上边距，宽度，高度
		}
		android.graphics.Bitmap TargetBitmap = android.graphics.Bitmap.createBitmap(dstRect.width(), dstRect.height(), android.graphics.Bitmap.Config.RGB_565);// 降低质量
		android.graphics.Canvas canvas = new android.graphics.Canvas(TargetBitmap);// 创建画布
		canvas.drawBitmap(SourceBitmap, srcRect, dstRect, null);// 不抗锯齿
		return TargetBitmap;
	}	
}
