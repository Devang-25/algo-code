package leetcode.medium;

import util.Tree.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return pruneTreeUtil(root)? root : null;
    }

    private boolean pruneTreeUtil(TreeNode root){
        if(root == null){
            return false;
        }
        boolean left = pruneTreeUtil(root.left);
        boolean right = pruneTreeUtil(root.right);
        if(!left){
            root.left = null;
        }
        if(!right){
            root.right = null;
        }
        return root.val ==1 || left || right;
    }
}
