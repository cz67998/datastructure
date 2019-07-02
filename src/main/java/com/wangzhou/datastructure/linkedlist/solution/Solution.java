package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/18
 * Time:10:07
 **/
public class Solution {


    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delnode = head;
            head = head.next;
            delnode.next = null;
        }

        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delnode = prev.next;
                prev.next = delnode.next;
                delnode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 5, 6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);
        Solution solution=new Solution();
        solution.removeElements(listNode,6 );
        System.out.println(listNode);
    }
}

