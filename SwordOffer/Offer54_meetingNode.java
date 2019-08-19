package Offer;

/**
 * 一个链表中包含环，如何找出环的入口节点
 */

public class Offer54_meetingNode {
    private static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(){

        }
        public ListNode(int value){
            this.val = value;
        }

        @Override
        public String toString(){
            return val + "";
        }
    }

    /**
     * 判断链表是否存在环，是则获取环中一个节点
     * @param head
     * @return
     */
    public static ListNode meetingNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                break;
            }
        }

        //不存在环
        if(fast == null || fast.next == null){
            return null;
        }

        //返回环中的一个节点
        return fast;
    }

    /**
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode meetingNode = meetingNode(pHead);
        if(meetingNode == null){
            return null;
        }

        //确定环中节点数目
        int nodesInLoop = 1;
        ListNode p1 = meetingNode;
        while(p1.next != meetingNode){
            p1 = p1.next;
            ++nodesInLoop;
        }

        //p1先走 nodesInLoop 步
        p1 = pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1 = p1.next;
        }

        //p1和p2同步走，相遇时候，就是环的入口节点
        ListNode p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
