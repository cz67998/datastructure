package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:9:11
 **/
public class CombationTwoLinkedListSolution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur;
        if (l1.val <= l2.val) {
            cur = l1;
            cur.next = mergeTwoLists(l1.next, l2);
        } else {
            cur = l2;
            cur.next = mergeTwoLists(l1, l2.next);
        }
        return cur;
    }
}
