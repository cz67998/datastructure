package com.wangzhou.datastructure.comparator;

import com.wangzhou.datastructure.heap.Array;

import java.util.Comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:11:13
 **/
public class MinHeap<E>  {
    private Array<E> data;
    private final Comparator<? super E> comparator;
    public MinHeap(int capacity, Comparator<? super E> comparator) {
        data = new Array<>(capacity);
        this.comparator=comparator;

    }
    public MinHeap(Comparator<? super E> comparator){
        this(10,comparator);
    }
    public MinHeap(int capacity){
        this(capacity,null);
    }
    public MinHeap() {
        this(10);

    }
    public MinHeap(E[] arr,Comparator<? super E> comparator) {
        this.comparator=comparator;
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDOWN(i);
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index=0 does't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUP(data.getSize() - 1);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = data.findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDOWN(0);
        return ret;
    }

    private void siftDOWN(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //选出左右的较小节点
            if (j + 1 < data.getSize()
                    && comparator.compare( data.get(j + 1),data.get(j)) < 0) {
                j++;
            }
            //比较，较小的元素就break
            if (comparator.compare(data.get(k), data.get(j))<= 0) {
                break;
            }
            //否则替换
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 元素上浮
     *
     * @param k
     */
    private void siftUP(int k) {
        while (k > 0 &&comparator.compare( data.get(parent(k)), data.get(k)) >0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 取出堆中最大元素，并替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = data.findMax();
        data.set(0, e);
        siftDOWN(0);
        return ret;
    }
}
