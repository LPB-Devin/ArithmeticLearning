package Offer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树的每个节点，同一层的节点按照从左向右的顺序打印（层序遍历）
 */
public class Offer20_printFromToBottom {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(){

        }
        public BinaryTreeNode(int value){
            this.value = value;
        }
    }

    /**
     * 使用队列 先进先出 的思想去实现，每次读取一个节点，判断其左右子节点是否存在
     * @param root
     */
    public static void printFromTopToBottom(BinaryTreeNode root){
        LinkedList<BinaryTreeNode> helpQueue = new LinkedList<>();

        if(root!=null){
            helpQueue.addLast(root);
//            addSubNodeToQueue(helpQueue,root);
        }else{
            throw new RuntimeException("The Tree is Null !");
        }


        while(!helpQueue.isEmpty()){
            printBinaryTreeNode(helpQueue);
//            System.out.print((helpQueue).pollFirst() + " ");
        }

    }

    /**
     * 队列链表中的元素为 二叉树节点
     * 对该节点的子节点的有无情况进行判断，如有则从左往右进行入队操作
     * @param helpQueue
     */
    private static void printBinaryTreeNode(LinkedList<BinaryTreeNode> helpQueue) {
        if(helpQueue.peekFirst().left != null){
            helpQueue.addLast(helpQueue.peekFirst().left);
        }
        if(helpQueue.peekFirst().right!= null){
            helpQueue.addLast(helpQueue.peekFirst().right);
        }
        System.out.print(helpQueue.pollFirst().value + " ");
    }

    /**
     * 将链表中的每个节点设为Integer操作繁杂，且没有面向对象的思维，将对象中的属性单独提取出来操作了
     *
     * @param helpQueue
     * @param root
     */
    private static void addSubNodeToQueue(LinkedList<Integer> helpQueue, BinaryTreeNode root) {
//        helpQueue.addLast(root.value);
        if(root.left!=null){
            helpQueue.addLast(root.left.value);

        }
        if(root.right!=null){
            helpQueue.addLast(root.right.value);

        }

        if(root.left!=null){
            addSubNodeToQueue(helpQueue,root.left);
        }
        if(root.right!=null){
            addSubNodeToQueue(helpQueue,root.right);
        }
    }

    public static void main(String args[]){
        BinaryTreeNode root = new BinaryTreeNode(0);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(6);

        printFromTopToBottom(root);
    }
}
