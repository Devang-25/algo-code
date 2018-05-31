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
public class PartitionList {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode outFront = new ListNode(-1);
        ListNode outBack = new ListNode(-1);
        ListNode outFrontPtr = outFront;
        ListNode outBackPtr = outBack;
        ListNode ptr = head;

        while (ptr != null) {
            if (ptr.val < x) {
                outFrontPtr.next = ptr;
                outFrontPtr = outFrontPtr.next;
            } else {
                outBackPtr.next = ptr;
                outBackPtr = outBackPtr.next;
            }

            ptr = ptr.next;

        }

        outFrontPtr.next = outBack.next;
        outBackPtr.next = null;
        return outFront.next;
    }
}
