package com.xiao.demo.util;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;

/**
 * 格式化TextView文字 显示不同大小 不同颜色
 * 
 * @Version 1.0 注意contents colors textSizes value对应的key值必须一致 用法
 *          CharsequencePharse.init().setContents().setColors().setTextSizes().
 *          format(); setContents必须调用 setColors 与 setTextSizes可以不调 三个方法调用顺序不限
 */
public class CharsequencePharse
{
	/** Cached result after replacing all keys with corresponding values. */
	private CharSequence formatted;

	private SparseArray<String> contents;

	private SparseArray<Integer> colors;

	private SparseArray<Integer> textSizes;

	private CharsequencePharse()
	{
		super();
	}

	public static CharsequencePharse init()
	{
		return new CharsequencePharse();
	}

	public CharsequencePharse setContents(SparseArray<String> contents)
	{
		this.contents = contents;
		return this;
	}

	public CharsequencePharse setColors(SparseArray<Integer> colors)
	{
		this.colors = colors;
		return this;
	}

	public CharsequencePharse setTextSizes(SparseArray<Integer> textSizes)
	{
		this.textSizes = textSizes;
		return this;
	}

	public CharSequence format()
	{
		if (contents == null || contents.size() == 0) { return null; }
		if (formatted == null)
		{
			formatted = formatSpannable();
		}
		return formatted;
	}

	private SpannableStringBuilder formatSpannable()
	{
		SpannableStringBuilder wordtoSpan = new SpannableStringBuilder();
		for (int i = 0; i < contents.size(); i++)
		{
			int key = contents.keyAt(i);
			String str = contents.get(key);
			wordtoSpan.append(str);
			Integer color = colors == null ? null : colors.get(key);
			Integer textSize = textSizes == null ? null : textSizes.get(key);
			int startPoint = wordtoSpan.length() - str.length();
			int endPoint = wordtoSpan.length();
			if (textSize != null)
			{
				wordtoSpan.setSpan(new AbsoluteSizeSpan(textSize, true), startPoint, endPoint, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			if (color != null)
			{
				wordtoSpan.setSpan(new ForegroundColorSpan(color), startPoint, endPoint, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
//			MyUtil.showLog(CharsequencePharse.class.getSimpleName(),"formatSpannable key "+key+" str "+str+" startPoint "+startPoint+" endPoint "+endPoint+" textSize "+textSize);
		}
		// // 设置文字大小
		// WordtoSpan.setSpan(new AbsoluteSizeSpan(, true), 0, suffix.length(),
		// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		// WordtoSpan.setSpan(new AbsoluteSizeSpan(, true), source.length() -
		// value.length(), source.length(),
		// Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		// WordtoSpan.setSpan(new ForegroundColorSpan(colorLight), source.length() -
		// value.length(), source.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		// WordtoSpan.setSpan(new ForegroundColorSpan(colorDark), 0,
		// suffix.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		return wordtoSpan;
	}

}