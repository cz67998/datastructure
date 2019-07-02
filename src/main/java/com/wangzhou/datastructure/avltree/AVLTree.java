package com.wangzhou.datastructure.avltree;

import com.wangzhou.datastructure.map.BSTMap;
import com.wangzhou.datastructure.mytree.binarytree.BST;
import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/8
 * Time:11:26
 **/
public class AVLTree<K extends Comparable<K>, V> {
    private class TreeNode {
        public K key;
        public V value;
        public TreeNode left, right;
        //高度参数
        public int height;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height=1;
        }
    }
    private TreeNode root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 计算平衡因子
     *
     * @param node
     * @return
     */
    private int balanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 判断是否为二分搜索树（左>右）
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inorder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断是否为一个平衡二叉树
     *
     * @return
     */
    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = balanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }


    /**
     * 中序遍历
     *
     * @param root
     * @param keys
     */
    private void inorder(TreeNode root, ArrayList<K> keys) {
        if (root == null) {
            return;
        }
        inorder(root.left, keys);
        keys.add((K) root.key);
        inorder(root.right, keys);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T3 = x.right;
        x.right = y;
        y.left = T3;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        TreeNode T2 = x.left;
        x.left = y;
        y.right = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 左右旋转
     *
     * @param y
     * @return
     */
    private TreeNode leftrightRotate(TreeNode y) {
        y.left = leftRotate(y.left);
        return rightRotate(y);
    }

    /**
     * 右左旋转
     *
     * @param y
     * @return
     */
    private TreeNode rightleftRotate(TreeNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

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
        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = balanceFactor(node);

        //右旋转
        if (balanceFactor > 1 && balanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //左右转
        if (balanceFactor > 1 && balanceFactor(node.left) < 0) {
            return leftrightRotate(node);
        }
        //左旋转
        if (balanceFactor < -1 && balanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //右左转
        if (balanceFactor < -1 && balanceFactor(node.right) > 0) {
            return rightleftRotate(node);
        }
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced:" + balanceFactor);
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
        TreeNode retNode;
        if (key.compareTo( node.key) < 0) {
            node.left = remove(node.left, key);
            retNode= node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode= node;
        } else {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                retNode=right;
            }
            else  if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                retNode=left;
            }else {
                TreeNode successor = minimum(node.right);
                successor.right = remove(node.right,(K)successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode=successor;
            }
        }
        if(retNode==null){
            return null;
        }
        //更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactor = balanceFactor(retNode);

        //右旋转
        if (balanceFactor > 1 && balanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //左右转
        if (balanceFactor > 1 && balanceFactor(retNode.left) < 0) {
            return leftrightRotate(retNode);
        }
        //左旋转
        if (balanceFactor < -1 && balanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //右左转
        if (balanceFactor < -1 && balanceFactor(retNode.right) > 0) {
            return rightleftRotate(retNode);
        }
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced:" + balanceFactor);
        }
        return retNode;
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
          Collections.sort(words);
            System.out.println("Total words: " + words.size());
            double startTime = System.nanoTime();
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            for (String word : words) {
                map.contains(word);
            }
            for (String word : words) {
                map.remove(word);
                if(!map.isBalanced()||!map.isBalanced()){
                    throw  new RuntimeException("Error");
                }
            }

//            System.out.println("Total different words: " + map.getSize());
//            System.out.println("Frequency of PRIDE: " + map.get("pride"));
//            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//            System.out.println("is BST:" + map.isBST());
//            System.out.println("is balanced:" + map.isBalanced());

            double endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000;

            System.out.println("AVLTree:" + time + " s");

            System.out.println();


            startTime = System.nanoTime();

            BSTMap<String, Integer> avl = new BSTMap<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("BSTMap: " + time + " s");


            HashMap<String, Integer> av2 = new HashMap<>();
            for (String word : words) {
                if (av2.containsValue(word))
                    av2.put(word, avl.get(word) + 1);
                else
                    av2.put(word, 1);
            }

            for (String word : words)
                av2.containsValue(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashMap: " + time + " s");
        }

        System.out.println();

    }


}

