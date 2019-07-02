package com.wangzhou.datastructure.set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/25
 * Time:15:13
 **/
public interface Set<E>{
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
