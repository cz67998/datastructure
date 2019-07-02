package com.wangzhou.datastructure.linkedlist;

import java.util.LinkedList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/17
 * Time:9:09
 **/
public class TwoWayLinkedList<E> {
    private int size = 1;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public TwoWayLinkedList() {
    }

    public void linkFirst(E e) {
        final Node f = first;
        final Node newNode = new Node(e, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        }else {
            f.prev=newNode;
        }
        size++;
    }


    public void linkLast(E e) {
        final Node l =last;
        final Node newNode=new Node(e,l,null);
        last=newNode;
        if(l==null){
            first=newNode;
        }else {
            l.next=newNode;
        }
        size++;
    }

    /**
     * insert element e before non-null Node succ
     */
    public void linkBefore(E e,Node<E> succ){
        final Node<E> pred=succ.prev;
        final Node<E> newNode=new Node<>(e,pred,succ);
        succ.prev=newNode;
        if(pred==null){
          first=newNode;
        }else {
            pred.next=newNode;
        }
        size++;
    }



    public static void main(String[] args) {
        TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedList();
        System.out.println(twoWayLinkedList.first);

        LinkedList linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList.toString());
    }
}
