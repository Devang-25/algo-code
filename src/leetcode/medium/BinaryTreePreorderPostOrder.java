package leetcode.medium;

import util.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePreorderPostOrder {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0 || post.length == 0 ){
            return null;
        }
        int l = 0, r = post.length-1;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(pre[l]);
        q.add(root);
        l++; r--;

        int levelSize = 2;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size && l <= r;i++){
                TreeNode curr = q.pop();
                if(l <= r){
                    curr.left = new TreeNode(pre[l++]);
                    q.add(curr.left);
                }
                if(l <= r){
                    curr.right = new TreeNode(pre[r--]);
                    q.add(curr.right);
                }
            }

        }

        return root;
    }
}
