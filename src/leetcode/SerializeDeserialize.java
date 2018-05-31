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
public class SerializeDeserialize {
    

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
    
    public String serialize(TreeNode root) {
        if(root == null){
            return "()";
        }
        
        return "(" + root.val + "," + serialize(root.left) +","+serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 || data.contentEquals("()")){
            return null;
        }
        
        TreeNode node = null;
        if(data.charAt(0) == '('){
            int length = data.length();
            int i = 0;
            String nodeData="", rightData="", leftData="";
            for(i=1;i<length-1;i++){
                if(data.charAt(i) == ','){
                    break;
                }
                nodeData += data.charAt(i);
            }
            
            if(nodeData.length() == 0){
                return null;
            }
            
            node = new TreeNode(Integer.parseInt(nodeData));
            i++;
            int openParenthesis = 0;
            for(;i<length-1;i++){
                if(data.charAt(i) == '('){
                    openParenthesis++;
                }else if(data.charAt(i) == ')'){
                    openParenthesis--;
                }
                
                leftData += data.charAt(i);
                if(openParenthesis == 0){
                    break;
                }
            }
            
            i+=2;
            for(;i<length-1;i++){
                if(data.charAt(i) == '('){
                    openParenthesis++;
                }else if(data.charAt(i) == ')'){
                    openParenthesis--;
                }
                
                rightData += data.charAt(i);
                if(openParenthesis == 0){
                    break;
                }
            }
            
            node.left = deserialize(leftData);
            node.right = deserialize(rightData);
            
            
        }
        
        return node;
        
    }
   
    public static void main(String[] args) {
        SerializeDeserialize s = new SerializeDeserialize();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(12);
        
        System.out.println(s.serialize(root));
        TreeNode root1 = s.deserialize(s.serialize(root));
        
        System.out.println(root1.val);
        System.out.println(root1.left.val);
        System.out.println(root1.right.val);
        System.out.println(root1.right.left.val);
    }
}
