package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:15:51
 **/
public class FindMinDepthTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else if(root.left != null)
            return minDepth(root.left) + 1;
        else if(root.right != null)
            return minDepth(root.right) + 1;
        else
            return 1;

    }
}
