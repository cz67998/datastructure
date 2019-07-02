package com.wangzhou.datastructure.graph.weightedgraph;

import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/23
 * Time:15:02
 **/
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否为有向图
    private Edge<Weight>[][] g; //图的具体数据

    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0; //初始化没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为null, 表示没有任和边
        // false为boolean型变量的默认值
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                g[i][i1] = null;
            }
        }
    }

    //节点数
    @Override
    public int V() {
        return n;
    }

    //边数
    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.V() >= 0 && e.V() < n;
        assert e.W() >= 0 && e.W() < n;

        if (hasEdge(e.V(), e.W()))
            return;
        g[e.V()][e.W()] = new Edge<>(e);
        if (e.V() != e.W() && !directed) {
            g[e.W()][e.V()] = new Edge(e.W(), e.V(), e.wt());
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (g[i][j] != null)
                    System.out.print(g[i][j].wt() + "\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> iterable(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
        for (int i = 0; i < n; i++)
            if (g[v][i] != null)
                adjV.add(g[v][i]);
        return adjV;
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
