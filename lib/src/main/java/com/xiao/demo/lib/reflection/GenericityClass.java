package com.xiao.demo.lib.reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiao on 2017/8/28.
 * Java  泛型 T K V ？ E
 */

public class GenericityClass {


    public static void main(String[] args) {

        TTest<String, String> tTest = new TTest<>();
        tTest.setT1("t1");
        tTest.setT2("12");
        System.out.println("main.[args] tTest = " + tTest);


        System.out.println("main.[args]  " + tTest.getT1().getClass() + "  " + tTest.getT2().getClass());

        List list = new ArrayList<TTest<String, String>>();
//        list.add("23");
        list.add(tTest);

        Map map = new HashMap();
        map.put("key1", "v1");
        map.put(2, "v2");


//        tTest.setT1(12);
//        tTest.setT2(12.5);
//
//        System.out.println("main.[args] tTest = " + tTest);
//        System.out.println("main.[args]  " + tTest.getT1().getClass() + "  " + tTest.getT2().getClass());

    }

    static class TTest<T1, E> {

        T1 t1;
        E t2;

        public TTest() {
        }

        public TTest(T1 t1, E t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public T1 getT1() {
            return t1;
        }

        public void setT1(T1 t1) {
            this.t1 = t1;
        }

        public E getT2() {
            return t2;
        }

        public void setT2(E t2) {
            this.t2 = t2;
        }

        @Override
        public String toString() {
            return "TTest{" +
                    "t1=" + t1 +
                    ", t2=" + t2 +
                    '}';
        }
    }


}
