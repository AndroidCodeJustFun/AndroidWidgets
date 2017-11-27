package com.xiao.demo.lib.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.Observable;

/**
 * FileName:com.example.designpattern.observerpattern.DataBean.java
 * Created on 2016/9/4
 * Version V1.0
 */
public class DataBean extends Observable implements Subject {

    private ArrayList<MyObserver> list;

    private int temparature;

    private int humidity;

    private int pressure;

    public DataBean(ArrayList<MyObserver> list, int data1, int data2, int data3) {
        this.list = list;
        this.temparature = data1;
        this.humidity = data2;
        this.pressure = data3;
    }

    public DataBean() {
    }

    public ArrayList<MyObserver> getList() {
        return list;
    }

    public void setList(ArrayList<MyObserver> list) {
        this.list = list;
    }

    public int getTemparature() {
        return temparature;
    }

    public void setTemparature(int temparature) {
        this.temparature = temparature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void dataChanged(int data1, int data2, int data3) {
        this.temparature = data1;
        this.humidity = data2;
        this.pressure = data3;
        measurementsChanged();
    }

    private void measurementsChanged() {
        setChanged();
        notifyObservers();
        notifyDataChanged();
    }

    @Override
    public void registerObserver(MyObserver o) {
        if (list == null) list = new ArrayList<>();
        System.out.println("registerObserver o.getClass = " + o.getClass());
        list.add(o);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("registerObserver list.get(" + i + ").getClass = " + list.get(i).getClass());
        }
    }

    @Override
    public void unRegisterObserver(MyObserver o) {
        list.remove(o);
    }

    @Override
    public void notifyDataChanged() {
        if (list != null && !list.isEmpty())
            for (MyObserver myObserver : list) {
                System.out.println("notifyDataChanged myObserver.getClass = " + myObserver.getClass());
                myObserver.update(temparature, humidity, pressure);
            }
    }
}
