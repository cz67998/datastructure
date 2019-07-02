package com.wangzhou.datastructure.map.solutions;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/26
 * Time:11:35
 **/
public class Solution350 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i])) {
                hashMap.put(nums1[i], (int) hashMap.get(nums1[i]) + 1);
            } else {
                hashMap.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int num:nums2){
            if(hashMap.containsKey(num)){
                res.add(num);
                hashMap.put(num,hashMap.get(num)-1 );
                if(hashMap.get(num)==0){
                    hashMap.remove(num);

                }
            }
        }
        int[] ret = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }
}
