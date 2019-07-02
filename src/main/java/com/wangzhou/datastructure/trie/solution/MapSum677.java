package com.wangzhou.datastructure.trie.solution;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/5
 * Time:11:13
 **/
public class MapSum677 {
    public class Node {
        //存放值value
        public int value;
        HashMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new HashMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
       Node cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if(cur.next.get(c)!=null){

                cur=cur.next.get(c);
            }else {
                return 0;
            }
        }
        return sum(cur);
    }

    private int sum(Node node) {
       int res=node.value;
       for(char c:node.next.keySet()){
           res+=sum(node.next.get(c));
       }
       return res;
    }
}
