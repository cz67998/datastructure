package com.wangzhou.datastructure.graph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:14:40
 **/
public class Main2 {
    public static void main(String[] args){


        String  filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);


        ShortestPath path1 = new ShortestPath(g,0);
        System.out.println("ShortestPath from 0 to 6 : ");
        path1.showPath(6);

    }
}
