package leetcode.easy;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode r = head;
        int n = 0,k=0;
        while(r!=null){
            n++;
            r = r.next;
        }
        n = n/2;
        r = head;
        while(k < n){
            r = r.next;
            k++;
        }
        return r;
    }
}
