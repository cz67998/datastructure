package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:14:53
 **/
public class JudgeSummetry {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return summertric(root.left, root.right);
    }

    private boolean summertric(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return left == null;

        return left.val == right.val && summertric(left.left, right.right) && summertric(left.right, right.left);
    }

}
