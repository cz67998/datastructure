package com.wangzhou.datastructure.graph.weightedgraph;

import java.util.Vector;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/24
 * Time:9:53
 **/
public class PrimMST<Weight extends Number & Comparable> {
    private WeightedGraph G; //图的引用
    private IndexMinHeap< Edge<Weight>> ipq;//最小索引堆，算法辅助数据结构
//    private Edge<Weight>[] edgeTo; //访问的点所有对应的边·，算法辅助数据结构
    private boolean[] marked; //标记数组, 在算法运行过程中标记节点i是否被访问
    private Vector<Edge<Weight>> mst; //最小生成树所包含的所有边
    private Number mstWeight; //最小生成树的权值

    // 构造函数, 使用Prim算法求图的最小生成树
    public PrimMST(WeightedGraph graph,int n) {
        G = graph;
        //边数
        assert (graph.E() >= 1);
        ipq = new IndexMinHeap<>(graph.V());
        //算法初始化
        marked = new boolean[G.V()];
//        edgeTo = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++) {
            marked[i]=false;
//            edgeTo[i]=null;
        }
        mst=new Vector<Edge<Weight>>();
        // Prim
        visit(n);
        while (!ipq.isEmpty()){
            int v = ipq.extractMinIndex();
            Edge e=ipq.getItem(v);
            if(e!=null){
                mst.add(e);
            }
            visit(v);
        }
        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
    }
    private void visit(int v){
        assert !marked[v];
        marked[v]=true;
        //将和节点v相连接的未访问的另一端点, 和与之相连接的边, 放入最小堆中
        for(Object item:G.iterable(v)){
            Edge<Weight> e=(Edge<Weight>) item;
            int w=e.other(v);
            // 如果边的另一端点未被访问
            if(!marked[w]){
               if(!ipq.contain(w)){
                   ipq.insert(w, e);
               }else if(e.wt().compareTo(ipq.getItem(w).wt())<0){
                   ipq.change(w,e );
               }
            }
        }
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
       PrimMST<Double> lazyPrimMST = new PrimMST<Double>(g,0);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
