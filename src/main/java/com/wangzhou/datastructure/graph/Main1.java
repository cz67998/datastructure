package com.wangzhou.datastructure.graph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:14:40
 **/
public class Main1 {
    public static void main(String[] args){
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        g1.show();

        System.out.println();

        filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g2, filename);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

        System.out.println();


    }
}
