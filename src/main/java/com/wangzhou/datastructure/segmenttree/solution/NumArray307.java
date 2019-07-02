package com.wangzhou.datastructure.segmenttree.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/30
 * Time:13:24
 **/
public class NumArray307 {
    private int[] sums;
    private int[] data;
    public NumArray307(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        data=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i]=nums[i];
        }
        sums = new int[nums.length+1];

        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i-1];
        }
    }

    public void update(int index, int val) {
        if(index<0||index>data.length){
            return;
        }
        data[index]=val;
        for(int i=index+1;i<sums.length;i++){
            sums[i] = sums[i - 1] + data[i-1];
        }
    }

    public int sumRange(int i, int j) {

            return sums[j+1] - sums[i];

    }

}
