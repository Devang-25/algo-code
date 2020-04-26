package leetcode.medium;

/**
 * Created by mns on 9/10/18.
 */
public class FlattenMultiLevelDLL {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Node next = flatten(head.next);
        Node child = flatten(head.child);

        if(child !=null){
            head.next = child;
            child.prev = head;
            Node ptr = child;
            while (ptr.next !=null){
                ptr = ptr.next;
            }
            ptr.next = next;
            if(next != null){
                next.prev = ptr;
            }
            head.child = null;
        }else{
            head.next = next;
        }

        return head;
    }

}
