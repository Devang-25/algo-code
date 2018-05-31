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
public class NextRightPointer {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x){
            val = x;
        }
    }
    
    public void connect(TreeLinkNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }else{
                root.right.next = null;
            }
        }
        
        connect(root.left);
        connect(root.right);
    }
    

}
