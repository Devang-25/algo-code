package hard;

import util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mns on 8/11/18.
 */
public class ClosestBinarySearchTreeValue2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        util(root, target, k, res);
        return res;
    }
    private void util(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }
        util(root.left,target,k,res);
        if (res.size()< k) {
            res.addLast(root.val);
        } else {
            if (Math.abs(res.getFirst()-target) > Math.abs(root.val-target)) {
                res.pollFirst();
                res.addLast(root.val);
            } else {
                return;
            }
        }
        util(root.right,target,k,res);
    }
}
