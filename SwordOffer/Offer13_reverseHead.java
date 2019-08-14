package Offer;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的节点，反转该链表并输出反转后链表的头节点
 */
public class Offer13_reverseHead {
    public static class Node{
        int value;
        Node nextNode;

        public Node(){

        }
        public Node(int val){
            this.value = val;
            this.nextNode = null;
        }
    }
    public static Node reverseHead(Node head){
        if(head==null){
            throw new RuntimeException("the Node is Null!");
        }
        Node pre = head;
        Node after = head.nextNode;
        Node next = null;
        while(after.nextNode != null){
            next = after.nextNode;
            after.nextNode = pre;
            pre = after;
            after = next;
        }
        head.nextNode = null;
        head = after;
        return head;
    }

    public static void main(String args[]){
        Node head = new Node(0);
        for(int i=10;i>0;i--){
            Node temp = new Node(i);
            temp.nextNode = head.nextNode;
            head.nextNode = temp;
        }
        System.out.println(head.value+ " " + reverseHead(head).value);
    }
}
