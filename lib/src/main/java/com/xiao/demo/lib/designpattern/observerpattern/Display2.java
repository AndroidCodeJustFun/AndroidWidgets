package com.xiao.demo.lib.designpattern.observerpattern;

import java.util.Observable;

/**
 * FileName:com.example.designpattern.observerpattern.Display2.java
 * Created on 2016/9/4
 * Version V1.0
 */
public class Display2 implements MyObserver, DiaplayElement, java.util.Observer {

	private static final String TAG = "Display2";

	private int temparature;

	private int humidity;

	private int pressure;

	private Subject subject;

	private Observable observable;

	public Display2(DataBean observable) {
		this.observable = observable;
		this.observable.addObserver(this);
//        this.subject = observable;
//        this.subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println(TAG + " temparature is " + this.temparature + " humidity is " + this.humidity + " pressure is " + this.pressure);
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
