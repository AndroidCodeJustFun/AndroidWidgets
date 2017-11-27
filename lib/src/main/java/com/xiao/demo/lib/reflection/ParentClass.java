package com.xiao.demo.lib.reflection;

/**
 * Created by xiao on 2017/8/26.
 */

public class ParentClass<T> {

    T t;

    public ParentClass() {
    }

    public ParentClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
