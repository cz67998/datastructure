package com.wangzhou.datastructure.comparator;

import com.wangzhou.datastructure.heap.Array;

import java.util.Comparator;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:11:08
 **/
public class Test<E> {
    private List<E> data;
    private final Comparator<? super E> comparator;

    private Test(List<E> data, Comparator<? super E> comparator) {
        this.data = data;
        this.comparator = comparator;
    }
    public Test(){
        this.comparator=null;
    }

}
