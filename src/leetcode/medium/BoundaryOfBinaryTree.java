package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        left(root.left, result);
        leaves(root.left,result);
        leaves(root.right,result);
        right(root.right,result);
        return result;
    }

    private void left(TreeNode root, ArrayList<Integer> result){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        result.add(root.val);
        if(root.left != null){
            left(root.left, result);
        }else{
            left(root.right,result);
        }
    }
    private void right(TreeNode root, ArrayList<Integer> result){
        if(root == null ||(root.left == null && root.right == null)){
            return;
        }

        if(root.right != null){
            right(root.right, result);
        }else{
            right(root.left,result);
        }
        result.add(root.val);
    }

    private void leaves(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(root.val);
            return;
        }

        leaves(root.left,result);
        leaves(root.right,result);
    }
}
