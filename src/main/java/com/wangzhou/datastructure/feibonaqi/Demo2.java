package com.wangzhou.datastructure.feibonaqi;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:15:55
 **/
public class Demo2 {
    // 定义数组方法
    public static void main(String[] args) {
        int arr[] = new int[20];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("斐波那契数列的前20项如下所示：");
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0)
                System.out.println();
            System.out.print(arr[i] + "\t");
        }
    }
}
