package com.wangzhou.datastructure.hufumantree;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:13:58
 **/
public class HuffmanTree<T> {
    public static Node createTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.getWeight()
                    + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    public static  List<Node> breath(Node root) {
        List<Node> list = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node  pNode = queue.poll();
            list.add(pNode);
            if (pNode.getLeft() != null) {
                queue.add(pNode.getLeft());
            }
            if (pNode.getRight() != null) {
                queue.add(pNode.getRight());
            }
        }
        return list;
    }
    public static void main(String[] args) {
//        Node node1 = new Node(1, 1);
//        Node node2 = new Node(2, 2);
//        List<Node> list = new ArrayList<>();
//        list.add(node2);
//        list.add(node1);
//        Collections.sort(list);
//        System.out.println(list);
        // TODO Auto-generated method stub
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node("b", 5));
        nodes.add(new Node("a", 7));
        nodes.add(new Node("d", 2));
        nodes.add(new Node("c", 4));
        Node<String> root = HuffmanTree.createTree(nodes);
        System.out.println(HuffmanTree.breath(root));
    }
}
