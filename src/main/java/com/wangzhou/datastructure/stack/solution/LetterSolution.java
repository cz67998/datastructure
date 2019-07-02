package com.wangzhou.datastructure.stack.solution;


import com.wangzhou.datastructure.stack.ArrayStack;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/15
 * Time:8:59
 **/
public class LetterSolution {
    private Stack stack;

    public boolean isVaild(String s) {
        ArrayStack stack = new ArrayStack();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;

                char topChar = (char)stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.stack);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LetterSolution letterSolution = (LetterSolution) obj;
        return Objects.equals(this.stack, ((LetterSolution) obj).stack);
    }

    public static void main(String[] args) {
        System.out.println(new LetterSolution().isVaild("(("));
       // System.out.println(new LetterSolution().isVaild("([)]"));
        ArrayStack stack = new ArrayStack();
        stack.push("a");
        stack.push("b");
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(new Integer(1).equals(new Integer(1)));
        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(1 == 1);
    }
}
