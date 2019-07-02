package com.wangzhou.datastructure.linkedlist;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/17
 * Time:9:09
 **/
public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }
    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.getNext();
        }
        pre.setNext(new Node(e, pre.getNext()));
        size++;

    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取index下的节点元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.getNext();
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return (E) cur.getE();
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改index处的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.getNext();
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        cur.setE(e);
    }

    /**
     * 查找是否存在e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.getNext();

        for (int i = 0; i < size; i++) {
            if (cur.getE().equals(e)) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * 删除节点
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
//        Node cur = dummyHead.getNext();
//        for (int i = 0; i < index-1 ; i++) {
//            cur = cur.getNext();
//        }
        Node cur1=dummyHead;
        for (int i = 0; i < index ; i++) {
            cur1 = cur1.getNext();
        }
       // System.out.println(cur1.equals(cur));
//        Node cur = dummyHead.getNext();
//        for (int i = 0; i < index-1 ; i++) {
//            cur = cur.getNext();
//        }

        Node removeNode = cur1.getNext();

        cur1.setNext(removeNode.getNext());
        removeNode.setNext(null);
        size--;
        return (E) removeNode.getE();
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node cur = dummyHead.getNext(); cur != null; cur = cur.getNext()) {
            stringBuilder.append(cur + "->");
        }
//        Node cur=dummyHead.getNext();
//        for ( cur!=null){
//            stringBuilder.append(cur+"->");
//           cur= cur.getNext();
//        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);

        for (int i = 0; i < 1; i++) {
            System.out.println(1);
        }

    }

}
