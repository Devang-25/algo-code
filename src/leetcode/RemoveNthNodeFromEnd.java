/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class RemoveNthNodeFromEnd {

    static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = null;
        int total = 0, passed = 0;

        while (curr.next != null) {
            total++;
            curr = curr.next;
        }
        
        curr = head;
        while(passed != total - n+1){
            prev = curr;
            curr = curr.next;
            passed++;
        }
        
        if(prev != null){
            prev.next = curr.next;
            return head;
        }else{
            return head.next;
        }
        
    }
}
