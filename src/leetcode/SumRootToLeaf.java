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
public class SumRootToLeaf {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersUtil(root, "");
    }
    
    public int sumNumbersUtil(TreeNode root, String upNumber){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return Integer.parseInt(upNumber+ root.val);
        }else{
            int left = sumNumbersUtil(root.left,upNumber+root.val);
            int right = sumNumbersUtil(root.right,upNumber+root.val);
            return left + right;
        }
        
        
    }

}
