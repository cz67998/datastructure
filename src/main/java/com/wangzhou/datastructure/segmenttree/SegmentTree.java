package com.wangzhou.datastructure.segmenttree;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:20:11
 **/
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegementTree(0, 0, arr.length - 1);
    }

    /**
     * 在[left...right]范围内创建线段树
     *
     * @param treeIndex
     * @param left
     * @param right
     */
    private void buildSegementTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = left + (right - left) / 2;
        buildSegementTree(leftTreeIndex, left, mid);
        buildSegementTree(rightTreeIndex, mid + 1, right);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        return index / 2 + 1;
    }

    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length || queryRight < 0 || queryRight >= data.length || queryLeft > queryRight) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    /**
     * 在区间[left right] 查找[queryLeft   qureyRight]里的元素
     *
     * @param treeIndex
     * @param left
     * @param right
     * @param queryLeft
     * @param queryRight
     * @return
     */
    public E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryRight <= mid) {
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        } else if (queryLeft >= mid + 1) {
            return query(rightTreeIndex, mid + 1, right, queryLeft, queryRight);
        } else {
            E treeLeft = query(leftTreeIndex, left, mid, queryLeft, mid);
            E treeRight = query(rightTreeIndex, mid + 1, right, mid + 1, queryRight);
            return merger.merge(treeLeft, treeRight);
        }
    }

    /**
     * 更新线段树
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIndex] = e;
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, right, index, e);
        } else if (index <= mid) {
            set(leftTreeIndex, left, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("NULL");
            }
            if (i != tree.length - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
