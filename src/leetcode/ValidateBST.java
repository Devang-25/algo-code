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
public class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode (int x){
            this.val = x;
        }
    }
   
     public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
     
     private boolean isValidBSTHelper(TreeNode node, long min , long max){
         if(node == null){
             return true;
         }
       
         boolean isLeftValid = isValidBSTHelper(node.left, min, node.val);
         boolean isRightValid = isValidBSTHelper(node.right, node.val, max);
         
         boolean valid = (node.val < max && node.val > min);
         
         return isLeftValid && isRightValid && valid;
         
     }
     
     public static void main(String[] args) {
        ValidateBST v = new ValidateBST();
//        TreeNode root = new TreeNode(100);
//        root.left = new TreeNode(50);
//        root.left.left = new TreeNode(40);
//        root.left.right = new TreeNode(51);
//        root.right = new TreeNode(110);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = null;
        
         System.out.println(v.isValidBST(root));
    }
}
