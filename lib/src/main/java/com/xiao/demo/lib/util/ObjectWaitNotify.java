package com.xiao.demo.lib.util;

/**
 * Created by xiao on 2017/10/14.
 */

public class ObjectWaitNotify {


	public static void main(String[] args) {
		try {
			System.out.println("main.[args]" + test());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static Callback callback;

	public static int test() throws InterruptedException {
		Object obj = new Object();
		callback = new Callback() {
			int result;
			@Override
			public void onComplete(int result) {
				System.out.println("onComplete.[result] " + result);
				this.result = result;
				synchronized (obj) {
					obj.notifyAll();
				}
			}

			@Override
			public int getResult() {
				return result;
			}
		};

		new Thread() {
			@Override
			public void run() {
				for (int i = 50; i >= 0; i--) {
					if (i == 25) {
						callback.onComplete(i);
					}
				}
			}
		}.start();
		System.out.println("test.[] end ");
		if (callback.getResult() == 0)
			synchronized (obj) {
				obj.wait();
			}
		return callback.getResult();
	}

	interface Callback {
		void onComplete(int result);

		int getResult();


	}

}
