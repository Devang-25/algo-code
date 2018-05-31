package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeavesUtil(root,result);
        return result;
    }

    private int findLeavesUtil(TreeNode root, List<List<Integer> > result){
        if(root == null){
            return 0;
        }

        int orderLeft = findLeavesUtil(root.left, result);
        int orderRight = findLeavesUtil(root.right,result);

        int max = Math.max(orderLeft,orderRight);
        if(result.size() <= max){
            result.add(new ArrayList<>());
        }
        result.get(max).add(root.val);
        return max+1;
    }
}
