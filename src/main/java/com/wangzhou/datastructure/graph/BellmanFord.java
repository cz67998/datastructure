package com.wangzhou.datastructure.graph;

import com.wangzhou.datastructure.graph.weightedgraph.Edge;
import com.wangzhou.datastructure.graph.weightedgraph.ReadWeightedGraph;
import com.wangzhou.datastructure.graph.weightedgraph.SparseWeightedGraph;
import com.wangzhou.datastructure.graph.weightedgraph.WeightedGraph;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/27
 * Time:16:01
 **/
// 使用BellmanFord算法求最短路径
public class BellmanFord<Weight extends Number & Comparable> {
    private WeightedGraph G;    // 图的引用
    private int s;              // 起始点
    private Number[] distTo;    // distTo[i]存储从起始点s到i的最短路径长度
    Edge<Weight>[] from;        // from[i]记录最短路径中, 到达i点的边是哪一条
    // 可以用来恢复整个最短路径
    boolean hasNegativeCycle;   // 标记图中是否有负权环

    // 构造函数, 使用BellmanFord算法求最短路径
    public BellmanFord(WeightedGraph graph, int s) {
        G = graph;
        this.s = s;
        distTo = new Number[G.V()];
        from = new Edge[G.V()];
        // 初始化所有的节点s都不可达, 由from数组来表示
        for (int i = 0; i < G.V(); i++)
            from[i] = null;
        //初始化所有的节点s都不可达,有from数组来表示
        // 设置distTo[s] = 0, 并且让from[s]不为NULL, 表示初始s节点可达且距离为0
        distTo[s] = 0.0;
        from[s] = new Edge<Weight>(s, s, (Weight) (Number) 0.0);
        //Bellman-Ford的过程
        //进行v-1次循环
        for (int pass = 1; pass < G.V(); pass++) {
            //每次循环对所有的边进行一遍松弛操作
            //遍历所有边的方式是先遍历所有的顶点, 然后遍历和所有顶点相邻的所有边
            for (int i = 0; i < G.V(); i++) {
                for (Object item : G.iterable(i)) {
                    Edge<Weight> e = (Edge<Weight>) item;
                    // 对于每一个边首先判断e->v()可达
                    // 之后看如果e->w()以前没有到达过， 显然我们可以更新distTo[e->w()]
                    // 或者e->w()以前虽然到达过, 但是通过这个e我们可以获得一个更短的距离, 即可以进行一次松弛操作,
                    // 我们也可以更新distTo[e->w()]
                    if (from[e.V()] != null &&
                            (from[e.W()] == null || distTo[e.V()].doubleValue() + e.wt().doubleValue() <
                                    distTo[e.W()].doubleValue())) {
                        distTo[e.W()] = distTo[e.V()].doubleValue() + e.wt().doubleValue();
                        from[e.W()] = e;
                    }
                }
            }
        }
        hasNegativeCycle = detectNegativeCycle();
    }
    // 判断图中是否有负权环
    boolean detectNegativeCycle(){
        for (int i = 0; i < G.V(); i++) {
            for(Object item:G.iterable(i)){
                Edge<Weight> e=(Edge<Weight>) item;
                if(from[e.V()]!=null&&distTo[e.V()].doubleValue()+e.wt().doubleValue()<distTo[e.W()].doubleValue()){
                   return true;
                }
            }
        }
        return false;
    }
    // 返回图中是否有负权环
    boolean negativeCycle() {
        return hasNegativeCycle;
    }

    // 返回从s点到w点的最短路径长度
    Number shortestPathTo(int w) {
        assert w >= 0 && w < G.V();
        assert !hasNegativeCycle;
        assert hasPathTo(w);
        return distTo[w];
    }

    // 判断从s点到w点是否联通
    boolean hasPathTo(int w) {
        assert (w >= 0 && w < G.V());
        return from[w] != null;
    }

    // 寻找从s到w的最短路径, 将整个路径经过的边存放在vec中
    Vector<Edge<Weight>> shortestPath(int w) {

        assert w >= 0 && w < G.V();
        assert !hasNegativeCycle;
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
        while (!s.empty()) {
            e = s.pop();
            res.add(e);
        }

        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w) {

        assert (w >= 0 && w < G.V());
        assert (!hasNegativeCycle);
        assert (hasPathTo(w));

        Vector<Edge<Weight>> res = shortestPath(w);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.elementAt(i).V() + " -> ");
            if (i == res.size() - 1)
                System.out.println(res.elementAt(i).W());
        }
    }

    public static void main(String[] args) {
        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\weightedgraph\\testG6.txt";
        //String filename = "testG_negative_circle.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g, s);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 0 ; i < V ; i ++ ){
                if(i == s)
                    continue;

                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

                System.out.println("----------");
            }

//        System.out.println(1054 + 258 + 8435 + 973 + 2120 + 6109 + 2722 + 1196 + 4315 + 10919 + 8988 + 3763 + 8000);
    }
}
