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
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode pA = headA, pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }

        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;

        if (lenA > lenB) {
            int offset = lenA - lenB;
            int count = 0;
            while (count++ < offset) {
                pA = pA.next;
            }
        } else {
            int offset = lenB - lenA;
            int count = 0;
            while (count++ < offset) {
                pB = pB.next;
            }
        }

        ListNode returnNode = null;
        while (pA != null && pB != null) {
            if (pA.val == pB.val) {
                returnNode = pA;
                break;
            } else {
                pA = pA.next;
                pB = pB.next;
            }
        }

        return returnNode;

    }
}
