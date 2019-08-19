package Offer;

/**
 * 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 注：树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父节点的指针。
 */
public class Offer56_getNextNode {
    private static class BinaryTreeNode{
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;

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

    /**
     *
     * @param node  二叉树中的一个节点
     * @return      中序遍历中该节点的下一节点
     */
    public static BinaryTreeNode getNext(BinaryTreeNode node){
        if(node == null){
            return null;
        }

        BinaryTreeNode target = null;

        if(node.right != null){ //存在右子树，则返回右子树中的最左叶子节点
            target = node.right;
            while(target.left != null){
                target = target.left;
            }

            return target;
        }else if(node.parent != null){  //节点node的右节点为null，且存在父节点
            target = node.parent;
            BinaryTreeNode cur = node;
            //父节点不为空，且子节点不为父节点的左孩子，则再继续循环
            while(target != null && target.left != cur){
                cur = target;
                target = target.parent;
            }
            return target;
        }
        return null;
    }
}
