package Offer;

/**
 * 在一个排序的链表中，如何删除重复的节点。
 */
public class Offer55_DeleteDuplication {
    public static class ListNode{
        int value;
        ListNode next;
    }
    public static ListNode deleteDuplication(ListNode pHead){
        ListNode first = new ListNode();

        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        //比较的前提，p节点和下一节点不为空
        while(p != null && p.next != null){
            if(p.value == p.next.value){
                int val = p.value;
                //判断后面是否还存在重复节点
                while(p != null && p.value == val){
                    p = p.next;
                }
                last.next = p;
            }else{
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
