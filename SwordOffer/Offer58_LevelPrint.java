package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历
 * 从上往下按层遍历二叉树，同一层的节点按从左到右的顺序打印，每一层打印一行。
 *
 */
public class Offer58_LevelPrint {
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
            return val + "";
        }
    }

    /**
     * 普通层次遍历，全部输出为一行
     * @param root
     */
    public static void levelPrint(BinaryTreeNode root){
        if(root == null){
            throw new IllegalArgumentException("The Tree is Null~");
        }
        LinkedList<BinaryTreeNode> list = new LinkedList<>();

        list.add(root);
        BinaryTreeNode node;
        while(!list.isEmpty()){
            node = list.remove(0);
            System.out.print(node.val +" ");
            //左子树不为空，存入
            if(node.left != null){
                list.push(node.left);
            }
            //右子树不为空，存入
            if(node.right != null){
                list.push(node.right);
            }

        }
    }

    /**
     * 每一层输出一行
     * 用两个变量：currentLevelNodes和nextLevelNodes分别表示当前层和下一层的节点个数
     * @param root
     */
    public  static  void    print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        List<BinaryTreeNode> list = new LinkedList<>();
        BinaryTreeNode node;
        // 当前层的结点个数
        int currentLevelNodes = 1;
        // 记录下一层的结点个数
        int nextLevelNodes = 0;
        list.add(root);
        while (list.size() > 0) {
            node = list.remove(0);
            currentLevelNodes--;
            System.out.printf("%-3d", node.val);
            //左子树不为空，存入，next+1
            if (node.left != null) {
                list.add(node.left);
                nextLevelNodes++;
            }
            //右子树不为空，存入，next+1
            if (node.right != null) {
                list.add(node.right);
                nextLevelNodes++;
            }
            //当前层节点已全部输出
            if (currentLevelNodes == 0) {
                System.out.println();
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
    }
}
