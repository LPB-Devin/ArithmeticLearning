package Offer;

/**
 * 实现一个函数ComplexListNode clone ，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个next指向下一节点之外，还有一个sibling指向链表中的
 * 任意节点或者null
 */
public class Offer23_NOcloneComplexListNode {
    /**
     * 复杂链表节点
     */
    public static class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     *
     * @param head
     * @return
     */
    public static ComplexListNode clone(ComplexListNode head){
        if(head == null){
            return null;
        }

        cloneNodes(head);
        connectNodes(head);
        return reconnectNodes(head);
    }

    /**
     * 复制next
     * @param head
     */
    private static void cloneNodes(ComplexListNode head) {
        while(head != null){
            ComplexListNode temp = new ComplexListNode();
            temp.value = head.value;
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
    }

    private static void connectNodes(ComplexListNode head){
        while (head!=null){
            if(head.sibling != null){
                head.next.sibling = head.sibling.next;
            }
        }
        head = head.next.next;
    }

    private static ComplexListNode reconnectNodes(ComplexListNode head){
        if(head == null){
            return  null;
        }

        ComplexListNode newHead = head.next;
        ComplexListNode pointer = newHead;

        head.next = newHead.next;

        while(head!=null){
            pointer.next = head.next;
            pointer = pointer.next;
            head.next = pointer.next;
            head = pointer.next;
        }
        return newHead;
    }

}
