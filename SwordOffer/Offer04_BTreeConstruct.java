package Offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * **假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer04_BTreeConstruct {
    public static class BinaryTree{
        int val;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(){

        }
        public BinaryTree(int val){
            this.val = val;
        }
    }

    /**
     *
     * @param preorder 前序遍历序列
     * @param inorder   中序遍历序列
     * @return  二叉树根节点
     */
    public static BinaryTree Construct(int[] preorder,int[] inorder){
        //输入合法性判断，前中序列数组不为空，且长度相同
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }

        return Construct(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    /**
     *
     * @param preorder  前序遍历
     * @param prestart  前序开始位置
     * @param preend    前序结束位置
     * @param inorder   中序遍历
     * @param instart   中序开始位置
     * @param inend     中序结束位置
     * @return
     */
    private static BinaryTree Construct(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        //前序开始位置大于结束位置
        if(prestart>preend){
            return null;
        }
        //取前序遍历的第一个数字，即当前的根节点
        int value = preorder[prestart];
        int index = instart;

        //在中序遍历数组中找根节点的位置
        while(index<=inend && inorder[index]!=value){
            index++;
        }
        if(index>inend)
            throw new RuntimeException("Invalid input");

        BinaryTree root = new BinaryTree(value);

        //左子树递归
        root.left = Construct(preorder,prestart+1,prestart+index-instart,inorder,instart,index-1);

        //右子树递归
        root.right = Construct(preorder,prestart+index-instart+1,preend,inorder,index+1,inend);

        return root;
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTree root = Construct(pre,in);
        PrintBTree(root);
    }

    private static void PrintBTree(BinaryTree root) {
        if(root==null)
            return;
        System.out.print(root.val + " ");
        PrintBTree(root.left);
        PrintBTree(root.right);
    }
}
