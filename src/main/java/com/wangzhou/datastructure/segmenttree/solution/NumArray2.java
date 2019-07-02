package com.wangzhou.datastructure.segmenttree.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/30
 * Time:13:24
 **/
public class NumArray2 {
    private int[] sums;
    public NumArray2(int[] nums){
        sums=new int[nums.length];
        if (nums.length==0) {
            return;
        }
        sums[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            sums[i]= sums[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sums[j];
        }else {
            return sums[j]-sums[i];
        }
    }

}
