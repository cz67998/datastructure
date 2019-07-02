package com.wangzhou.datastructure.graph.weightedgraph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/23
 * Time:13:04
 **/
public interface WeightedGraph<Weight extends Number&Comparable> {
public int V();
public int E();
public void addEdge(Edge<Weight> e);
public boolean hasEdge(int v,int w);
void show();
public Iterable<Edge<Weight>> iterable(int v);
}
