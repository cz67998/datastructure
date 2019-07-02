package com.wangzhou.datastructure.heap.solution;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:15:22
 **/
public class KthLargest {
    private final PriorityQueue<Integer> priorityQueue;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        priorityQueue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
          add(num);
        }
    }

    public int add(int val) {
        if(priorityQueue.size()<k){
            priorityQueue.add(val);
        }else if(priorityQueue.peek()<val){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
    public static void main(String[] args){

        int[] arr = {0};
        KthLargest kthLargest = new KthLargest(2, arr);
        System.out.println( kthLargest.add(-1));
        System.out.println( kthLargest.add(1));
        System.out.println( kthLargest.add(-2));
        System.out.println( kthLargest.add(-4));
        System.out.println( kthLargest.add(3));

    }
}
