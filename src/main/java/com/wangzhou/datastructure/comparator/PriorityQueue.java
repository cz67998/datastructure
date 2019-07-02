package com.wangzhou.datastructure.comparator;


import com.wangzhou.datastructure.heap.MaxHeap;
import com.wangzhou.datastructure.heap.Queue;

import java.util.Comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:14:01
 **/
public class PriorityQueue<E> implements Queue<E>{

    public MinHeap<E> minHeap;
    public PriorityQueue(Comparator<? super E> comparator){
        minHeap=new MinHeap<>(comparator);
    }
    @Override
    public int getSize() {
        return minHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        minHeap.add(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return minHeap.extractMax();
    }

    /**
     * 获得队头
     * @return
     */
    @Override
    public E getFront() {
        return minHeap.findMax();
    }
}
