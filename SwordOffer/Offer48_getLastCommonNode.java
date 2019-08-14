package Offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出树中两个节点的最低公共祖先。
 * 注：此树不是二叉树，且没有指向父节点的指针
 */
public class Offer48_getLastCommonNode {
    private static class TreeNode{
        int value;

        List<TreeNode> children = new LinkedList<>();

        public TreeNode(){

        }

        public TreeNode(int val){
            this.value = val;
        }

        @Override
        public String toString(){
            return value + "";
        }
    }

    /**
     * 获取从root节点到target节点的路径并存入链表path中
     * @param root
     * @param target
     * @param path
     */
    public static void getNodePath(TreeNode root,TreeNode target,
                                   List<TreeNode> path){
        if(root == null){
            return ;
        }

        path.add(root);
        List<TreeNode> children = root.children;

        for(TreeNode node:children){
            if(node == target){
                path.add(node);
                return;
            }else{
                getNodePath(node,target,path);
            }

        }
        path.remove(path.size() -1);
    }

    /**
     * 找出两条路径中的最后一个公共节点
     *
     * @param p1
     * @param p2
     * @return
     */
    public static TreeNode getLastCommonNode(List<TreeNode> p1,List<TreeNode> p2){
        Iterator<TreeNode> ite1 = p1.iterator();
        Iterator<TreeNode> ite2 = p2.iterator();
        TreeNode last = null;

        while(ite1.hasNext() && ite2.hasNext()){
            TreeNode tmp = ite1.next();
            if(tmp == ite2 .next()){
                last = tmp;
            }
        }
        return last;
    }

    /**
     * 找最近公共祖先
     *
     * @param root
     * @param p1
     * @param p2
     * @return
     */
    public static TreeNode getLastCommonParent(TreeNode root,TreeNode p1,TreeNode p2){
        if(root == null || p1 == null || p2 == null){
            return null;
        }

        List<TreeNode> path1 = new LinkedList<>();
        getNodePath(root,p1,path1);

        List<TreeNode> path2 = new LinkedList<>();
        getNodePath(root,p2,path2);

        return getLastCommonNode(path1,path2);
    }
}
