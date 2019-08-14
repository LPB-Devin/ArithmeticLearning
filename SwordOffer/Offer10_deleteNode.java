package Offer;

/**
 * 给定单向链表的一个头指针和节点指针，定义一个函数再O（1）时间删除节点
 *
 */
public class Offer10_deleteNode {

    public static class ListNode{
        int value;
        ListNode next;

        public ListNode(){

        }

        public ListNode(int i){
            this.value = i;
        }
    }

    /**
     * 注意：
     * 1、在剑指offer中并没有返回值，因为Java中的引用传递，如果删除的节点是头节点，
     *      如果不采用返回值的话，头节点永远删除不了
     *
     * 2、输入的待删除节点必须是链表中的节点，否则会引起错误
     * @param head          链表头节点
     * @param toBeDeletedNode   待删除的节点
     * @return      删除后的头节点
     */
    public static ListNode deleteNode(ListNode head,ListNode toBeDeletedNode){

        //链表头节点以及被删除节点为null情况
        if(head == null || toBeDeletedNode == null){
            return head;
        }

        //如果被删除的头节点，直接返回头节点的下一个节点
        if(head == toBeDeletedNode){
            return head.next;
        }


        //多个节点的情况下，如果删除的是最后一个元素
        if(toBeDeletedNode.next == null){
            //寻找toBeDeletedNode节点的前驱
            ListNode tmp = head;
            while(tmp.next != toBeDeletedNode){
                tmp = tmp.next;
            }

            //删除该节点
            tmp.next = null;
        }
        //如果toBeDeletedNode是某个中间节点
        else{
            //将下个节点的值输入当前待删除的节点
            toBeDeletedNode.value = toBeDeletedNode.next.value;
            //待删除节点的下一个指向原先待删除节点的下下个节点，即将待删除的下一个节点删除
            toBeDeletedNode.next = toBeDeletedNode.next.next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(0);
        for(int i=10;i>0;i--){
            if(head.next == null){
                head.next = new ListNode(i);
            }
            else{
                ListNode temp = new ListNode(i);
                temp.next = head.next;
                head.next = temp;
            }
        }
        ListNode Node = deleteNode(head,new ListNode(5));
        while(Node!=null){
            System.out.println(Node.value);
        }
    }
}
