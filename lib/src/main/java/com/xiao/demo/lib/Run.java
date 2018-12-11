package com.xiao.demo.lib;

import com.xiao.demo.lib.util.DownloadUtil;

/**
 * Created by xiao on 2017/10/13.
 */

public class Run {

	public static void main(String[] args) {
//		ss(new DownloadUtil.OnDownLoadFinishedListener() {
//			String path;
//
//			@Override
//			public String getPath() {
//				return path;
//			}
//
//			@Override
//			public void onComplete(String filePath) {
//				path = filePath;
//			}
//		});
		Integer a1 = 126;
		Integer a2 = 126;
		Integer a3 = 128;
		Integer a4 = 128;

		System.out.println("main.[args] 126.equals126" + (a1.equals(a2)));
		System.out.println("main.[args] 126.==126" + (a1 == a2));
		System.out.println("main.[args] 128.equals128" + (a3.equals(a4)));
		System.out.println("main.[args] 128==128" + (a3 == a4));

		String s = "a";
		String s1 = "a";
		String s2 = "a" + "b";
		String s3 = "ab";
		System.out.println("main.[args] " + s + " == " + s1 + " " + (s == s1));
		System.out.println("main.[args] " + s + " eauals " + s1 + " " + (s.equals(s1)));
		System.out.println("main.[args] " + s2 + " == " + s3 + " " + (s2 == s3));
		System.out.println("main.[args] " + s2 + " eauals " + s3 + " " + (s2.equals(s3)));


	}


	public static String ss(DownloadUtil.OnDownLoadFinishedListener listener) {
		String s = new DownloadUtil.Builder().setFileUrl("http://bj.bcebos.com/v1/ddoctor-image-shop/1477302197.jpg").setFileName(System.currentTimeMillis() + ".jpg").setSavePath("/Users/xiao/Desktop/").setOnDownLoadFinishedListener(listener).build().startDownLoad();
		System.out.println("ss.[listener] s = " + s);
		return listener.getPath();
	}

}
