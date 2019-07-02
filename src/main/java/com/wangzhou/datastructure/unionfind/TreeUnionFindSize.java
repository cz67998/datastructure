package com.wangzhou.datastructure.unionfind;

/**
 * first Union-Find  tree  size优化 quick find
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/7
 * Time:9:45
 **/
public class TreeUnionFindSize implements UnionFind {
    //使用数组构建一棵指向父亲点的树
    private int[] parent;
    private int[] sz;

    public TreeUnionFindSize(int size) {
        parent = new int[size];
        sz = new int[size];
        //初始化，每一个id[i]指向自己，表示每一个元素自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * O（h） ,h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        //不断去查询自己父亲节点，值到到达根节点
        //根节点的特点：parent[p];
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和q是否所属的一个集合
     * o(h)复杂度,h为树的高度
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并p和q所属的集合
     * o(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
