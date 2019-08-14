package Offer;

/**
 * 一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求：不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Offer24_ConvertList {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     *
     * @param root 二叉树的根节点
     * @return      双向链表的头节点
     */
    public static BinaryTreeNode convert(BinaryTreeNode root){
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(root,lastNode);

        BinaryTreeNode head = lastNode[0];
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    /**
     * 链表转换操作
     * @param node  当前根节点
     * @param lastNode
     */
    private static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        //判断节点不为null
        if(node != null){

            //如果左子树不为空，先处理左子树
            if(node.left != null){
                convertNode(node.left,lastNode);
            }

            //将 当前节点前驱 指向 已处理好的双向链表（当前节点的左子树）的尾节点
            node.left = lastNode[0];


            if(lastNode[0] != null){
                lastNode[0].right = node;
            }

            //记录当前节点为尾节点
            lastNode[0] = node;

            //处理右子树
            if(node.right != null){
                convertNode(node.right , lastNode);
            }
        }
    }

    public static void main(String args[]){

    }

}
