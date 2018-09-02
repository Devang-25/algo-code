package leetcode.easy;

import util.Tree.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode newRoot,copy;
    public TreeNode increasingBST(TreeNode root) {
        newRoot = new TreeNode(-1);
        copy = newRoot;
        util(root);
        return  copy.right;
    }

    private void util(TreeNode root){
        if(root == null){
            return;
        }

        util(root.left);
        newRoot.right = new TreeNode(root.val);
        newRoot = newRoot.right;
        util(root.right);
    }
}
