/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author mns
 */
public class BinaryPostOrder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
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
