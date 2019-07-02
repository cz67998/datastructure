package com.wangzhou.datastructure.graph.weightedgraph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/23
 * Time:15:20
 **/
public class Main {
    public static void main(String[] args) {
        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\weightedgraph\\testG1.txt";
        SparseWeightedGraph<Double> g1= new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();
        System.out.println();

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();
    }
}
