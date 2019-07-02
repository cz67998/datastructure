package com.wangzhou.datastructure.Array;

import com.wangzhou.datastructure.stack.solution.LetterSolution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/11
 * Time:20:20
 **/
@SuppressWarnings("unchecked")
public class Array<T> {
    private T[] data;
    private int size;

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public T getLast() {
        return get(size - 1);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addlast failed.required index>=0 index<size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index处的数据
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Get failed.Index is illegal");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Get failed.Index is illegal");
        data[index] = e;
    }

    /**
     * 查找数组是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return true;

    }

    /**
     * 查找数组元素e所在的索引，如果不存在元素e，返回-1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("error,index is illegal");
        }

        T set = data[index];
        for (int i = index + 1; i <= size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return set;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /*
     从数组中删除元素e
      */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 如果不够，扩大双倍
     *
     * @param newcapacity
     */
    private void resize(int newcapacity) {
        T[] newdata = (T[]) new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
            data = newdata;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
//        Array<Integer> arr = new Array<>(20);
//        for (int i = 0; i < 10; i++)
//            arr.addLast(i);
//        System.out.println(arr);
//
//        arr.add(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
        String a=new String("a");
        String b="a";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a==b);

        LetterSolution array1=new LetterSolution();
        LetterSolution array2=new LetterSolution();
        System.out.println(array1.hashCode());
        System.out.println(array2.hashCode());
        System.out.println(array1==array2);
        System.out.println(array1.equals(array2));

    }

}
