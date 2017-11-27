package com.xiao.demo.lib.designpattern.observerpattern;

import java.util.Observable;

/**
 * FileName:com.example.designpattern.observerpattern.Display3.java
 * Created on 2016/9/4
 * Version V1.0
 */
public class Display3 implements java.util.Observer, MyObserver, DiaplayElement {

    private static final String TAG = "Display3";

    private int temparature;

    private int humidity;

    private int pressure;

    private Subject subject;

    private Observable observable;

    public Display3(DataBean observable) {
        this.observable = observable;
        this.observable.addObserver(this);
//        this.subject = observable;
//        this.subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(TAG + " AVG " + this.temparature + "/" + this.humidity + "/" + this.pressure);
    }

    @Override
    public void update(Observable observable, Object obj) {
        if (observable instanceof DataBean) {
            DataBean data = (DataBean) observable;
            this.temparature = data.getTemparature();
            this.humidity = data.getHumidity();
            this.pressure = data.getPressure();
            display();
        }
    }

    @Override
    public void update(int data1, int data2, int data3) {
        this.temparature = data1;
        this.humidity = data2;
        this.pressure = data3;
        display();
    }
}

