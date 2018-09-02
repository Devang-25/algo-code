package medium;


/**
 * Created by mns on 8/6/18.
 */
public class ReverseLinkedList2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null ){
            return head;
        }

        int cnt = 1;
        ListNode left= null, right = null, runner = head, prevLeft = null, nextRight = null, prev = null, result = null;
        /** Find the left and right node **/
        while(runner!= null){
            if(cnt == m){
                prevLeft = prev;
                left = runner;
            }else if(cnt == n+1){
                right = runner;
                nextRight = runner;
                break;
            }
            prev = runner;
            runner = runner.next;
            cnt++;
        }

        /** Get the patch on reverse order */
        ListNode reversePatch = reverseList(left,right);

        if(prevLeft == null){
            // If the patch is from the beginning of the list, then that is the new head
            result = reversePatch;
        }else{
            // If the patch is in the middle of the list, then append it patch to the prevLeft
            prevLeft.next = reversePatch;
            result = head;
        }

        // Append the right portion to the end of the patch
        runner = reversePatch;
        while(runner.next!=null){
            runner = runner.next;
        }
        runner.next = nextRight;

        return result;

    }

    public ListNode reverseList(ListNode left, ListNode right){
        ListNode newHead = left;
        ListNode runner = left.next;
        newHead.next = null;
        while(runner != null && runner != right){
            ListNode temp = runner;
            runner = runner.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}
