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
public class SortList {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoListsInPlace(l1, l2);
    }
    
    public ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode tail = head;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail.next.next = null;
            }else{
                tail.next = l2;
                l2 = l2.next;
                tail.next.next = null;
            }
            tail = tail.next;
        }
        
        if(l1 ==null){
            tail.next = l2;
        }
        
        if(l2 == null){
            tail.next = l1;
        }
        
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode tail = new ListNode(1);
        ListNode head = tail;
        tail.next = new ListNode(2); tail = tail.next;
        tail.next = new ListNode(4); tail = tail.next;
        tail.next = new ListNode(5); tail = tail.next;
        tail.next = new ListNode(3); tail = tail.next;
        tail.next = new ListNode(2); tail= tail.next;
        tail.next = new ListNode(1); tail = tail.next;
        
        SortList sl = new SortList();
        ListNode result = sl.sortList(head);
        
        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
        
}
