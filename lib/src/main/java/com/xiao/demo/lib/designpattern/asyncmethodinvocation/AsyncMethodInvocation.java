package com.xiao.demo.lib.designpattern.asyncmethodinvocation;

/**
 * Created by xiao on 2017/10/14.
 */

public class AsyncMethodInvocation {


	public static void main(String[] args) {

		long start1 = System.currentTimeMillis(), start = System.currentTimeMillis();
		AsyncCacheUtil util = new AsyncCacheUtil.Builder().setFileUrl("http://bj.bcebos.com/v1/ddoctor-image-shop/1477302197.jpg").setFileName(System.currentTimeMillis() + ".jpg").setSavePath("/Users/xiao/Desktop/").build();
		System.out.println("main.[args] after buld " + (System.currentTimeMillis() - start));
		try {
			start = System.currentTimeMillis();
			AsyncResult<String> asyncResult = util.startProcess();
			System.out.println("main.[args]  after start " + (System.currentTimeMillis() - start));
			start = System.currentTimeMillis();
			System.out.println("main.[args]" + util.endProcess(asyncResult));
			System.out.println("main.[args] finished  " + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main.[args] testttt");
		System.out.println("main.[args] " + (System.currentTimeMillis() - start1));

	}


}
