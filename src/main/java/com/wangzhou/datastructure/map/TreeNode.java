package com.wangzhou.datastructure.map;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/26
 * Time:9:42
 **/
public class TreeNode<K extends Comparable<K>,V> {
    public K key;
    public V value;
    public TreeNode left, right;
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}
