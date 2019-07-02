package com.wangzhou.datastructure.queue;

import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:20:30
 **/
public class CompareQueue {
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    public static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.add(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
