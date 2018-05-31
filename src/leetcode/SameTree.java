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
public class SameTree {
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q){
        if((p == null && q!= null) || (p!=null && q == null)){
            return false;
        } 
        
        if(p == null && q == null){
            return true;
        }
        
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        
        TreeNode q = new TreeNode(0);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        q.left.left = new TreeNode(3);
        
        
        System.out.println(st.isSameTree(null, null));
    }
}
