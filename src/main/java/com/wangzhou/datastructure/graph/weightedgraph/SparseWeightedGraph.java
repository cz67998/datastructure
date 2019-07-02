package com.wangzhou.datastructure.graph.weightedgraph;

import java.util.Vector;

/**
 * 稀疏稠密
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/23
 * Time:14:13
 **/
public class SparseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {
    private int n;//节点数
    private int m; //边数

    private boolean directed;//是否为有向图
    private Vector<Edge<Weight>>[] g; //图的具体数据

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n =n;
        this.m = 0; //初始化没有任何边
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.V() >= 0 && e.V() < n;
        assert e.W() >= 0 && e.W() < n;
        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现
        g[e.V()].add(new Edge(e));
        if (e.V() != e.W() && !directed) {
            g[e.W()].add(new Edge(e.W(), e.V(), e.wt()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int i1 = 0; i1 < g[i].size(); i1++) {
                Edge e = g[i].elementAt(i1);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> iterable(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
