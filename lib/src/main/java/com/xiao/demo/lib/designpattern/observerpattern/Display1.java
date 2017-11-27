package com.xiao.demo.lib.designpattern.observerpattern;

import java.util.Observable;

/**
 * FileName:com.example.designpattern.observerpattern.Display1.java
 * Created on 2016/9/4
 * Version V1.0
 */
public class Display1 implements MyObserver, java.util.Observer, DiaplayElement {

    private static final String TAG = "Display1";

    private int temparature;

    private int humidity;

    private Subject subject;

    private Observable observable;

    public Display1() {
    }

    public Display1(DataBean dataBean) {
        this.observable = dataBean;
        this.observable.addObserver(this);
//        this.subject = dataBean;
//        this.subject.registerObserver(this);
    }

    @Override
    public void update(int data1, int data2, int data3) {
        this.temparature = data1;
        this.humidity = data2;
        display();
    }

    @Override
    public void display() {
        System.out.println(TAG + " Current conditions: " + temparature + " F degrees and " + humidity + " % humidity");
    }

    @Override
    public String toString() {
        return "Display1{" +
                "temparature=" + temparature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DataBean) {
            DataBean data = (DataBean) o;
            this.temparature = data.getTemparature();
            this.humidity = data.getHumidity();
            display();
        }
    }
}

