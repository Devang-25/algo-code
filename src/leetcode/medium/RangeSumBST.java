package leetcode.medium;

import util.Tree.TreeNode;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int l, int r) {
        return sumUtil(root,l,r);
    }

    int sumUtil(TreeNode root, int l , int r){
        if(root == null){
            return 0;
        }

        if(root.val >= l && root.val <= r){
            return root.val + sumUtil(root.left, l ,r) + sumUtil(root.right, l,r);
        }else if( root.val > r){
            return sumUtil(root.left, l ,r);
        }else if( root.val < l) {
            return sumUtil(root.right,l,r);
        }
        return 0;
    }
}
