package com.wangzhou.datastructure.map;

import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/26
 * Time:9:41
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private TreeNode root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private TreeNode add(TreeNode node, K key, V value) {
        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        if (key.compareTo((K) node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo((K) node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private TreeNode getNode(TreeNode node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (key.compareTo((K) node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }

    }

    @Override
    public V remove(K key) {
        TreeNode node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return (V) node.value;
        }
        return null;

    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        TreeNode minNode = minimum(node.left);
        return minNode;
    }

    private TreeNode maximum(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMin(node.right);
        return node;
    }

    private TreeNode remove(TreeNode node, K key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo((K) node.value) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo((K) node.value) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }
            TreeNode successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        TreeNode node = getNode(root, key);
        return node == null ? null : (V) node.value;
    }

    @Override
    public void set(K key, V newValue) {
        TreeNode node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src\\main\\java\\com\\wangzhou\\datastructure\\set\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
