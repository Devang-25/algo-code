package easy;

import java.util.*;

/**
 * Created by mns on 7/12/18.
 */
public class BinaryTreeLevelOrder2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val =x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<List<Integer> > result2 = new ArrayList<>();
        if(root == null)
            return result2;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }

            result.addFirst(list);
        }

        return new ArrayList<>(result);
    }
}
