package leetcode.medium;

public class InsertIntoCyclicSortedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        Node n = new Node();
        n.val = insertVal;
        if(head == null){
           n.next = n;
           return n;
        }

        if(head.next == head){
            head.next = n;
            n.next = head;
            return head;
        }

        Node curr = head.next, prev = head;
        Node largest = head;
        do{
            if(insertVal >= prev.val && insertVal <= curr.val){
                prev.next = n;
                n.next = curr;
                return head;
            }else if(curr.val >= largest.val){
                largest = curr;
            }
            prev = curr;
            curr = curr.next;
        }while(prev !=head);

        Node tmp = largest.next;
        largest.next = n;
        n.next = tmp;
        return head;

    }

    private void printList(Node n){
        if(n == null){
            return;
        }
        Node curr = n;
        do{
            System.out.print(curr.val + " ");
            curr = curr.next;
        }while(curr!=n);
        System.out.println();
    }
    public static void main(String[] args) {
        InsertIntoCyclicSortedList is = new InsertIntoCyclicSortedList();
        Node n = is.insert(null,3);
        is.printList(n);
        is.insert(n,4);
        is.printList(n);
        is.insert(n,1);
        is.printList(n);
        is.insert(n,2);
        is.printList(n);


    }
}
