package easy;

import java.util.ArrayList;

/**
 * Created by mns on 8/6/18.
 */
public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList2(ListNode head){
        if(head == null){
            return null;
        }

        ArrayList<ListNode> cache = new ArrayList<>();
        ListNode runner = head;
        while(runner != null){
            cache.add(runner);
            runner = runner.next;
        }

        ListNode result = cache.get(cache.size()-1);
        runner = result;
        for(int i=cache.size()-1;i>=0;i--){
            runner.next = cache.get(i);
            runner = runner.next;
        }

        runner.next = null;
        return result;
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode newHead = head;
        ListNode runner = head.next;
        newHead.next = null;
        while(runner != null){
            ListNode temp = runner;
            runner = runner.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}
