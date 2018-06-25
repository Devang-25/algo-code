package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagTraversal {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean odd = true;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayDeque<Integer> list = new ArrayDeque<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(odd){
                    list.offerLast(curr.val);
                }else{
                    list.offerFirst(curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            odd = !odd;
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}
