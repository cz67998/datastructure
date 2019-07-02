package com.wangzhou.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/23
 * Time:10:34
 **/
public class ShortestPath {
    private Graph G;//图的引用
    private int s;//起始点
    private boolean[] visited;//记录dfs的过程中节点是否被访问
    private int[] from;//记录路径，from[i]表示查找路劲上i的一个节点
    private int[] ord;//记录路径中节点的次序，ord[i]表示i节点在路径中的次序

    //构造函数
    public ShortestPath(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    /**
     * 广度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        ord[v] = 0;
        while (!queue.isEmpty()) {
            int s = queue.remove();
            for (int i : G.iterable(s)) {
                if(!visited[i]){
                queue.add(i);
                visited[i] = true;
                ord[i] = ord[s] + 1;
                from[i] = s;}
            }
        }

    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    /**
     * 查询从s点到w点的路径, 存放在vec中
     *
     * @return
     */
    public Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> stack=new Stack<>();
        int p=w;
        while (p!=-1){
            stack.add(p);
            p=from[p];
        }
        Vector<Integer> vector=new Vector<>();
        while (!stack.isEmpty()){
            vector.add(stack.pop());
        }

        return vector;
    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vector=path(w);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.elementAt(i));
            if(i==vector.size()-1){
                System.out.println();
            }else {
                System.out.print(" -> ");
            }
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }
    public static void main(String[] args){
        String  filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        ShortestPath path = new ShortestPath(g,5);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);

    }
}
