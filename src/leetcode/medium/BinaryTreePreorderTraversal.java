package leetcode.medium;

import util.Tree.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> st = new Stack<>();
            st.push(root);
            TreeNode curr;
            while(!st.isEmpty()){
                curr = st.pop();
                result.add(curr.val);
                if(curr.right != null){
                    st.push(curr.right);
                }
                if(curr.left != null){
                    st.push(curr.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = BinaryTree.createTree(new String[]{"1","2","3","","","4","","5","6"});
        BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
        bt.preorderTraversal(tn).forEach(System.out::println);
    }
}
