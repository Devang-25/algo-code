package leetcode.medium;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class ConvertBinarySearchTreeToDLL {

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        Node head = treeToDoublyListUtil(root);
        Node tmp = head;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        head.left = tmp;
        tmp.right = head;

        return head;
    }

    public Node treeToDoublyListUtil(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node left = treeToDoublyListUtil(root.left);
        Node right = treeToDoublyListUtil(root.right);

        if (left != null) {
            Node tmp = left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            root.left = tmp;
            tmp.right = root;
        }

        if (right != null) {
            root.right = right;
            right.left = root;
        }

        return left == null ? root : left;
    }
}
