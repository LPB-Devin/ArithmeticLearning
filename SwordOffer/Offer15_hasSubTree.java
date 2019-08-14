package Offer;

/**
 * 输入两棵二叉树A和B、判断B是不是A的子结构
 */
public class Offer15_hasSubTree {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

    }

    /**
     *  在A树中先找到一个与B树根节点相等的元素节点，之后从这个节点开始判断B树是不
     * 是A树的子结构，如果找到其中一处结构不同则返回false，直到所有节点都找完为止。
     * @param rootA
     * @param rootB
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode rootA,BinaryTreeNode rootB){
        if(rootA == rootB){
            return true;
        }
        //null树是所有树的子树
        if(rootB == null){
            return true;
        }
        //B树不为null，但A树为null，返回false
        if(rootA == null){
            return false;
        }

        //记录匹配结果
        boolean result = false;

        if(rootA.value == rootB.value){
            result = match(rootA,rootB);
        }

        if(result == true){
            return true;
        }

        return hasSubTree(rootA.left,rootB)||hasSubTree(rootA.right,rootB);

    }

    private static boolean match(BinaryTreeNode rootA, BinaryTreeNode rootB) {

        //？同一个对象实例，返回true
        if(rootA == rootB) {
            return true;
        }

        if(rootB == null){
            return true;
        }
        //B树根节点不为空，但A树根节点为空，false
        if(rootA == null){
            return false;
        }

        //两个节点的值相等，则分别对其左右子节点进行判断
        if(rootA.value == rootB.value){
            return match(rootA.left,rootB.left) && match(rootA.right , rootB.right);
        }
        return false;
    }

    public static void main(String args[]){

    }

}
