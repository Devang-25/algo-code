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
public class SumLeftLeaves {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumOfLeavesUtil(root, false);

    }

    public int sumOfLeavesUtil(TreeNode root, boolean isLeft) {

        if (root == null) {
            return 0;
        }

        int total = 0;

        if (isLeft && root.left == null && root.right == null) {
            total += root.val;
        }

        return total + sumOfLeavesUtil(root.left, true) + sumOfLeavesUtil(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SumLeftLeaves s = new SumLeftLeaves();
        System.out.println(s.sumOfLeftLeaves(root));
    }
}
