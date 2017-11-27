package com.xiao.demo.lib.designpattern.decoratorpattern;

/**
 * FileName:com.example.designpattern.decoratorpattern.Beverage.java
 * Created on 2016/9/5
 * Version V1.0
 */
public abstract  class Beverage {

    String description = "Unknown Beverage";

    public enum Capacity{
        SMALL,
        MIDDLE,
        LARGE;
    }

    int size;

    public String getDescription() {
        return description;
    }

    public abstract  double cost();

    public int getSize() {
        return size;
    }

    public void setSize(Capacity capacity) {
        this.size = capacity.ordinal();
    }
}
