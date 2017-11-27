package com.xiao.demo.lib.designpattern.factorypattern;

/**
 * FileName:com.example.designpattern.factorypattern.PizzaStore.java
 * Created on 2016/9/8
 * Version V1.0
 */
public abstract class PizzaStore {

    private Pizza orderPizza(int type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(int type);

}
