package Offer;

/**
 * 输入两个链表,找出他们的第一个公共节点.
 */
public class Offer34_findFirstCommonNode {
    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int value){
            this.val = value;
        }

        @Override
        public String toString(){
            return val +"";
        }
    }

    /**
     * 找两个结点的第一个公共结点，如果没有找到返回null，方法比较好，考虑了 两个链表中有null的情况
     * @param head1
     * @param head2
     * @return  找到的公共节点
     */
    public static ListNode findFirstCommonNode(ListNode head1,ListNode head2){

        if(head1 == null || head2 == null){
            return null;
        }
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);

        int diff = length1 - length2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;

        if(diff < 0){
            longListHead = head2;
            shortListHead = head1;
            diff = length2 - length1;
        }

        for(int i=0;i<diff;i++){
            longListHead = longListHead.next;
        }
        while(longListHead != null && shortListHead != null && longListHead != shortListHead){
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        return longListHead;
    }

    private static int getListLength(ListNode head) {
        int result = 0;
        while(head != null){
            result ++;
            head = head.next;
        }

        return result;
    }

    public static void main(String args[]){

    }
}
