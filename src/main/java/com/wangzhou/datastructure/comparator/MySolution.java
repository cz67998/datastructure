package com.wangzhou.datastructure.comparator;




import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:14:52
 **/
public class MySolution {
    private class Freq implements Comparable<Freq> {
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
            } else if (map.get(key) > priorityQueue.peek().freq) {
                priorityQueue.poll();
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

        // int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {-1, 1, -1, 1,-1, 2, 3};
        int k = 2;
        printList((new MySolution()).topKFrequent(nums, k));
    }
}
