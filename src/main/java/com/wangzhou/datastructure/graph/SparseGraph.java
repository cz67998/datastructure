package com.wangzhou.datastructure.graph;

import java.util.Vector;

/**
 * 稀疏图  邻接表
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:8:48
 **/
public class SparseGraph implements Graph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否为有向图
    private Vector<Integer>[] g;//图的具体数值

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;  //初始化没有任何边
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int V() {
        return n;
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int E() {
        return m;
    }

    /**
     * 向图中添加一个边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed)
            g[w].add(v);

        m++;
    }

    /**
     * 验证图中是否有从v到w的边
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && m < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++)
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }


    /**
     * // 返回图中一个顶点的所有邻边
     * // 由于java使用引用机制，返回一个Vector不会带来额外开销,
     *
     * @param v
     * @return
     */
    public Iterable<Integer> iterable(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    public static void main(String[] args) {
        SparseGraph sparseGraph = new SparseGraph(10, false);
        sparseGraph.addEdge(1, 2);
        sparseGraph.addEdge(1, 3);
        System.out.println(sparseGraph.iterable(1));
        System.out.println(sparseGraph.iterable(2));
        System.out.println(sparseGraph.iterable(3));
        System.out.println(sparseGraph.iterable(4));
        for (int i : sparseGraph.iterable(1)) {
            System.out.println(i);
        }
    }
}
