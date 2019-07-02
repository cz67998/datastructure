package com.wangzhou.datastructure.unionfind;

/**
 * second Union-Find  Tree  quick union
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/7
 * Time:9:45
 **/
public class ArrayUnionFind implements UnionFind {
    private int[] id;

    public ArrayUnionFind(int size) {
        id = new int[size];
        //初始化，每一个id[i]指向自己，没有合并的元素
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * O（1） 复杂度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查看元素p和q是否所属的一个集合
     * o(1)复杂度
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
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
