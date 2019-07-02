package com.wangzhou.datastructure.stack.solution;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/15
 * Time:16:51
 **/
public class MinStack2 {
    private Stack stack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = (int) stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return (int) stack.get(stack.size() - 2);
    }

    public int getMin() {
        return (int) stack.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
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
