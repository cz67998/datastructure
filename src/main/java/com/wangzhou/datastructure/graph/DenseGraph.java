package com.wangzhou.datastructure.graph;

import java.util.Vector;

/**
 * 稠密图  邻接矩阵
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:8:48
 **/
public class DenseGraph implements Graph {
    private int n;//节点数
    private int m;//边数
    private boolean directed; //是否为有向图
    private boolean[][] g;//图的具体数据

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;//初始化没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
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
     * 加边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, m)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
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
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    /**
     * 返回图中一个顶点的所有邻边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销,
     *
     * @param v
     * @return
     */
    public Iterable<Integer> iterable(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i++)
            if (g[v][i])
                adjV.add(i);
        return adjV;
    }


}
