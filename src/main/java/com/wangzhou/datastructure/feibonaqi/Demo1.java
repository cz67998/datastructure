package com.wangzhou.datastructure.feibonaqi;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:15:54
 **/
public class Demo1 {
    // 定义三个变量方法
    public static void main(String[] args) {
        int a = 1, b = 1, c = 0;
        System.out.println("斐波那契数列前20项为：");
        System.out.print(a + "\t" + b + "\t");
        //因为前面还有两个1、1 所以i<=18
        for (int i = 1; i <= 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
            if ((i + 2) % 5 == 0)
                System.out.println();
        }
    }
}
