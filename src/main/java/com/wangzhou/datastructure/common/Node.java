package com.wangzhou.datastructure.common;

import lombok.Data;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/3/28
 * Time:15:06
 **/
@Data
public class Node<T> {
   private  final T value;
   private Node next;
   public Node(){
      this.value=null;
   }
   public Node(T value){
      this.value=value;
      this.next=null;
   }
   public  static <T> void  sysoLinkList(Node<T> node){

      while(node!=null){
         System.out.print(node.getValue());
         System.out.print("  ");
         node=node.getNext();
      }
      System.out.print("null");
   }
}
