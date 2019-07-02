package com.wangzhou.datastructure.queue;

import com.wangzhou.datastructure.linkedlist.LinkedListQueue;

import java.util.Random;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/16
 * Time:15:30
 **/
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw  new IllegalArgumentException("queue is empty");
        }
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()%2!=0){
         resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public boolean add(E e) {
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
        return true;
    }



    @Override
    public E peek() {
        if(isEmpty()){
            throw  new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }
    private void resize(int capacity) {
        E[] newData=(E[]) new  Object[capacity*2+1];
        for(int i=0;i<data.length;i++){
            newData[i]=data[(front+i)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(String.format("Queue :size=%d;capacity=%d\n",size,getCapacity() ));
        stringBuilder.append("front [");
        for (int i=front;i!=tail;i=(i+1)%data.length){
            stringBuilder.append(data[i]);
            if((i+1)%data.length!=tail){
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }



    public static void main(String[] args){
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 =CompareQueue.testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 =CompareQueue.testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue=new LinkedListQueue<>();
        double time3 =CompareQueue.testQueue(loopQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");


        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.add(i);
            System.out.println(queue);

//            if(i % 3 == 2){
//                queue.pop();
//                System.out.println(queue);
//            }
        }
        queue.pop();
        System.out.println("111"+queue);
    }
}
