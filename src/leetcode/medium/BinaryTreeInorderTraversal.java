package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val =x;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        LinkedHashSet<TreeNode> result = new LinkedHashSet<>();
        if(root != null) {
            Stack<TreeNode> st = new Stack<>();
            st.push(root);

            while (!st.isEmpty()) {
                TreeNode top = st.peek();
                if (top.left == null || result.contains(top.left)) {
                    st.pop();
                    result.add(top);
                    if (top.right != null) {
                        st.push(top.right);
                    }
                } else {
                    while (top.left != null ) {
                        st.push(top.left);
                        top = top.left;
                    }
                }
            }
        }
        return result.stream().mapToInt( i -> i.val).boxed().collect(Collectors.toList());
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = root;
            while(curr != null || !st.isEmpty()){
                if(curr != null){
                    st.push(curr);
                    curr = curr.left;
                }else {
                    curr = st.pop();
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
        TreeNode tn = new TreeNode(1);
        tn.right = new TreeNode(2);
        tn.right.left = new TreeNode(3);
        bt.inorderTraversal(tn).stream().forEach(System.out::print);

    }
}
