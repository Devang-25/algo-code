package leetcode.easy;
import util.Tree.TreeNode;

public class ClosestBSTNode {

    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return -1;
        }

        TreeNode curr = root;
        int min = root.val;
        double minDiff = Math.abs(root.val-target);
        while(curr != null){
            if(Math.abs(curr.val-target) < minDiff){
                minDiff = Math.abs(curr.val-target);
                min = curr.val;
            }

            if(curr.val > target){
                curr = curr.left;
            }else if(curr.val < target){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return min;
    }
}
