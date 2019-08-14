package Offer;

import java.util.Stack;

/**
 * 输入链表的头节点，从尾巴到头反过来输出每个节点的值
 */
public class Offer03_PrintList_Inversely {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 利用栈“先进后出”的特点实现
     *
     * @param root
     */
    public static void printListInverselyUsingInteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        ListNode temp = new ListNode();
        while (!stack.empty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
        }
        System.out.println();
    }

    /**
     * 利用递归的方式实现链表反向输出
     *
     * @param root
     */
    public static void printListInverselyUsingRecursion(ListNode root) {

        if(root == null)
            return ;
        if (root != null) { //这里使用if判断是否需要进行递归操作，切忌用while循环！
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
        System.out.println();
    }


    public static void main(String args[]) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        for (int i = 0; i < 9; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        printListInverselyUsingRecursion(root);
//        printListInverselyUsingRecursion(root);
        printListInverselyUsingInteration(root);
    }
}
