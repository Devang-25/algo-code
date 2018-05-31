/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author sekha
 */
public class BoundaryOfBinaryTree {
    
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> leftResult = new ArrayList<Integer>();
        List<Integer> rightResult = new ArrayList<Integer>();
        q.offer(root);
        
        int height = getHeight(root);
        int currHeight = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr!= null){
                    q.offer(curr.left);
                    q.offer(curr.right);
                
                    if(currHeight == 0 || currHeight == height){
                        leftResult.add(curr.val);
                    }else if(i == 0){
                        leftResult.add(curr.val);
                    }else if(i== size-1){
                        rightResult.add(curr.val);
                    }
                }
            }
            currHeight++;
        }
        Collections.reverse(rightResult);
        leftResult.addAll(rightResult);
        return leftResult;
    }
    
    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1+ Math.max(getHeight(root.left), getHeight(root.right));
    }
}
