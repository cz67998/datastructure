package com.wangzhou.datastructure.heap.solution;

import com.wangzhou.datastructure.heap.Array;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:14:27
 **/
public class Solution347 {
    public static class Freq implements Comparable<Freq> {
        private int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.poll().freq) {
                priorityQueue.add(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.poll().e);
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

//        int[] nums = {4, 1, -1, 2, -1, 2, 3};
//        int k = 2;
//        printList((new Solution347()).topKFrequent(nums, k));

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Freq(4, 4));
        priorityQueue.add(new Freq(2, 2));
        priorityQueue.add(new Freq(3, 3));
        priorityQueue.add(new Freq(1, 1));
//        List<Freq> priorityQueue=new ArrayList<>();
//        priorityQueue.add(new Freq(4,4));
//        priorityQueue.add(new Freq(2,2));
//        priorityQueue.add(new Freq(3,3));
//        priorityQueue.add(new Freq(1,1));
        for (Freq freq:priorityQueue){
            System.out.println(freq.freq);
        }


    }
}
