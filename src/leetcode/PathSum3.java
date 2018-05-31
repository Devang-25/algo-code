/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.LinkedHashSet;

/**
 *
 * @author sekha
 */
public class PathSum3 {
    public static class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x){
            this.val = x;
        }
    }
    
     public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
    
    public static void main(String[] args) {
        
    }
}
