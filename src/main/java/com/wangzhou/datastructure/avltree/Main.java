package com.wangzhou.datastructure.avltree;

import com.wangzhou.datastructure.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/10
 * Time:10:15
 **/
public class Main {
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
//                if (!map.isBalanced() || !map.isBalanced()) {
//                    throw new RuntimeException("Error");
//                }
            }
            double endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000;

            System.out.println("AVLTree:" + time + " s");

            System.out.println();


            System.out.println("Total words: " + words.size());
            startTime = System.nanoTime();
            AVLTreeMap<String, Integer> map1 = new AVLTreeMap<>();
            for (String word : words) {
                if (map1.contains(word))
                    map1.set(word, map1.get(word) + 1);
                else
                    map1.add(word, 1);
            }
            for (String word : words) {
                map1.contains(word);
            }
            for (String word : words) {
                map1.remove(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000;

            System.out.println("AVLTreeMap:" + time + " s");

            System.out.println();
        }
    }
}
