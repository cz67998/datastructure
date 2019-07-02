package com.wangzhou.datastructure.redblacktree;

import com.wangzhou.datastructure.avltree.AVLTree;
import com.wangzhou.datastructure.map.BSTMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/13
 * Time:15:08
 **/
public class Main3 {
    public static void main(String[] args){
        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(i);

        // Test BST






        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RedBlackTree: " + time + " s");
    }
}
