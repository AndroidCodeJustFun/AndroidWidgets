package com.xiao.demo.lib.reflection;

/**
 * Created by xiao on 2017/8/26.
 */

public class Ple implements ReflectInterface {

    private String country;

    public Ple() {
    }

    public Ple(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Ple{" +
                "country='" + country + '\'' +
                '}';
    }

    @Override
    public void reflectVoidMethods() {
        System.out.println("Ple.reflectVoidMethods is Called");
    }

    @Override
    public String reflectStringMethods() {
        return "Ple.reflectStringMethods is Called";
    }
}
