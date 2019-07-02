package com.wangzhou.datastructure.linkedlist;


import lombok.Data;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/17
 * Time:8:59
 **/
@Data
public class Node<E> {
    public E e;
    public Node next, prev;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e,  Node<E> prev,Node<E> next) {
        this.e = e;
        this.next = next;
        this.prev = prev;
    }

    public Node(E e) {
        this.e = e;
        this.next = null;
    }

    public Node(E[] input) {
        if (input == null) {
            return;
        }
        this.setE(input[0]);

        if (input.length != 1) {
            Node cur = new Node(subInput(1, input.length, input));
            this.setNext(cur);
        }
    }

    private E[] subInput(int a, int length, E[] input) {

        E[] newInput = (E[]) new Object[length - 1];
        for (int i = 0; i < length - 1; i++) {
            newInput[i] = input[i + a];
        }
        return newInput;
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = this;
        while (cur != null) {
            stringBuilder.append(cur.getE() + "->");
            cur = cur.getNext();
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(head.toString());
    }
}
