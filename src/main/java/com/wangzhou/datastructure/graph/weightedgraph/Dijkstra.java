package com.wangzhou.datastructure.graph.weightedgraph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/24
 * Time:16:09
 **/
// Dijkstra算法求最短路径
public class Dijkstra<Weight extends Number & Comparable> {
    private WeightedGraph G;//图的引用
    private int s; //起始点
    private Number[] distTo;// distTo[i]存储从起始点s到i的最短路径长度
    private boolean[] marked;//标记数组, 在算法运行过程中标记节点i是否被访问
    private Edge<Weight>[] from;//from[i]记录最短路径中, 到达i点的边是哪一条// 可以用来恢复整个最短路径

    public Dijkstra(WeightedGraph graph, int s) {
        //算法初始化
        G = graph;
        assert s >= 0 && s < G.V();
        this.s = s;
        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        from = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = 0.0;
            marked[i] = false;
            from[i] = null;
        }
        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());
        // 对于其实点s进行初始化
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight) (Number) (0.0));
        ipq.insert(s, (Weight) distTo[s]);
        marked[s] = true;
        //对v的所有相邻节点更新
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            //distTo[v]就是s到v的最短距离
            marked[v] = true;
            for (Object item : G.iterable(v)) {
                Edge<Weight> e = (Edge<Weight>) item;
                int w = e.other(v);
                // 如果从s点到w点的最短路径还没有找到
                if (!marked[w]) {
                    // 如果w点以前没有访问过,
                    // 或者访问过, 但是通过当前的v点到w点距离更短, 则进行更新
                    if (from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        from[w] = e;
                        if (ipq.contain(w))
                            ipq.change(w, (Weight) distTo[w]);
                        else
                            ipq.insert(w, (Weight) distTo[w]);
                    }
                }
            }
        }
    }

    // 返回从s点到w点的最短路径长度
    Number shortestPathTo(int w) {
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    // 判断从s点到w点是否联通
    boolean hasPathTo(int w) {
        assert w >= 0 && w < G.V();
        return marked[w];
    }

    Vector<Edge<Weight>> shortestPath(int w) {
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Weight>> s = new Stack<Edge<Weight>>();
        Edge<Weight> e = from[w];
        while (e.V() != this.s) {
            s.push(e);
            e = from[e.V()];
        }
        s.push(e);
        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Edge<Weight>> res = new Vector<Edge<Weight>>();
        while( !s.empty() ){
            e = s.pop();
            res.add( e );
        }

        return res;
    }
    // 打印出从s点到w点的路径
    void showPath(int w){

        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        Vector<Edge<Weight>> path =  shortestPath(w);
        for( int i = 0 ; i < path.size() ; i ++ ){
            System.out.print( path.elementAt(i).V() + " -> ");
            if( i == path.size()-1 )
                System.out.println(path.elementAt(i).W());
        }
    }
//    public static void main(String[] args) {
////        Integer i = (Integer) (Number) 0.0;
////        System.out.println(i);
//        int[] ints = new int[]{1, 9, 4, 6, 2, 5};
//        int i=0;
//        int a = ints[i];
//        while (a!=4&&i<ints.length-1){
//            System.out.println(a);
//            a=ints[i++];
//        }
//        System.out.println(a);
//
//    }
    // 测试我们的Dijkstra最短路径算法
    public static void main(String[] args) {

        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\weightedgraph\\testG5.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(g,0);
        for( int i = 1 ; i < V ; i ++ ){
            if(dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }

    }
}
