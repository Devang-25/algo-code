package leetcode.medium;

import util.Tree.TreeNode;

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }

        TreeNode left = upsideDownBinaryTree(root.left);
        return left;
    }
}
