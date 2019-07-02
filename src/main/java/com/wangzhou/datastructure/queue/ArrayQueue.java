package com.wangzhou.datastructure.queue;

import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:14:44
 **/
public class ArrayQueue<E>  implements Queue<E>{
    private List<E> list;
    public ArrayQueue(int capacity){
        list=new ArrayList<>();
    }
    public ArrayQueue(){
        this(10);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw  new IllegalArgumentException("queue is empty");
        }
        return list.remove(0);
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public E peek() {
        if(isEmpty()){
          throw  new IllegalArgumentException("queue is empty");
        }
        return list.get(0);
    }
    public int getCapacity(){
        return list.size();
    }

}
