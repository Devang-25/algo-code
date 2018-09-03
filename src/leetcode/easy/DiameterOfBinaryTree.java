package leetcode.easy;

import util.Tree.TreeNode;

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        util(root);
        return max;
    }

    private int util(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = util(root.left);
        int right = util(root.right);
        max = Math.max(max ,  Math.max(left,right));

        return 1 + Math.max(left,right);
    }
}
