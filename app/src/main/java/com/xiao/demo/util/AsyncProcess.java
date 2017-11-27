package com.xiao.demo.util;

import java.util.concurrent.ExecutionException;

/**
 * Created by xiao on 2017/10/14.
 */

public interface AsyncProcess<T> {

	AsyncResult<T> startProcess() throws Exception;

	T endProcess(AsyncResult<T> asyncResult) throws InterruptedException, ExecutionException;

}
