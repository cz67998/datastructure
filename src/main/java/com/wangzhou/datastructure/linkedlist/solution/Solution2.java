package com.wangzhou.datastructure.linkedlist.solution;

/**
 * 虚拟节点，删除数据
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/18
 * Time:10:07
 **/
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head== null) {
            return null;
        }
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.val==val){
                ListNode delnode = prev.next;
                prev.next=delnode.next;
                delnode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
}

