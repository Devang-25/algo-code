/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class LongestUnivaluePath {
    public static int maxLength = 0;
    public static class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x){
            this.val = x;
        }
    }
    
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathHelper(root);
        return Math.max(0, maxLength-1);
    }
    
    public void longestUnivaluePathHelper(TreeNode root){
        
        if(root != null){
            int left = longestPath(root.left,root.val);
            int right = longestPath(root.right,root.val);
            maxLength = Math.max(maxLength, 1 + right + left);

            longestUnivaluePathHelper(root.left);
            longestUnivaluePathHelper(root.right);
        }
    }
    
    public int longestPath(TreeNode root, int val){
        if(root == null || root.val != val){
            return 0;
        }
        
        return 1+ Math.max(longestPath(root.left,val), longestPath(root.right,val));
        
    }
    
    public static void main(String[] args) {
        LongestUnivaluePath lu = new LongestUnivaluePath();
        TreeNode node = new TreeNode(1);

        System.out.println(lu.longestUnivaluePath(node));
    }
}
