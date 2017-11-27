package com.xiao.demo.lib.designpattern.decoratorpattern;

/**
 * FileName:com.example.designpattern.decoratorpattern.DarkToast.java
 * Created on 2016/9/5
 * Version V1.0
 */
public class DarkToast extends Beverage {

    public DarkToast() {
        description = "DarkToast";
    }

    @Override
    public double cost() {
        return 1.9;
    }
}
