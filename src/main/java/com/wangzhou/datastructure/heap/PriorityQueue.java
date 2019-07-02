package com.wangzhou.datastructure.heap;




/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:14:01
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    public MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
     maxHeap.add(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 获得队头
     * @return
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
