package com.wangzhou.datastructure.map;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/25
 * Time:16:43
 **/
public class Node<K,V> {
    public K key;
    public V value;
    public Node next;

    public Node(K key, V value, Node next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(K key, V value){
        this(key, value, null);
    }

    public Node(){
        this(null, null, null);
    }

    @Override
    public String toString(){
        return key.toString() + " : " + value.toString();
    }
}
