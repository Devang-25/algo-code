package leetcode.easy;

import util.Tree.TreeNode;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return util(root, root.val);
    }

    private boolean util(TreeNode root, int val){
        if(root == null){
            return true;
        }

        return root.val == val && util(root.left,val) && util(root.right, val);
    }
}
