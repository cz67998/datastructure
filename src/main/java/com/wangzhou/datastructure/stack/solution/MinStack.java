package com.wangzhou.datastructure.stack.solution;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/15
 * Time:16:51
 **/
public class MinStack {
    private Stack stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
    }

    public void push(int x) {
        if (Integer.valueOf(x) != null) {
            stack.push(x);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int top=(int) stack.peek();
        System.out.println(top);
        return top;
    }

    public int getMin() {
        int min = (int)stack.get(stack.size()-1);
        for (int i = 0; i < stack.size(); i++) {
            if ((int) stack.get(i) <= min) {
                min = (int) stack.get(i);
            }
        }
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.stack);
        minStack.getMin();
        minStack.pop();
        System.out.println(minStack.stack);
        minStack.getMin();
        minStack.pop();
        System.out.println(minStack.stack);
        minStack.getMin();
        minStack.pop();
        System.out.println(minStack.stack);
        minStack.getMin();

    }
}
