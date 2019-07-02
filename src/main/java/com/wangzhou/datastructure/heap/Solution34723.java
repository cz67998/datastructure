package com.wangzhou.datastructure.heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:14:27
 **/
public class Solution34723 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.poll());
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }


}
