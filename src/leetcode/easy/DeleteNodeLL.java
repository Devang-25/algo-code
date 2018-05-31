/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class DeleteNodeLL {

    //Definition for singly-linked list.
    static public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {

        if (node != null) {
            ListNode curr = node;
            ListNode prev = null;
            while (curr.next != null) {
                curr.val = curr.next.val;
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
    }
    
    public static void main(String[] args) {
        DeleteNodeLL d = new DeleteNodeLL();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        
        ListNode ptr = l;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
        d.deleteNode(l);
        ptr = l;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}
