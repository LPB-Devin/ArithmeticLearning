package Offer;

public class Offer16_mirror {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 递归实现二叉树镜像反转
     * @param root
     */
    public static void mirror(BinaryTreeNode root){
        if(root != null){
            BinaryTreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirror(root.left);
            mirror(root.right);
        }
    }

    public static void main(String args[]){

    }
}
