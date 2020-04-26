/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

import java.util.Scanner;

/**
 *
 * @author mns
 */
public class BSTElementTree {

    private static class Node {

        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return (node);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Node _root;
        int root_i = 0, root_cnt = 0, root_num = 0;
        root_cnt = in.nextInt();
        _root = null;
        for (root_i = 0; root_i < root_cnt; root_i++) {
            root_num = in.nextInt();
            if (root_i == 0) {
                _root = new Node(root_num);
            } else {
                insert(_root, root_num);
            }
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int _x = in.nextInt();
            System.out.println(isPresent(_root, _x));
        }

        in.close();
        return;
    }

    private static int isPresent(Node root, int val) {
        if (root == null) {
            return 0;
        } else {

            Node point = root;
            while (point != null) {
                if (point.data == val) {
                    return 1;
                } else if (val > point.data) {
                    point = point.right;
                } else {
                    point = point.left;
                }
            }

            return 0;
        }
    }
}
