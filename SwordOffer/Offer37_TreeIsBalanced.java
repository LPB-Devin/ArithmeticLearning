package Offer;

public class Offer37_TreeIsBalanced {
    public class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public static int TreeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left +1:right+1;
    }

    public static boolean isBalanced(BinaryTreeNode root){
        if(root == null){
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        int diff = Math.abs(left - right);

        if(diff > 1){
            return false;
        } else
            return isBalanced(root.left) && isBalanced(root.right);

    }
}
