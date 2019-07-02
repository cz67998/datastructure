package com.wangzhou.datastructure.graph.weightedgraph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/24
 * Time:17:06
 **/
public class Son2 extends Father {
    @Override
    public void hasSon() {
        System.out.println("son 2");
    }
    public static void main(String[] args){
      Son1 son1=new Son1();
      Son2 son2=(Son2) (Father)son1;
      son2.hasSon();
    }
}
