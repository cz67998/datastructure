package com.wangzhou.datastructure.comparator;


import com.wangzhou.datastructure.heap.Queue;
import com.wangzhou.datastructure.heap.solution.Solution3471;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:11:39
 **/
public class Solution {
    public class PriorityQueue<E> implements Queue<E> {

        public com.wangzhou.datastructure.comparator.MinHeap<E> minHeap;

        public PriorityQueue(Comparator<? super E> comparator) {
            minHeap = new com.wangzhou.datastructure.comparator.MinHeap<>(comparator);
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
         *
         * @param e
         */
        @Override
        public void enqueue(E e) {
            minHeap.add(e);
        }

        /**
         * 出队
         *
         * @return
         */
        @Override
        public E dequeue() {
            return minHeap.extractMax();
        }

        /**
         * 获得队头
         *
         * @return
         */
        @Override
        public E getFront() {
            return minHeap.findMax();
        }
    }

    public class MinHeap<E> {
        private com.wangzhou.datastructure.heap.Array<E> data;
        private final Comparator<? super E> comparator;

        public MinHeap(int capacity, Comparator<? super E> comparator) {
            data = new com.wangzhou.datastructure.heap.Array<>(capacity);
            this.comparator = comparator;

        }

        public MinHeap(Comparator<? super E> comparator) {
            this(10, comparator);
        }

        public MinHeap(int capacity) {
            this(capacity, null);
        }

        public MinHeap() {
            this(10);

        }

        public MinHeap(E[] arr, Comparator<? super E> comparator) {
            this.comparator = comparator;
            data = new com.wangzhou.datastructure.heap.Array<>(arr);
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
                        && comparator.compare(data.get(j + 1), data.get(j)) < 0) {
                    j++;
                }
                //比较，较小的元素就break
                if (comparator.compare(data.get(k), data.get(j)) <= 0) {
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
            while (k > 0 && comparator.compare(data.get(parent(k)), data.get(k)) > 0) {
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

    public class Array<E> {
        private E[] data;
        private int size;

        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        public Array() {
            this(10);
        }

        public Array(E[] arr) {
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        public int getCapacity() {
            return data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }

        public void add(int index, E e) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add Failed.Require index>=0 And index >size");
            }
            if (size == data.length) {
                resize(data.length + (data.length >> 1));
            }
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }

        public void addLast(E e) {
            add(size, e);
        }

        public void addFirst(E e) {
            add(0, e);
        }

        public E get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        public void set(int index, E e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            data[index] = e;
        }

        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        public E remove(int index) {
            if (index < 0 && index >= size) {
                throw new IllegalArgumentException("Removed failed.Index is illegal.");
            }
            E remove = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            data[size] = null;
            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return remove;
        }

        public E removeFirst() {
            return remove(0);
        }

        public E removeLast() {
            return remove(size - 1);
        }

        public void removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
            }
        }

        private void resize(int capacity) {
            E[] newData = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public void swap(int i, int j) {
            if (i < 0 || i >= size || j < 0 || j >= size) {
                throw new IllegalArgumentException("Index is illegal");
            }
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        public E findMax() {
            return data[0];
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array :size=%d,capactity=%d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1) {
                    res.append(",");
                }
            }
            res.append(']');
            return res.toString();
        }


    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (priorityQueue.getSize() < k) {
                priorityQueue.enqueue(key);
            } else if (map.get(key) > map.get(priorityQueue.getFront())) {
               priorityQueue.dequeue();

                priorityQueue.enqueue(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();

        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.dequeue());
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

       // int[] nums = {1, 1, 1, 2, 2, 3};
         int[] nums = {4, 1, -1, 2,-1, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}
