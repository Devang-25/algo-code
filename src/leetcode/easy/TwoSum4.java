package leetcode.easy;

import java.util.HashSet;

import util.Tree.TreeNode;

public class TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return util(root, set, k);
    }

    public boolean util(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return util(root.left, set, k) || util(root.right, set, k);
    }
}
