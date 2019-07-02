package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:11:27
 **/
public class DeleteRepeatElements {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

}
