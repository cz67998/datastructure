package com.wangzhou.datastructure.graph.weightedgraph;

import com.wangzhou.datastructure.unionfind.TreeUnionFindPathCompressionRecur;

import java.util.Vector;

/**
 * // Kruskal算法求最小生成树
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/24
 * Time:13:51
 **/
public class KruskalMST<Weight extends Number & Comparable> {
    private Vector<Edge<Weight>> mst; //最小生成树包含的所有边
    private Number mstWeight; //最小生成树的权值

    public KruskalMST(WeightedGraph graph) {
        mst = new Vector<>();
        //将图中所有边存放到一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.iterable(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                if (e.V() <= e.W()) {
                    pq.insert(e);
                }
            }
        }
        //创建一个并查集
        TreeUnionFindPathCompressionRecur uf = new TreeUnionFindPathCompressionRecur(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            //从最小堆中依次从小到大取出所有的边
            Edge<Weight> e = pq.extractMin();
            if (uf.isConnected(e.V(), e.W())) {
                continue;
            }
            mst.add(e);
            uf.unionElements(e.V(), e.W());
        }
        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
    }
    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    }
    public static void main(String[] args){
        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\graph\\weightedgraph\\testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        KruskalMST<Double> lazyPrimMST = new KruskalMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();

    }
}
