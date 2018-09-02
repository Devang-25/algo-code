package medium;

/**
 * Created by mns on 8/9/18.
 */
public class AddTwoNumbers2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;

        ListNode l1Rev = reverse(l1);
        ListNode l2Rev = reverse(l2);
        ListNode ptr1 = l1Rev, ptr2 = l2Rev;
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode result1 = result;
        while(ptr1!=null || ptr2!=null){
            int val1 = 0, val2 = 0;
            if(ptr1!=null){
                val1 = ptr1.val;
                ptr1 = ptr1.next;
            }
            if(ptr2!=null){
                val2 = ptr2.val;
                ptr2 = ptr2.next;
            }
            carry += val1 + val2;
            result.next = new ListNode(carry%10);
            carry /= 10;
            result = result.next;
        }

        if(carry != 0){
            result.next = new ListNode(carry);
        }
        return reverse(result1.next);
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
