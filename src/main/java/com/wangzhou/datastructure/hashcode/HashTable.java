package com.wangzhou.datastructure.hashcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/14
 * Time:14:11
 **/
public class HashTable<K, V> {
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    //平均每个地址承载的元素上界
    private static final int upperTol = 10;
    //平均每个地址承载的元素下界
    private static final int lowerTol = 2;
//    //初始地址容量
//
//    private static final int initCapacity = 7;
    private static  int capacityIndex = 0;
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    //M为取模参数
    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加数据
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            //修改数据
            map.put(key, value);
        } else {
            //添加数据
            map.put(key, value);
            size++;
            if (size >= upperTol * M&&capacityIndex+1<capacity.length) {
                capacityIndex++;
                //扩容
                resize(capacity[capacityIndex]);
            }
        }
    }

    /**
     * 改变容量
     *
     * @param newM
     */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < upperTol * M && capacityIndex-1 >=0) {
                capacityIndex--;
                //扩容
                resize(capacity[capacityIndex]);

            }
        }
        return ret;
    }

    /**
     * 设置参数
     *
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        } else {
            map.put(key, value);
        }
    }

    /**
     * 查询某一个TreeMap是否存在
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        HashMap map = new HashMap();
        return hashtable[hash(key)].containsKey(key);
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }


}
