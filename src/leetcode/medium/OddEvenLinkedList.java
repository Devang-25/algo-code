package leetcode.medium;

import java.util.List;

public class OddEvenLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode oddEvenList(ListNode head) {
        ListNode sent1 = new ListNode(0);
        ListNode sent2 = new ListNode(2);
        ListNode curr = head, curr1 = sent1, curr2= sent2;

        while(curr!=null){
            curr1.next = curr;
            curr2.next = curr.next;
            curr1 = curr1.next; curr2 = curr2.next;
            if(curr.next != null) {
                curr = curr.next.next;
            }else{
                break;
            }
        }

        curr1.next = sent2.next;
        return sent1.next;
    }
}
