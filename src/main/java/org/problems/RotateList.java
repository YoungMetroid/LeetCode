package org.problems;

public class RotateList {
    ListNode head;
    int count;
    boolean setNull = false;
    public static void main (String ...args){
        RotateList rotateList = new RotateList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        node1 = rotateList.rotateRight(node1,4);
        System.out.println();
    }
    public ListNode rotateRight(ListNode head, int k) {
        int nodeCount = 1;
        this.head = head;
        if(k == 1){
            return head;
        }
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            nodeCount++;
        }
        if(k <= nodeCount){
            count = k;
        }
        else {
            count = k % nodeCount;
        }

        rotate(head);
        return this.head;
    }
    public void rotate(ListNode node){
        if(node == null) return;
        rotate(node.next);
        if(count > 0){
            node.next = head;
            head = node;
            count--;
        }
        else if(!setNull && count == 0){
            node.next = null;
            setNull = true;
        }

    }
}
