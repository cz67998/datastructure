package com.wangzhou.datastructure.avltree;

import com.wangzhou.datastructure.map.Map;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/10
 * Time:10:04
 **/
public class AVLTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avl;

    public AVLTreeMap() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.add(key, newValue);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
