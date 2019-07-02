package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/18
 * Time:14:55
 **/
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);

    }

    private static int sum(int[] arr, int l) {
       if(l==arr.length){
           return 0;
       }
       return arr[l]+sum(arr,l+1);
    }

    public static int summ(int[] input) {
        if (input.length == 0 || input == null) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException  ");
            //return 0;
        }
        int sum = input[0];
        if (input.length != 1) {
            sum += summ(subInput(1, input.length, input));

        }
        return sum;
    }

    private static int[] subInput(int a, int length, int[] input) {

        int[] newInput = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            newInput[i] = input[i + a];
        }
        return newInput;
    }

    public static void main(String[] args) {
        System.out.println(Sum.summ(new int[]{1, 2, 3, 4}));
        System.out.println(Sum.sum(new int[]{1, 2, 3, 4}));
    }
}
