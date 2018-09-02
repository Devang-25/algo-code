package hard;

/**
 * Created by mns on 8/20/18.
 */
public class ReverseNodesinKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = new ListNode(0);
        l.next = head;
        ListNode curr = l, run = head, next = null;
        int cnt = 0;

        while(run != null){
            while(run != null && cnt < k){
                cnt++;
                run = run.next;
            }
            if(cnt == k){
                ListNode rev = reverse(curr.next,k);
                ListNode revEnd = curr.next;
                curr.next = rev;
                curr = revEnd;
                curr.next = run;
                cnt = 0;
            }

        }


        return l.next;
    }

    private void print(ListNode list){
        ListNode curr=  list;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    private ListNode create(int [] arr){
        ListNode head = new ListNode(0);
        ListNode curr = head; int cnt = 0;
        while (cnt < arr.length){
            curr.next = new ListNode(arr[cnt++]);
            curr = curr.next;
        }
        return head.next;
    }

    private ListNode reverse(ListNode head, int k){
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        int cnt = 0;
        while(curr != null && cnt < k){
            cnt ++;
            ListNode temp = newHead.next;
            newHead.next = curr;
            curr = curr.next;
            newHead.next.next = temp;
        }

        return newHead.next;

    }

    public static void main(String[] args) {
        ReverseNodesinKGroup rk = new ReverseNodesinKGroup();
        ListNode l = rk.create(new int [] {1,2,3,4,5,6,7});
        rk.reverseKGroup(l,3);
    }
}
