package com.wangzhou.datastructure.stack.solution;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:14:25
 **/
public class CompareChar {
    public boolean backspaceCompare(String S, String T) {
        String vaildS = isVaild(S);
        String vaildT = isVaild(T);
        if (vaildS.equals(vaildT)) {
            return true;
        }
        return false;
    }

    private String isVaild(String str) {
        if (str == null) {
            return null;
        }
        Stack<String> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case '#':
                    if (!stack.isEmpty()) {
                        stack.pop();
                        break;
                    } else {
                        break;
                    }
                default:
                    stack.push(str.charAt(i) + "");
                    break;

            }
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stb.append(stack.get(i));
        }
        return stb + "";
    }

}
