package com.wangzhou.datastructure.stack.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:9:36
 **/
public class MyStack {
    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list = new ArrayList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()) {
            return -1;
        }
        return list.get(list.size()-1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }
}
