package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import util.Tree.TreeNode;

public class BinaryTreeCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean hasEnded = false;
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            if(hasEnded && !(front.left == null && front.right == null)){
                return false;
            }
            if(front.left == null && front.right !=null){
                return false;
            }else if(front.left == null && front.right == null){
                hasEnded = true;
                continue;
            }else if(front.right == null){
                hasEnded = true;
                q.offer(front.left);
                continue;
            }

            q.offer(front.left);
            q.offer(front.right);

        }

        return true;
    }
}
