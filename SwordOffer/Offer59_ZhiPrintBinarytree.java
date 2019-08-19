package Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照“之”字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，即第一行按照从左到右的顺序打印，第二层按照
 * 从右到左的顺序打印，第三行按照从左到右的顺序打印，其他以此类推
 */
public class Offer59_ZhiPrintBinarytree {
    public static class BinaryTreeNode{
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(){

        }
        public BinaryTreeNode(int val){
            this.val = val;
        }
    }

    public static void print(BinaryTreeNode root){
        if(root == null){
            return;
        }
        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while(current.size()>0){
            node = current.remove(current.size()-1);

            System.out.print(node.val);

            if(flag == 0){  //flag == 0 时，从左往右打印
                if(node.left != null){
                    reverse.add(node.left);
                }
                if(node.right != null){
                    reverse.add(node.right);
                }
            }else{          //flag == 1 时，从右往左打印
                if(node.right != null){
                    reverse.add(node.right);
                }
                if(node.left != null){
                    reverse.add(node.left);
                }
            }

            //当前层current 空了，flag变化，并取下一层
            if(current.size() == 0){
                flag = 1- flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }
}
