package com.xiao.demo.util;

import java.util.concurrent.ExecutionException;

/**
 * Created by xiao on 2017/10/14.
 */

public class AsyncProcessImpl<T> implements AsyncProcess<T> {

//	@Override
//	public AsyncResult<T> startProcess(Callable<T> callable) throws Exception {
//		AsyncResultImpl<T> asyncResult = new AsyncResultImpl<>();
//		new Thread() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(1500);
//					System.out.println("run.[] sleep for another 1500 ms");
//					asyncResult.setResult(callable.call());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}.start();
//		System.out.println("startProcess.[callable]  " + asyncResult.getResult());
//		return asyncResult;
//	}

	@Override
	public AsyncResult<T> startProcess() throws Exception {
		return null;
	}

	@Override
	public T endProcess(AsyncResult<T> asyncResult) throws InterruptedException, ExecutionException {
		System.out.println("endProcess.[asyncResult]  " + asyncResult.isComplete() + "  " + asyncResult.getResult());
		if (!asyncResult.isComplete())
			asyncResult.waitUtilFinish();
		return asyncResult.getResult();
	}
}
