package com.wangzhou.datastructure.redblacktree;

import com.wangzhou.datastructure.avltree.AVLTree;
import com.wangzhou.datastructure.map.BSTMap;
import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/13
 * Time:14:46
 **/
public class Main {
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src\\main\\java\\com\\wangzhou\\datastructure\\set\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            RedBlackTree<String, Integer> bst = new RedBlackTree<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("RedBlackTree: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }

        System.out.println();
    }
}
