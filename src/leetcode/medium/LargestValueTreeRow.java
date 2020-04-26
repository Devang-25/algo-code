package leetcode.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestValueTreeRow {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode front = q.poll();
                max = Math.max(max,front.val);

                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
            }
            result.add(max);
        }

        return result;
    }
}
