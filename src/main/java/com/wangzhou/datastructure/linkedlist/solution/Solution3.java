package com.wangzhou.datastructure.linkedlist.solution;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * 虚拟节点，删除数据
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/18
 * Time:10:07
 **/

public class Solution3 {

    public ListNode addElementlast(ListNode head, int val){
        if (head == null) {
            head=new ListNode(val);
            return head;
        }
        head.next= addElementlast(head.next,val );
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//           head.next=res;
//           return head;
//        }

//        head.next = removeElements(head.next, val);
//        if (head.val == val) {
//            return head.next;
//        } else {
//            return head;
//        }
        head.next = removeElements(head.next, val);
        return head.val==val?head.next:head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 5, 6};
        com.wangzhou.datastructure.linkedlist.solution.ListNode listNode = new com.wangzhou.datastructure.linkedlist.solution.ListNode(nums);
        System.out.println(listNode);
        Solution3 solution = new Solution3();
        solution.removeElements(listNode, 6);
        System.out.println(listNode);
        solution.addElementlast(listNode,6);
        System.out.println(listNode);


    }
}

