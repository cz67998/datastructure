package com.wangzhou.datastructure.map;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/25
 * Time:16:41
 **/
public interface Map<K,V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
