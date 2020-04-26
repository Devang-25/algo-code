/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mns
 */
public class BinaryTree {

    public static TreeNode createTree(String str) {
        String[] arr = str.split(",");
        return createTree(arr);
    }

    public static TreeNode createTree(String[] arr) {
        return createTreeUtil(arr, 0);
    }

    private static TreeNode createTreeUtil(String[] arr, int currIndex) {
        Queue<TreeNode> q = new LinkedList<>();
        if (arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length) {
                curr.left = arr[i].isEmpty() ? null : new TreeNode(Integer.parseInt(arr[i]));
            } else {
                curr.left = null;
            }
            if (i + 1 < arr.length) {
                curr.right = arr[i + 1].isEmpty() ? null : new TreeNode(Integer.parseInt(arr[i + 1]));
            } else {
                curr.right = null;
            }

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
            i+=2;
        }
        
        return root;

    }

    public static void printPreOrder(TreeNode t){
        if(t!=null){
            System.out.print(t.val+",");
            printPreOrder(t.left);
            printPreOrder(t.right);
        }
    }

}
