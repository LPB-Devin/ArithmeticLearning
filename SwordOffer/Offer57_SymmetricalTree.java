package Offer;

/**
 * 对称的二叉树
 * 请实现一个函数来判断一棵二叉树是不是对称的。ps：如果一棵二叉树与它自身的
 * 镜像一样，那么它是对称的
 */
public class Offer57_SymmetricalTree {
    private static class BinaryTreeNode{
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(){

        }

        public BinaryTreeNode(int val){
            this.val = val;
        }
        @Override
        public String toString(){
            return val+"";
        }
    }

    public static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root,root);
    }

    private static boolean isSymmetrical(BinaryTreeNode left,BinaryTreeNode right){
        //
        if(left == null && right == null){
            return true;
        }
        //left和right其中一个为空
        if(left == null || right == null){
            return false;
        }
        //不等于，返回false
        if(left.val != right.val){
            return false;
        }
        //左左与右右比较，左右与右左比较
        return isSymmetrical(left.left,right.right)
                && isSymmetrical(left.right,right.left);
    }
}
