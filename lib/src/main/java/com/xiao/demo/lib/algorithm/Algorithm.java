package com.xiao.demo.lib.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Java  算法学习
 * Created by xiao on 2017/10/3.
 */

public class Algorithm {


    public static void main(String[] args) {
        //		Cycle.forCycle();
        //		crossList();
        //		fibonacci();
        numSort();
    }

    public static void crossList() {
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{2, 4, 6};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i * 2] = a[i];
            c[i * 2 + 1] = b[i];
        }
        for (int i = 0; i < c.length; i++) {
            System.out.printf(" " + c[i]);
        }
    }

    public static void fibonacci() {
        List<Long> list = new ArrayList<>(100);
        list.add(0l);
        list.add(1l);
        for (int i = 2; i < 100; i++) {
            Long s = list.get(i - 1) + list.get(i - 2);
            list.add(i, s);
        }
        System.out.println("fibonacci " + list);
    }

    public static void numSort() {
        List<Integer> source = new ArrayList<>(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            source.add(random.nextInt(10) * 10 + 1);
        }
        System.out.println("numSort.[ " + source);
        source.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i1 = o1 / 10;
                if (i1 == 0) i1 = o1;
                int i2 = o2 / 10;
                if (i2 == 0) i2 = o2;
                if (i1 > i2) return -1;
                else if (i1 < i2) return 1;
                else {
                    if (o1 > o2) return -1;
                    else if (o1 < o2) return 1;
                }
                return 0;
            }
        });
        int len = 0;
        for (int i = 0; i < source.size(); i++) {
            len += source.get(i) / 10 > 0 ? 2 : 1;
        }
        System.out.println("numSort.[] " + source + "  " + len);
        long sum = 0;
        sum = sort(source, sum, len);
        System.out.println("numSort.[]  " + sum);
    }

    public static long sort(List<Integer> list, long sum, int len) {
        if (list.isEmpty()) return sum;
        Integer integer = list.get(0);
        int i = integer / 10 > 0 ? 2 : 1;
        sum += integer * (Math.pow(10, len - (i)));
        list.remove(0);
        len -= i;
        if (!list.isEmpty()) {
            sum = sort(list, sum, len);
        }
        return sum;
    }


}
