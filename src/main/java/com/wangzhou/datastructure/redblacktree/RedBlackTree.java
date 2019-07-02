package com.wangzhou.datastructure.redblacktree;

import com.wangzhou.datastructure.map.Map;
import com.wangzhou.datastructure.map.TreeNode;
import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/26
 * Time:9:41
 **/
public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class TreeNode<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public TreeNode left, right;
        public boolean color;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private TreeNode root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    /**
     * 判断节点node的颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(TreeNode node) {
        if (node == null) {
            //性质3，新节点为空，则为黑色
            //每一个叶子节点（最后的空节点）是黑色的
            return BLACK;
        }
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private TreeNode leftRotate(TreeNode node) {
        TreeNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private TreeNode rightRotate(TreeNode node) {
        TreeNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 颜色翻转
     *
     * @param node
     */
    private void flipColors(TreeNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }


    public void add(K key, V value) {
        root = add(root, key, value);
        //保证根节点为根
        root.color = BLACK;
    }

    private TreeNode add(TreeNode node, K key, V value) {

        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        if (key.compareTo((K) node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo((K) node.key) >0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
         node=leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node= rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
          flipColors(node);
        }

        return node;
    }

    private TreeNode getNode(TreeNode node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo((K) node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }

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


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        TreeNode node = getNode(root, key);
        return node == null ? null : (V) node.value;
    }


    public void set(K key, V newValue) {
        TreeNode node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src\\main\\java\\com\\wangzhou\\datastructure\\set\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            RedBlackTree<String, Integer> map = new RedBlackTree<>();
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
