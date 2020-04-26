/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.Tree.TreeNode;

/**
 * @author mns
 */
public class BinaryPostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                result.addFirst(curr.val);
                curr = curr.right;
            }else{
                TreeNode t = st.pop();
                curr = t.left;
            }
        }

        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> st = new Stack<>();
            st.push(root);

            while (!st.isEmpty()) {
                TreeNode top = st.peek();
                if (top.left == null && top.right == null) {
                    result.add(top.val);
                    st.pop();
                } else {
                    if (top.left != null) {
                        st.push(top.left);
                        top.left = null;
                    } else if (top.right != null) {
                        st.push(top.right);
                        top.right = null;
                    }
                }
            }
        }

        return result;
    }
}
