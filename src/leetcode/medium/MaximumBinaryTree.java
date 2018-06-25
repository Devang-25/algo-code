package leetcode.medium;


import java.util.LinkedList;

/**
 * Created by mns on 6/5/18.
 */
public class MaximumBinaryTree {
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int num: nums){
            TreeNode cur = new TreeNode(num);
            while (!list.isEmpty() && list.peekFirst().val < cur.val){
                cur.left = list.pop();
            }

            if (!list.isEmpty()){
                list.peekFirst().right = cur;
            }
            list.push(cur);
        }

        return list.peekLast();
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return constructMaximumBinaryTreeUtil(nums,0,nums.length-1);
    }

    public TreeNode constructMaximumBinaryTreeUtil(int [] nums, int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            return null;
        }

        int maxIndex = leftIndex;
        for(int i=leftIndex+1;i<=rightIndex;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeUtil(nums,leftIndex,maxIndex-1);
        root.right = constructMaximumBinaryTreeUtil(nums,maxIndex+1,rightIndex);

        return root;

    }
}
