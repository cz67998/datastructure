package com.wangzhou.datastructure.linkedlist.solution;

import com.wangzhou.datastructure.linkedlist.solution.Solution2;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:13:35
 **/
public class ExcgangeElements {
    public ListNode swapPairs(ListNode head) {
       if(head==null||head.next==null){
           return head;
       }

       ListNode temp=head.next;
       head.next=swapPairs(temp.next);
       temp.next=head;
       return temp;
    }
}
