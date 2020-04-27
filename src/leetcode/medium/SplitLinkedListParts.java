package leetcode.medium;

/**
 * Created by mns on 1/4/19.
 */

public class SplitLinkedListParts {
    static class ListNode {
        public int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if( k <= 0 ){
            return new ListNode[0];
        }

        int size = 0;

        ListNode [] result = new ListNode[k];
        ListNode ptr = root;

        while(ptr != null){
            size++;
            ptr = ptr.next;
        }

        int partSize = size/k;
        int extra = size%k;
        ptr = root;
        for(int i=0;i<k && ptr!=null;i++){
            result[i] = ptr;
            ListNode prev = ptr;
            for(int j=0;j<partSize;j++){
                prev = ptr;
                ptr = ptr.next;
            }
            if(extra > 0){
                prev = ptr;
                ptr = ptr.next;
                extra--;
            }
            prev.next = null;

        }

        return result;
    }

    public static void main(String[] args) {
        SplitLinkedListParts spl = new SplitLinkedListParts();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next= new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        spl.splitListToParts(l,4);

    }

}
