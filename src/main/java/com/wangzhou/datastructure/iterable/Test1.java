package com.wangzhou.datastructure.iterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:11:00
 **/
public class Test1 {
    private int[] ints;

    public Test1(int n) {
        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
    }

    public Iterable<Integer> iterable() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        return list;
    }


    public static void main(String[] args) {
        Test1 test = new Test1(10);
        for (int i : test.iterable()) {
            System.out.print(i);
        }

        int[]  ints = new int[10];
        for (int i:ints){
            System.out.print(i);
        }
    }
}
