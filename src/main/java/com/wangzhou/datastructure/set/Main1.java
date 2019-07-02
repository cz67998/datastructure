package com.wangzhou.datastructure.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/25
 * Time:15:35
 **/
public class Main1 {
    private static double testSet(java.util.Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.size());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        String filename = "src\\main\\java\\com\\wangzhou\\datastructure\\set\\pride-and-prejudice.txt";

        HashSet<String> bstSet = new HashSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("Hash Set: " + time1 + " s");

        System.out.println();

        TreeSet<String> linkedListSet = new TreeSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Tree Set: " + time2 + " s");


        System.out.println("Pride and Prejudice");



    }
}
