package leetcode.medium;

import util.Tree.TreeNode;

public class SumRootToLeaf {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        sumNumbersUtil(root,0);
        return totalSum;
    }

    private void sumNumbersUtil(TreeNode root, int sumSoFar){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            totalSum += sumSoFar*10 + root.val;
        }

        sumNumbersUtil(root.left,sumSoFar*10+root.val);
        sumNumbersUtil(root.right,sumSoFar*10+root.val);
    }


}
