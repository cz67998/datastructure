package com.wangzhou.datastructure.set;

import com.wangzhou.datastructure.mytree.binarytree.BST;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/25
 * Time:15:13
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        if(!contains(e)){
            bst.add(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
