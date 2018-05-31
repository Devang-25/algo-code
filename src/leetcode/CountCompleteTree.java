/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class CountCompleteTree {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public int countNodes(TreeNode root) {
        return countNodesUtil(root);
    }
    
    private int countNodesUtil(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1 + countNodesUtil(root.left) + countNodesUtil(root.right);
    }
    
    public static void main(String[] args) {
        
    }
}
