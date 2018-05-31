/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class SameTree {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSameTree(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }else if(l == null || r== null){
            return false;
        }
        
        return l.val == r.val && isSameTree(l.left,r.left) && isSameTree(l.right,r.right);
    }
}
