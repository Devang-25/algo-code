/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class RotateList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        
        int length = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr = ptr.next;
            length++;
        }
        
        k=k%length;
        if(k==0){
            return head;
        }
        ptr = head;
        ListNode joinHead = ptr;
        ListNode newHead = null;
        ListNode joinTail = null;
        
        int count = 0;
        while(count < length){
            if(count == length-k){
                newHead = ptr;
            }else if(count == length-k-1){
                joinTail = ptr;
            }
            count++;
            if(count < length)
                ptr= ptr.next;
        }
        
        ptr.next = joinHead;
        joinTail.next = null;
        
        return newHead;
    }
    
    public void print(ListNode x){
        ListNode ptr = x;
        while(ptr!=null){
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) {
        RotateList r = new RotateList();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        
        //r.print(l);
        r.print(r.rotateRight(l, 9999));
    }
}
