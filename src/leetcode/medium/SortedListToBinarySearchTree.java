package leetcode.medium;

import util.Tree.TreeNode;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class SortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode ptr = head;
        ArrayList<Integer> nums = new ArrayList<>();
        while(ptr != null){
            nums.add(ptr.val);
            ptr = ptr.next;
        }
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            return null;
        }

        return util(nums,0,nums.size()-1);
    }

    private TreeNode util(ArrayList<Integer> nums, int l, int r){
        if( l > r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode t = new TreeNode(nums.get(mid));
        t.left = util(nums,l,mid-1);
        t.right = util(nums,mid+1,r);
        return t;
    }
}
