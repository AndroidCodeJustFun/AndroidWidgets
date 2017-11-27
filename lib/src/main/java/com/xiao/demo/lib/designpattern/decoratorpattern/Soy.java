package com.xiao.demo.lib.designpattern.decoratorpattern;

/**
 * FileName:com.example.designpattern.decoratorpattern.Soy.java
 * Created on 2016/9/6
 * Version V1.0
 */
public class Soy extends ComponentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public int getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {

        double cost = beverage.cost();
        int size = getSize();
        if (size == Capacity.SMALL.ordinal()) {
            cost += 0.1;
        } else if (size == Capacity.SMALL.ordinal()) {
            cost += 0.2;
        } else {
            cost += 0.3;
        }
        return 0.5 + cost;
    }
}
