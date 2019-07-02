package com.wangzhou.datastructure.trie;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/5
 * Time:8:47
 **/
public class Trie {
    private Node root;
    //trie中的单词数量
    private int size;

    public Trie() {
        size = 0;
        root = new Node();
    }

    /**
     * 获取trie中的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加单词
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * trie是否包含单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) != null) {
                cur = cur.next.get(c);
            } else {
                return false;
            }
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
