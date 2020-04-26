package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BinaryTreeDistK {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val =x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();

        fillParents(root,parentMap,null);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(target);


        int dist = 0;
        while(!q.isEmpty() && dist < K){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.pollFirst();
                visited.add(curr);
                if( parentMap.get(curr) != null && !visited.contains(parentMap.get(curr)) ){
                    q.addLast(parentMap.get(curr));
                }

                if(curr.left!=null && !visited.contains(curr.left) ){
                    q.addLast(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right) ){
                    q.addLast(curr.right);
                }
            }
            dist++;
        }

        while(!q.isEmpty()){
            result.add(q.pollFirst().val);
        }

        return result;
    }

    private void fillParents(TreeNode node, HashMap<TreeNode,TreeNode> parentMap, TreeNode parent){
        if(node != null){
            parentMap.put(node,parent);
            fillParents(node.left,parentMap,node);
            fillParents(node.right,parentMap,node);
        }
    }
}
