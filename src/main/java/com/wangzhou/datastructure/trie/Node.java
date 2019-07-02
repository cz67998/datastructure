package com.wangzhou.datastructure.trie;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/5
 * Time:8:39
 **/
public class Node {
    boolean isWord;
    HashMap<Character,Node> next;
    public Node(boolean isWord){
        this.isWord=isWord;
        next=new HashMap<>();
    }
    public Node(){
        this(false);
    }
}
