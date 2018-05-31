/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

import java.util.ArrayList;

/**
 *
 * @author mns
 */
public class GowQ1 {

    public static class Node {

        int val;
        Node left;
        Node right;

        public Node(int v) {
            val = v;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {

        Node head;

        public BinaryTree(Node n) {
            this.head = n;
        }

        private int getLongestIncreasingPathUtil(Node root) {
            int leftMax, rightMax;
            if (root == null) {
                leftMax = rightMax = 0;
            } else if (root.left == null && root.right == null) {
                leftMax = rightMax = 1;
            } else {
                leftMax = getLongestIncreasingPathUtil(root.left);
                rightMax = getLongestIncreasingPathUtil(root.right);

                if (root.left != null && root.val < root.left.val) {
                    leftMax++;
                } if (root.right != null && root.val < root.right.val) {
                    rightMax++;
                }if(root.right != null && root.left != null && root.val > root.right.val && root.val > root.left.val){
                    leftMax = rightMax = 1;
                } 
                

            }
            if (root != null) {
                System.out.println(root.val + " " + Math.max(leftMax, leftMax));
            }
            return Math.max(leftMax, rightMax);

        }

        public int getLongestIncreasingPath() {
            return getLongestIncreasingPathUtil(head);
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Node n = new Node(i);
            list.add(n);
        }

        BinaryTree bt = new BinaryTree(list.get(0));
        bt.head.left = list.get(1);
        list.get(1).left = list.get(2);
        list.get(2).left = list.get(3);
        list.get(3).right = list.get(4);
        list.get(4).right = list.get(5);
        list.get(2).right = list.get(6);
        list.get(6).right = list.get(7);
        list.get(7).right = list.get(8);
        list.get(8).right = list.get(9);

        System.out.println(bt.getLongestIncreasingPath());
    }
}
