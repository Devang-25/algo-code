/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class BottomLeftTreeVal {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if(leftHeight >= rightHeight){
            return findBottomLeftValue(root.left);
        }
        
        return findBottomLeftValue(root.right);
    }
    
    
    private int height (TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
        return 1+ Math.max(left, right);
    }
    
}
