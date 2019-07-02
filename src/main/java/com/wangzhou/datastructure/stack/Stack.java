package com.wangzhou.datastructure.stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/15
 * Time:11:02
 **/
public interface Stack<E> {
    E get(int index);
    int getSize();
    boolean isEmpty();
    void push (E e);
    E pop();
    E peek();
}
