package com.wangzhou.datastructure.mytree.binarytree;


import com.wangzhou.datastructure.queue.ArrayQueue;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/23
 * Time:16:59
 **/
public class BST<E extends Comparable<E>> {

    private TreeNode root;
    private int size;
    private TreeNode root1;
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        root = add(root, e);

    }

    public TreeNode add(TreeNode node, E e) {
        if (node == null) {
            size++;
            return new TreeNode<>(e);
        }
        if (e.compareTo((E) node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo((E) node.e) == 0) {
            return true;
        } else if (e.compareTo((E) node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 获取二叉树的最小值
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        TreeNode minNode = minimum(root);
        return (E) minNode.e;
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 获取二叉树的最大值
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        TreeNode minNode = maximum(root);
        return (E) minNode.e;
    }

    private TreeNode maximum(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return minimum(node.right);
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private TreeNode remove(TreeNode node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo((E) node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }

            TreeNode successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public TreeNode removeMin() {
        TreeNode minNode = minimum(root);
        root = removeMin(root);
        return minNode;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode removeMax() {
        TreeNode maxNode = maximum(root);
        root = removeMax(root);
        return maxNode;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        ArrayQueue<TreeNode> queue = new ArrayQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public TreeNode floor(E e) {
        return floor(root, e);
    }

    /**
     * 获取比e大的最小值
     *
     * @param e
     * @return
     */
    private TreeNode floor(TreeNode node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo((E) node.e) == 0) {
            return node;
        } else if (e.compareTo((E) node.e) < 0) {
            TreeNode floorNode = floor(node.left, e);
            return floorNode;
        } else {
            TreeNode t = floor(node.right, e);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        }
    }


    /**
     * 获取比e大的最小值
     *
     * @param
     * @return
     */
    private TreeNode ceil(TreeNode node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo((E) node.e) == 0) {
            return node;
        } else if (e.compareTo((E) node.e) > 0) {
            TreeNode ceilNode = ceil(node.right, e);
            return ceilNode;
        } else {
            TreeNode ceilNode = ceil(node.left, e);
            if (ceilNode != null) {
                return ceilNode;
            } else {
                return node;
            }
        }
    }

    public TreeNode ceil(E e) {
        return ceil(root, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(TreeNode node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    /**
     * @return all keys in the symbol table
     */
    public Iterable<E> keys() {
        return keys(minimum(), maximum());
    }

    public Iterable<E> keys(E lo, E hi) {
        LinkedList<E> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(TreeNode x, LinkedList<E> queue, E lo, E hi) {

        if (x == null)
            return;

        int cmplo = lo.compareTo((E) x.e);
        int cmphi = hi.compareTo((E) x.e);

        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.add((E) x.e);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
        System.out.println();
        System.out.println(bst.keys());

        // bst.remove(5);
        // System.out.println(bst);
        System.out.println(bst.floor(7).e);

//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//
//        int n = 10000;
//
//        for (int i = 0; i < n; i++)
//            bst.add(random.nextInt(n));
//
//        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的
//
//        // order数组中存放[0...n)的所有元素
//        Integer[] order = new Integer[n];
//        for (int i = 0; i < n; i++)
//            order[i] = i;
//        // 打乱order数组的顺序
//        shuffle(order);
//
//        // 乱序删除[0...n)范围里的所有元素
//        for (int i = 0; i < n; i++)
//            if (bst.contains(order[i])) {
//                bst.remove(order[i]);
//                System.out.println("After remove " + order[i] + ", size = " + bst.size());
//            }
//
//        // 最终整个二分搜索树应该为空
//        System.out.println(bst.size());
    }


}
