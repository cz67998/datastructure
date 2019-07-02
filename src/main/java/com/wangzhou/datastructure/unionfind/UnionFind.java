package com.wangzhou.datastructure.unionfind;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/7
 * Time:9:00
 **/
public interface UnionFind {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
