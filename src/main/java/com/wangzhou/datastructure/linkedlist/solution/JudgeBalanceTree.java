package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:13:53
 **/
public class JudgeBalanceTree {
    public boolean isBalanced(TreeNode root) {
        return calDepth(root) >= 0;
    }

    private int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = calDepth(root.left);
        int b = calDepth(root.right);
        if (a >= 0 && b >= 0 && Math.abs(a - b) <= 1) {
            return Math.max(a, b) + 1;
        } else {
            return -1;
        }
    }
}
