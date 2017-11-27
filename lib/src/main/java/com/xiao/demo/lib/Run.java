package com.xiao.demo.lib;

import com.xiao.demo.lib.util.DownloadUtil;

/**
 * Created by xiao on 2017/10/13.
 */

public class Run {

	public static void main(String[] args) {
		ss(new DownloadUtil.OnDownLoadFinishedListener() {
			String path;

			@Override
			public String getPath() {
				return path;
			}

			@Override
			public void onComplete(String filePath) {
				path = filePath;
			}
		});
	}


	public static String ss(DownloadUtil.OnDownLoadFinishedListener listener) {
		String s = new DownloadUtil.Builder().setFileUrl("http://bj.bcebos.com/v1/ddoctor-image-shop/1477302197.jpg").setFileName(System.currentTimeMillis() + ".jpg").setSavePath("/Users/xiao/Desktop/").setOnDownLoadFinishedListener(listener).build().startDownLoad();
		System.out.println("ss.[listener] s = " + s);
		return listener.getPath();
	}

}
