package com.wangzhou.datastructure.linkedlist.solution;

import com.wangzhou.datastructure.linkedlist.Node;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/18
 * Time:13:15
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    ListNode(int[] input){
        if(input==null||input.length==0){
            return ;
        }
        this.val=input[0];
        ListNode cur=this;
        for (int i = 1; i < input.length; i++) {
            cur.next=new ListNode(input[i]);
            cur=cur.next;
        }
    }
//    ListNode(int[] input) {
//        if (input == null || input.length == 0) {
//            return;
//        }
//        this.val=input[0];
//        if(input.length!=1){
//            ListNode cur=new ListNode(subInput(1,input.length,input));
//            this.next=cur;
//        }
//    }

    private int[] subInput(int a, int length,int[] input) {

        int[] newInput=new int[length-1];
        for(int i=0;i<length-1;i++){
            newInput[i]= input[i+a];
        }
        return newInput;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
