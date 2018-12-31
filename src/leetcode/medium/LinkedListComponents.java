package medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by mns on 12/19/18.
 */
public class LinkedListComponents {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
    public int numComponents(ListNode head, int [] g){
        if(head == null || g == null || g.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i : g){
            set.add(i);
        }

        ListNode ptr = head;
        int result = g.length;
        int currSize = 0;
        while(ptr != null){
            if(set.contains(ptr.val)){
                currSize++;
                if(currSize > 1){
                    result--;
                }
            }else{
                currSize = 0;
            }
            ptr = ptr.next;
        }

        return result;
    }
}
