package Offer;

/**
 * 输入两个递增排序的链表，合并这两个链表，使新链表中的节点仍然是按照递增排序的
 *
 */
public class Offer14_merge {
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
     * 实例化一个新的链表，将value较小的头节点尾插入新链表，如此进行循环比较和插入
     * 当其中一个链表为空时，将另外的链表剩余部分直接插入新链表尾部
     * @param head1 两个有序链表
     * @param head2
     * @return  合并后的有序链表头
     */
    public static ListNode merge(ListNode head1,ListNode head2){
        //判断两头节点是否至少有一个为空
        if(head1 == null)
            return head2;

        if(head2 == null)
            return head1;

        //实例化新链表头节点
        ListNode head = new ListNode();
        //pointer指向新链表尾部节点
        ListNode pointer = head;

        //循环比较、插入
        while(head1 != null && head2 != null){
            if(head1.value > head2.value){
                pointer.next = head2;
                head2 = head2.next;
            }else{
                pointer.next = head1;
                head1 = head1.next;
            }
            pointer = pointer.next;
        }

        if(head1==null){
            pointer.next = head2;
        }else{
            pointer.next = head1;
        }

        return head;
    }


    public static void main(String args[]){
        ListNode head1 = new ListNode(0);

        ListNode head2 = new ListNode(0);
        for(int i=10;i>0;i--){
            ListNode temp1 = new ListNode(i);
            temp1.next = head1.next;
            head1.next = temp1;

            ListNode temp2 = new ListNode(i);
            temp2.next = head2.next;
            head2.next = temp2;
        }
        ListNode head = merge(head1,head2);
        while(head!=null){
            System.out.println(head.value + " ");
            head = head.next;
        }

    }
}
