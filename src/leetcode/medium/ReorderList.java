package leetcode.medium;

import java.util.Stack;

/**
 * Created by mns on 8/9/18.
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode curr = head;
        Stack<ListNode> stk = new Stack<>();
        while (curr != null) {
            stk.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (stk.peek() != curr && stk.peek() != curr.next) {
            ListNode curr_next = curr.next;
            ListNode tail = stk.pop();
            curr.next = tail;
            tail.next = curr_next;
            curr = curr_next;
        }
        stk.peek().next = null;
        return;
    }


    void print(ListNode l) {
        ListNode tmp = l;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
