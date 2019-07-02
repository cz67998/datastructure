package com.wangzhou.datastructure.graph;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:14:15
 **/
public interface Graph {
    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> iterable(int v);
}
