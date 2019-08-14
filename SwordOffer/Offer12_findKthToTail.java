package Offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 尾节点设为倒数第1个节点
 *
 */
public class Offer12_findKthToTail {

    public static class ListNode{
        int value;
        ListNode next;

        public ListNode(){

        }

        public ListNode(int val){
            this.value = val;
        }
    }
    /**
     *用两个指针，一个指针先走k-1步，之后两个指针同步走，直到先走的指针的next为null
     *
     * @param head
     * @param k
     */
    public static int findKthToTail(ListNode head,int k){
        if(head==null || k<0){
            throw new RuntimeException();
        }
        ListNode pre = head;
        for(int i=1;i<=k-1;i++){
//            if(pre.next==null && i!=k-1){
//                throw new RuntimeException("k is too larger");
//            }
//            pre = pre.next;
            if(pre.next != null){
                pre = pre.next;
            }
            else{
                throw new RuntimeException("k is too larger");
            }
        }
        ListNode index = head;
        while(pre.next!=null){
            pre = pre.next;
            index = index.next;
        }
        return index.value;
    }

    public static void main(String args[]){
        ListNode head = new ListNode();
        head.value = 0;
        for(int i=10;i>0;i--){
            ListNode temp = new ListNode(i);
            temp.next = head.next;
            head.next = temp;
        }
        System.out.println(findKthToTail(head,5));
    }
}
