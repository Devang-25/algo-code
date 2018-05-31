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
public class MergeLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = null, head =null;
        tail = new ListNode(Integer.MAX_VALUE);
        head = tail;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if(l1 ==null){
            while(l2!=null){
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
                tail = tail.next;
                
            }
        }
        
        if(l2 ==null){
            while(l1!=null){
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
                tail = tail.next;
                
            }
        }
        return head.next;
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
        tail.next = new ListNode(3); tail = tail.next;
        tail.next = new ListNode(4); tail = tail.next;

        ListNode tail1 = new ListNode(1);
        ListNode head1 = tail1;
        tail1.next = new ListNode(4); tail1 = tail1.next;
        tail1.next = new ListNode(5); tail1= tail1.next;
        tail1.next = new ListNode(7); tail1 = tail1.next;
        
        MergeLinkedLists ml = new MergeLinkedLists();
        ListNode result = ml.mergeTwoLists(head, head1);
        
        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }
        
        System.out.println("---------------");
        result = ml.mergeTwoListsInPlace(head, head1);
        while(result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
