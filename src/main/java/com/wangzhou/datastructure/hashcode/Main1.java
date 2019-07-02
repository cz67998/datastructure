package com.wangzhou.datastructure.hashcode;

import com.wangzhou.datastructure.avltree.AVLTree;
import com.wangzhou.datastructure.map.BSTMap;
import com.wangzhou.datastructure.redblacktree.RedBlackTree;
import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/13
 * Time:20:49
 **/
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        // int n = 20000000;
        int n = 2000000;

        Random random = new Random(n);
        ArrayList<Integer> words = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            words.add(random.nextInt(Integer.MAX_VALUE));



            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BSTMap<Integer, Integer> bst = new BSTMap<>();
            for (Integer word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(Integer word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<Integer, Integer> avl = new AVLTree<>();
            for (Integer word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(Integer word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
            for (Integer word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for(Integer word: words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();

            // HashTable<String, Integer> ht = new HashTable<>();
            HashTable<Integer, Integer> ht = new HashTable<>();
            for (Integer word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for(Integer word: words)
                ht.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");


        // Test HashTable
        startTime = System.nanoTime();

        // HashTable<String, Integer> ht = new HashTable<>();
        HashMap<Integer, Integer> ht1 = new HashMap<>();
        for (Integer word : words) {
            if (ht1.containsKey(word))
                ht1.put(word, ht.get(word) + 1);
            else
                ht1.put(word, 1);
        }

        for(Integer word: words)
            ht1.containsKey(word);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("HashMap: " + time + " s");

        System.out.println();
    }
}
