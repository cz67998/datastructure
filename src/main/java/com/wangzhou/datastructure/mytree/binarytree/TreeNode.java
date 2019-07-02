package com.wangzhou.datastructure.mytree.binarytree;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/23
 * Time:17:54
 **/
public class TreeNode<E> {
    public  TreeNode left, right;
    public E e;
    public TreeNode(E e){
        this.e=e;
        this.left=null;
        this.right=null;
    }
}
