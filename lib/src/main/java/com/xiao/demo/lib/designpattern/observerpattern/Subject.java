package com.xiao.demo.lib.designpattern.observerpattern;

/**
 * FileName:com.example.designpattern.observerpattern.Subject.java
 * Created on 2016/9/4
 * Version V1.0
 */
public interface Subject {

    public void registerObserver(MyObserver o);

    public void unRegisterObserver(MyObserver o);

    public void notifyDataChanged();

}
