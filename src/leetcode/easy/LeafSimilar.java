package leetcode.easy;

import util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        getLeaves(root1,leaf1);
        getLeaves(root2,leaf2);
        if(leaf1.size() != leaf2.size()){
            return false;
        }

        for(int i=0;i<leaf1.size();i++){
            if(leaf1.get(i) != leaf2.get(i)){
                return false;
            }
        }

        return true;

    }

    private void getLeaves(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        getLeaves(root.left,list);
        getLeaves(root.right,list);
    }


}
