package com.wangzhou.datastructure.stack.solution;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:13:34
 **/
public class BallGame {
    public int calPoints(String[] ops) {
        if (ops == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for (String str : ops) {
            switch (str) {
                case "+":
                    if (stack.size() >= 2) {
                        int pop = stack.pop();
                        int temp = stack.peek() + pop;
                        stack.push(pop);
                        stack.push(temp);
                        break;
                    } else {
                        stack.push(0);
                        break;
                    }

                case "D":
                    if (stack.size() >= 1) {
                        stack.push(stack.peek() * 2);
                        break;
                    } else {
                        stack.push(0);
                        break;
                    }

                case "c":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(str));
                    break;

            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
