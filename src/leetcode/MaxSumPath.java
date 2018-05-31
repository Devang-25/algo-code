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
public class MaxSumPath {

    int maxSoFar = Integer.MIN_VALUE;
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root){
        maxPathSumUtil(root);
        return maxSoFar;
    }
    public int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftMax = maxPathSumUtil(root.left);
        int rightMax = maxPathSumUtil(root.right);
      
        int val = Integer.max(root.val,Integer.max(leftMax, rightMax) + root.val);
        int max = Integer.max(val,root.val+leftMax+rightMax);
        if(max > maxSoFar){
            maxSoFar = max;
        }
        
        return val;
    }

    public static void main(String[] args) {
        MaxSumPath msp = new MaxSumPath();
    }
}
