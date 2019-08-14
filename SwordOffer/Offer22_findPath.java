package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数N，打印出二叉树中节点值的和为N的所有路径。
 * 注：从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 *
 */
public class Offer22_findPath {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 对root节点进行判空，
     * @param root
     * @param Sum
     */
    public static void findPath(BinaryTreeNode root,int Sum){
        List<Integer> list = new ArrayList<>();
        if(root != null){
            findPath(root,0,Sum,list);
        }
    }

    private static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result) {
        if(root!=null){
            curSum += root.value;

            result.add(root.value);

            if(curSum < expectedSum){
                findPath(root.left,curSum,expectedSum,result);

                findPath(root.right,curSum,expectedSum,result);
            }
            else if(curSum == expectedSum){
                if(root.left == null && root.right == null){
                    System.out.println(result);
                }
            }

            result.remove(result.size() - 1);
        }
    }
}
