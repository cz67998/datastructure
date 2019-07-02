package com.wangzhou.datastructure.graph;

/**
 * 求无权图的联通分量
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:15:00
 **/
public class Components {
    Graph G; //图的引用
    private boolean[] visited;//记录dfs的过程中的节点是否被访问
    private int ccount; //记录联通分量个数 ，一个图中不联通的数量
    private int[] id; //每个节点所对应的联通分量标记

    public Components(Graph graph) {
        G=graph;
        ccount=0;
        visited=new boolean[G.V()];
        id=new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i]=false;
            id[i]=-1;
        }
        for (int i = 0; i < G.V(); i++) {
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param v
     */
    public void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i : G.iterable(v)) {
            if (!visited[i]) dfs(i);
        }
    }

    //返回图的联通分量个数
    public int count() {
        return ccount;
    }

    /**
     * 查询点v和点w是否联通
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

}
