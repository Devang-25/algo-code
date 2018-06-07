package leetcode.medium;

public class SwapNodesInPair {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 1-2-3-4-5-6  ====> 2-1-4-3-6-5
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }


        ListNode curr = head,prevCurr = new ListNode(0), newHead = head.next;;

        while(curr!=null && curr.next != null){
            ListNode nextNext = curr.next.next;
            curr.next.next = curr;
            prevCurr.next = curr.next;
            curr.next = nextNext;
            prevCurr = curr;
            curr = curr.next;
        }

        return newHead;
    }

}
