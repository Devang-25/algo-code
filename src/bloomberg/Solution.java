/*
[1] -> [2] -> [3] -> [8] -> [10]
               |      |
               |     [9]
               |
              [4] -> [5] -> [6]--1 2 3
                             |
                            [7]

[1] -> [2] -> [3] -> [4] -> [5] -> [6] -> [7] -> [8] -> [9] -> [10]

*/
// -1
package bloomberg;
class Node {
    int val;
    Node next, down;

    Node(int x) {
        this.val = x;
    }
}

// -1 -> 1 -> 2 -> 3 -> 4 -> 5.
public class Solution {


    public Node flatten(Node n) {
        flattenUtil(n);
        return n;
    }

    private Node flattenUtil(Node n) {
        if (n == null ) {
            return n;
        }

        Node next = flattenUtil(n.next);
        Node down = flattenUtil(n.down);
        if(down !=null){
            Node ptr = down;
            while(ptr.next !=null){
                ptr = ptr.next;
            }
            ptr.next = next;
            n.down = null;
            n.next = down;
        }else{
            n.next = next;
        }

        return n;
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution sol = new Solution();
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.down = new Node(4);
        n.next.next.down.next = new Node(5);
        n.next.next.next = new Node(8);

        Node x = sol.flatten(n);
        Node ptr = x;
        while(ptr !=null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}