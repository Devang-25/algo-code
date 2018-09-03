package leetcode.easy;

import util.Tree.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return util(nums,0,nums.length-1);
    }

    private TreeNode util(int [] nums, int l, int r){
        if( l > r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = util(nums,l,mid-1);
        t.right = util(nums,mid+1,r);
        return t;
    }
}
