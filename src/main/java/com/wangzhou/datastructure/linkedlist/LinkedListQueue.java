package com.wangzhou.datastructure.linkedlist;

import com.wangzhou.datastructure.queue.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/17
 * Time:14:12
 **/
public class LinkedListQueue<E> implements Queue<E> {
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node retNode = head;
        head = head.getNext();
        retNode.setNext(null);
        if (head == null) {
            tail = null;
        }
        size--;
        return (E) retNode.getE();
    }

    @Override
    public boolean add(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.setNext(new Node(e));
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return (E) head.getE();
    }
}
