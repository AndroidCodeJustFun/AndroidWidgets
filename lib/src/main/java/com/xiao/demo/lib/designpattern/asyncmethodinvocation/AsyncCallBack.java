package com.xiao.demo.lib.designpattern.asyncmethodinvocation;

import java.util.Optional;

/**
 * Created by xiao on 2017/10/14.
 */

public interface AsyncCallBack<T> {

	void onSuccess(T t);

	void onFailure(Exception ex);

}
