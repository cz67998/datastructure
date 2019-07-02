package com.wangzhou.datastructure.iterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:11:00
 **/
public class Test {
    private List list;

    public Test(int n) {
        list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    public Iterable<Integer> iterable() {
        return list;
    }


    public static void main(String[] args) {
        Test test = new Test(10);
        for (int i : test.iterable()) {
            System.out.print(i);
        }
    }
}
