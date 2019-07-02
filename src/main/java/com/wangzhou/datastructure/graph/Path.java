package com.wangzhou.datastructure.graph;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:16:32
 **/
public class Path {
    private Graph G;//图的引用
    private int s; //起始点
    private boolean[] visited; //记录dfs中的节点是否被访问
    private int[] from; //记录路径oin,from[i]表示查找路径上i的上一个节点\

    //构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public Path(Graph graph, int s) {
        //算法初始化
        G = graph;
        assert s >= 0 && s < G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.iterable(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    /**
     * 查询从s点到w点是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }
    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w){
        assert hasPath(w);
        Stack<Integer> stack=new Stack<Integer>();
        int p=w;
        //通过from数组逆向查找从s到w的路径，存放到栈中
        while(p!=-1){
            stack.push(p);
            p=from[p];
        }
        Vector<Integer> res=new Vector<>();
        while( !stack.empty() )
            res.add( stack.pop() );

        return res;
    }
    //打印出从s点到w点的路径
    public void showPath(int w){
        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
