package com.xiao.demo.util;

/**
 * Created by xiao on 2017/10/14.
 */

public interface AsyncCallBack<T> {

	void onSuccess(T t);

	void onFailure(Exception ex);

}
