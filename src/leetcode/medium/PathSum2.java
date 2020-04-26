package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import util.Tree.TreeNode;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumUtil(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumUtil(TreeNode root, int sum, ArrayList<Integer> curr, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        curr.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        } else {
            pathSumUtil(root.left, sum - root.val, curr, result);
            pathSumUtil(root.right, sum - root.val, curr, result);
        }
        curr.remove(curr.size() - 1);

    }


}
