package com.wangzhou.datastructure.hufumantree;

import lombok.Data;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:13:49
 **/
@Data
public class Node<T> implements Comparable<Node<T>> {
    private T data;
    private int weight;
    private Node left;
    private Node right;

    public Node(T data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //倒序
    @Override
    public int compareTo(Node<T> o) {
        if (this.weight > o.weight) {
            return -1;
        } else if (this.weight < o.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "data:" + this.data + ",weight:" + this.weight + ";   ";
    }
}
