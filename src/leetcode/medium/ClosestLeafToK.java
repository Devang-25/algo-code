package leetcode.medium;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ClosestLeafToK {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int findClosestLeaf(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        fillParent(root, null, map);

        LinkedList<TreeNode> q = new LinkedList<>();
        for(TreeNode tn : map.keySet()){
            if(tn.val == k){
                q.add(tn);
                break;
            }
        }

        while(!q.isEmpty()){
            TreeNode front = q.poll();
            visited.add(front);
            if(front.left == null && front.right == null){
                return front.val;
            }else{
                if(front.left!= null && !visited.contains(front.left)){
                    q.add(front.left);
                }
                if(front. right != null && !visited.contains(front.right)){
                    q.add(front.right);
                }
                if(map.get(front)!= null && !visited.contains(map.get(front))){
                    q.add(map.get(front));
                }
            }
        }

        return -1;
    }

    private void fillParent(TreeNode root, TreeNode parent, HashMap<TreeNode,TreeNode> map){
        if(root == null){
            return;
        }
        map.put(root,parent);
        fillParent(root.left,root,map);
        fillParent(root.right,root,map);
    }
}
