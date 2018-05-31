/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;

/**
 *
 * @author mns
 */
class Node {

    private Node left;
    private Node right;
    private int val;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

}

public class BSTSequences {

    public static ArrayList<ArrayList<Integer>> getAllSequences(Node head) {

        ArrayList<ArrayList<Integer>> allSeq = new ArrayList<>();

        if (head.getLeft() == null && head.getRight() == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(head.getVal());
            allSeq.add(list);

        } else {
            ArrayList<ArrayList<Integer>> allseq1 = new ArrayList<>();
            ArrayList<ArrayList<Integer>> allseq2 = new ArrayList<>();

            if (head.getLeft() != null) {
                allseq1 = getAllSequences(head.getLeft());
            }
            if (head.getRight() != null) {
                allseq2 = getAllSequences(head.getRight());
            }

            for (int i = 0; i < allseq1.size(); i++) {
                for (int j = 0; j < allseq2.size(); j++) {

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(head.getVal());
                    list.addAll(allseq1.get(i));
                    list.addAll(allseq2.get(j));
                    allSeq.add(list);

                    list = new ArrayList<>();
                    list.add(head.getVal());
                    list.addAll(allseq2.get(j));
                    list.addAll(allseq1.get(i));
                    allSeq.add(list);
                }
            }

        }
        return allSeq;
    }

    public static void printOut(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> subList : list) {

            for (int i = 0; i < subList.size(); i++) {
                System.out.print(subList.get(i) + ",");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.setLeft(new Node(5));
        head.setRight(new Node(15));
        head.getLeft().setLeft(new Node(3));
        head.getLeft().setRight(new Node(7));
        head.getRight().setLeft(new Node(12));
        head.getRight().setRight(new Node(17));

        printOut(getAllSequences(head));
    }
}
