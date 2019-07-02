package com.wangzhou.datastructure.heap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:14:03
 **/
public interface Queue<E>{
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
