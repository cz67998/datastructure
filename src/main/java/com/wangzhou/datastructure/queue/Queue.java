package com.wangzhou.datastructure.queue;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:14:45
 **/
public interface Queue<E> {
    int size();

    boolean isEmpty();


    E pop();
    boolean add(E e);


    E peek();
}
