package com.wangzhou.datastructure.comparator;

import com.wangzhou.datastructure.heap.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/28
 * Time:16:14
 **/
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] names = {"Sun Wukong", "Pig Bajie", "Sha Wujing"};
        //Arrays.sort(names, new LengthComparator());

        //Arrays.sort(names, (first,second)->first.length()-second.length());
        Arrays.sort(names,Comparator.comparing(String::length));
        for(String name:names){
            System.out.println(name);
        }
    }
}
