package com.wangzhou.datastructure.avltree;

import com.wangzhou.datastructure.set.Set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/10
 * Time:10:09
 **/
public class AVLTreeSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avl;

    public AVLTreeSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        if(!contains(e)){
            avl.add(e, null);
        }
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
