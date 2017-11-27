package com.xiao.demo.lib.designpattern.asyncmethodinvocation;

import java.util.concurrent.ExecutionException;


/**
 * Created by xiao on 2017/10/14.
 */

public class AsyncResultImpl<T> implements AsyncResult<T> {

	public static final String TAG = "AsyncResultImpl";

	volatile int state = RUNNING;

	private Object lock;

	private T t;

	private Exception exception;


	private AsyncCallBack<T> callBack;

	public AsyncResultImpl() {
		this.lock = new Object();
	}

	public AsyncResultImpl(AsyncCallBack<T> ac) {
		this.lock = new Object();
		this.callBack = ac;
	}

	@Override
	public void setResult(T t) {
		this.t = t;
		System.out.println(TAG + ".setResult.[t] = " + t);
		state = COMPLETED;
		if (callBack != null) {
			callBack.onSuccess(t);
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	@Override
	public T getResult() throws ExecutionException {
		if (state == COMPLETED)
			return t;
		else if (state == FAILED) throw new ExecutionException(exception);
		else throw new IllegalStateException("task not finished yet");
	}

	@Override
	public void failed(String reason) {
		state = FAILED;
		System.out.println("failed.[reason] " + reason);
	}

	@Override
	public void setException(Exception exception) {
		this.exception = exception;
		state = FAILED;
		if (callBack != null) {
			callBack.onFailure(exception);
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	@Override
	public boolean isComplete() {
		System.out.println(TAG + ".isComplete.[] t = " + t + "  state = " + state);
		return state > RUNNING;
	}

	@Override
	public void waitUtilFinish() throws InterruptedException {
		System.out.println(TAG + "waitUtilFinish.[]");
		synchronized (lock) {
			if (!isComplete())
				lock.wait();
		}
	}
}
