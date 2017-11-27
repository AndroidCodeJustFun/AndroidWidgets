package com.xiao.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 基础数据校验
 *
 * @author xiao
 */
public class CheckUtil {

	public static void main(String[] args) {
		CheckUtil c = new CheckUtil();
		System.out.println("main.args.instance  " + c.isEmpty(""));

		System.out.println("main.args.instance  emptyLIst " + c.isEmpty(new ArrayList<>()));

		HashMap<Object, Object> hashMap = new HashMap<>();
		System.out.println("main.args.instance  empotyMap " + c.isEmpty(new HashMap<>()));

		Set<Object> keySet = hashMap.keySet();
		System.out.println("main.args.instance  " + c.isEmpty(keySet));
	}

	public static <T> boolean isEmpty(T t) {
		if (t == null) {
			return true;
		} else {
			Class<? extends Object> clz = t.getClass();
			if (t instanceof CharSequence) {
				CharSequence charSequence = (CharSequence) t;
				return charSequence.length() == 0;
			} else if (t instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) t;
				return map.isEmpty();
			} else if (t instanceof Collection) {
				Collection<?> collection = (Collection<?>) t;
				return collection.isEmpty();
			} else if (clz.isArray()) {
				Class<?> componentType = t.getClass().getComponentType();
				if (componentType.isPrimitive()) {
					if (componentType == int.class) {
						int[] array = (int[]) t;
						return array.length == 0;
					} else if (componentType == float.class) {
						float[] array = (float[]) t;
						return array.length == 0;
					} else if (componentType == long.class) {
						long[] array = (long[]) t;
						return array.length == 0;
					} else if (componentType == double.class) {
						double[] array = (double[]) t;
						return array.length == 0;
					} else if (componentType == byte.class) {
						byte[] array = (byte[]) t;
						return array.length == 0;
					} else if (componentType == short.class) {
						short[] array = (short[]) t;
						return array.length == 0;
					} else if (componentType == char.class) {
						char[] array = (char[]) t;
						return array.length == 0;
					} else if (componentType == boolean.class) {
						boolean[] array = (boolean[]) t;
						return array.length == 0;
					}
				} else {
					List<T> asList = Arrays.asList(t);
					return asList.isEmpty();
				}
			}
		}
		return false;
	}

}
