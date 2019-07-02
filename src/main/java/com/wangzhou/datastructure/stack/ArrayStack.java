package com.wangzhou.datastructure.stack;

import com.wangzhou.datastructure.Array.Array;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/15
 * Time:11:07
 **/
public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public T get(int index) {
        return array.get(index);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T o) {
        array.addLast(o);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Stack:");
        stringBuilder.append('[');
        for (int i = 0; i < array.getSize(); i++) {
         stringBuilder.append(array.get(i));
         if(i!=array.getSize()-1){
             stringBuilder.append(",");
         }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();


    }
    public static void main(String[] args){
        java.util.Stack stack=new java.util.Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
    }
}
