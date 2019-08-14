package Offer;

public class Offer36_treeDepth {
    public class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
    }
    public static int treeDepth(BinaryTree root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left>right ? left+1 : right+1;
    }
}
