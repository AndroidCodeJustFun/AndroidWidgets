package com.xiao.demo.util;

import java.util.concurrent.ExecutionException;

/**
 * Created by xiao on 2017/10/14.
 */

public interface AsyncResult<T> {

	int RUNNING = 1;

	int COMPLETED = 2;

	int FAILED = 3;

	void setResult(T t);

	T getResult() throws ExecutionException;

	void failed(String reason);

	void setException(Exception exception);

	boolean isComplete();

	void waitUtilFinish() throws InterruptedException;

}
