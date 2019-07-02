package com.wangzhou.datastructure.linkedlist.solution;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/4/22
 * Time:16:16
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t1.right);
        return t1;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        int maxIndex = findMaxofNums(nums);
        int[] left = subInt(nums, 0, maxIndex);
        int[] right = subInt(nums, maxIndex + 1, nums.length);
        TreeNode head = new TreeNode(nums[maxIndex]);
        head.left = constructMaximumBinaryTree(left);
        head.right = constructMaximumBinaryTree(right);
        return head;
    }

    public int findMaxofNums(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        int max = nums[index];
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public int[] subInt(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        int[] newInt = new int[end - start];
        for (int i = 0; i < newInt.length; i++) {
            newInt[i] = nums[start + i];
        }
        return newInt;
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        int i = 1;
        int length = nums.length;
        TreeNode root = new TreeNode(nums[0]);//创建根节点为第一个数
        TreeNode t = null;//用来创建新结点
        TreeNode b = null;//用来存放nums[i] < root.val 下右侧节点
        for (; i < length; i++) {
            t = new TreeNode(nums[i]);
            if (nums[i] > root.val) {//如果当前的nums[i]>root.val,把旧的根节点是新的根节点的左子树
                t.left = root;
                root = t;
            } else {//如果当前的nums[i]<root.val(没有等于的请况)
                b = root;
                while (b.right != null) {
                    if (b.right.val < t.val) {  //如果有小于的t的节点，跳出循环
                        break;
                    } else
                        b = b.right;//因为当前的t是最后侧的，所以不去和b.left去比较
                }
                t.left = b.right;//循环结束后当前b的右子树是t的左子树，无论b.rigth是否为空
                b.right = t;//t成为新的b的右子树
            }
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next.next = deleteDuplicates(head.next);
        if (head.next.val == head.val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firsthead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return firsthead;
    }

    private int maxL = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxL(root, root.val);
        return maxL;
    }

    private int getMaxL(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = getMaxL(root.left, root.val);
        int right = getMaxL(root.right, root.val);
        maxL = Math.max(maxL, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
    public static int binarySearch(int[] arr, int k) {
        int a=0;
        int b=arr.length;

        while (a<b){
            int  m=a+(b-a)/2;
            if(arr[m]>k){
                b=m;
            }else if(arr[m]<k){
                a=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
