package leetcode.medium;

import java.util.HashMap;

import util.Tree.TreeNode;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> cache = new HashMap<>();
        return robUtil(root, cache);
    }
    public int robUtil(TreeNode root, HashMap<TreeNode,Integer> cache) {
        if(root == null){
            return 0;
        }

        if(cache.get(root)!=null){
            return cache.get(root);
        }
        int leftMax = root.left!=null? robUtil(root.left.left,cache)+ robUtil(root.left.right,cache):0;
        int rightMax = root.right!=null? robUtil(root.right.left, cache)+ robUtil(root.right.right, cache):0;
        int max = root.val + leftMax + rightMax;
        max = Math.max(max, robUtil(root.left, cache) + robUtil(root.right, cache));

        cache.put(root,max);
        return max;

    }
}
