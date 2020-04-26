package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.Tree.BinaryTree;
import util.Tree.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }else{
                TreeNode t = st.pop();
                curr = t.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = BinaryTree.createTree(new String[]{"1", "2", "3", "", "", "4", "", "5", "6"});
        BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
        bt.preorderTraversal(tn).forEach(System.out::println);
    }
}
