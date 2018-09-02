package medium;

/**
 * Created by mns on 8/9/18.
 */
public class PlusOneLinkedList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode plusOne(ListNode head) {
            if(head == null) return null;
            ListNode rev = reverse(head);
            ListNode ptr = rev, pre=rev;
            int carry = 1;
            while(ptr!=null){
                carry += ptr.val;
                ptr.val = carry%10;
                carry = carry/10;
                pre = ptr;
                ptr = ptr.next;
            }

            if(carry != 0){
                pre.next = new ListNode(carry);
            }

            return reverse(rev);

        }

        private ListNode reverse(ListNode head){
            ListNode ptr = head, newHead = head;
            while(ptr != null){
                ListNode tmp = ptr.next;
                ptr.next = newHead;
                newHead = ptr;
                ptr = tmp;
            }

            head.next = null;
            return newHead;
        }
    }
}
