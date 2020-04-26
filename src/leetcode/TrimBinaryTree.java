/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import util.Tree.BinaryTree;
import util.Tree.TreeNode;

/**
 *
 * @author mns
 */
public class TrimBinaryTree {
    /**
 * Definition for a binary tree node. **/
  
  public TreeNode trimBST(TreeNode root, int L, int R){
      if(root == null){
          return null;
      }
      
      TreeNode newRoot = null;
      if(root.val >= L && root.val <= R){
          newRoot = new TreeNode(root.val);
          newRoot.left = trimBST(root.left,L,R);
          newRoot.right = trimBST(root.right,L,R);
      }else if(root.val > R){
          newRoot = trimBST(root.left,L,R);
      }else if(root.val < L){
          newRoot = trimBST(root.right,L,R);
      }
      
      return newRoot;
  }
 
    public static void main(String[] args) {
        TreeNode root= BinaryTree.createTree("5,4,10,3,,8,11,1,,6,7,,,0,2");
        TrimBinaryTree t = new TrimBinaryTree();
        TreeNode trim = t.trimBST(root,0,0);
        System.out.println(trim);
    }
  
}
