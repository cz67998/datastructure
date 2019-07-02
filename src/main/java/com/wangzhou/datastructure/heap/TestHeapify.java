package com.wangzhou.datastructure.heap;

import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:11:11
 **/
public class TestHeapify {
    private static double testHeap(Integer[] testData,boolean isHeapift){
        long startTime=System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapift){
            maxHeap=new MaxHeap<>(testData);
        }else {
            maxHeap=new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }
        }
        int[] arr=new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i]=maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
           if(arr[i-1]<arr[i]){
               throw new IllegalArgumentException("Error");
           }
        }
        System.out.println("Test MaxHeap complete.");
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.00;
    }
    public static void main(String[] args){
        Random random=new Random();
        int n=1000000;
        Integer[] testData=new Integer[n];
        for (int i = 0; i < n; i++) {
         testData[i]=random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }

}
