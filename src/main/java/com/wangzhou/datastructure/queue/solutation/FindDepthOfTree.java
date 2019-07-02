package com.wangzhou.datastructure.queue.solutation;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:13:19
 **/
public class FindDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        depth = Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth+1;
       // return root == null?0:Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
