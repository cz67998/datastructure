package com.wangzhou.datastructure.segmenttree;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/29
 * Time:21:32
 **/
public interface Merger<E>  {
    E merge(E a,E b);
}
