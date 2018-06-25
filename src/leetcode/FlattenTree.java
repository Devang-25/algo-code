/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Stack;

/**
 *
 * @author mns
 */
public class FlattenTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public void flatten2(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode p = root;

            while (p != null || !stack.empty()) {

                if (p.right != null) {
                    stack.push(p.right);
                }

                if (p.left != null) {
                    p.right = p.left;
                    p.left = null;
                } else if (!stack.empty()) {
                    TreeNode temp = stack.pop();
                    p.right = temp;
                }

                p = p.right;
            }
        }

        TreeNode head = null;
        public void flatten(TreeNode root){
            if(root == null){
                return;
            }
            flatten(root.right);
            flatten(root.left);
            root.left = null;
            root.right = head;
            head = root;

        }
    }
}
