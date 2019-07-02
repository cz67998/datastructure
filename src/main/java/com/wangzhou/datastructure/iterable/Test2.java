package com.wangzhou.datastructure.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/22
 * Time:11:00
 **/
public class Test2 implements Iterable<Object> {
    private Object[] ints;

    public Test2(int n) {
        ints = new Object[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
    }

    class Test2Iterator implements Iterator<Object> {
        Object current;
        int i = 0;
        Object[] data;

        public Test2Iterator(Object[] data) {
            this.data = data;
            if (data != null) {
                current = data[0];
            }
        }

        @Override
        public boolean hasNext() {
            return i != data.length;
        }

        @Override
        public Object next() {
            if(i>=data.length){
                throw new NoSuchElementException();
            }
            Object value=current;
            current = data[i++];

            return current;
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new Test2Iterator(ints);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2(10);
        for (Object i : test2) {
            System.out.print(i);
        }
    }
}
