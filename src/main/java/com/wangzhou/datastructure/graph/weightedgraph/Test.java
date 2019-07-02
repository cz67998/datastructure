package com.wangzhou.datastructure.graph.weightedgraph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/24
 * Time:17:12
 **/
public class Test<V extends Number & Comparable> {
    private V v;

    public Test() {
        Double s = 0.0;
        v = (V) (Number) s;
    }

    public static void main(String[] args) {
        Test T = new Test();
        System.out.println(T.v);
    }
}