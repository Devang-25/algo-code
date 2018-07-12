/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import util.Tree.TreeNode;

import java.util.*;

/**
 * @author mns
 */
public class BinaryPostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        ArrayDeque<TreeNode> st = new ArrayDeque<>();

        while (!st.isEmpty() || curr !=null) {
            if (curr != null) {
                st.push(curr);
                if (curr.right != null) {
                    st.push(curr.right);
                }
                curr = curr.left;

            } else {
                curr = st.pop();
                result.add(curr.val);
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
