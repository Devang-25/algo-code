/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author sekha
 */
public class BinaryTreeRightSideView {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> result= new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                
                if(curr.right != null){
                    q.offer(curr.right);
                }
                
                if(i== size-1){
                    result.add(curr.val);
                }
            }
        }
        
        return result;
    }
    
    
}
