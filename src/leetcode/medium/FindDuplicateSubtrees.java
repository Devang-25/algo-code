package leetcode.medium;

import util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashSet<String> set = new HashSet<>();
        HashMap<String,TreeNode> res = new HashMap<>();
        if(root == null){
            return new ArrayList<>();
        }
        util(root,set,res);
        return new ArrayList<>(res.values());
    }

    private String util(TreeNode root, HashSet<String> set, HashMap<String,TreeNode> res ){
        if(root == null){
            return "";
        }

        String  left = util(root.left,set,res);
        String  right = util(root.right,set,res);

        String s = root.val + "," + left + "," + right;
        if(set.contains(s)){
            res.put(s,root);
        }else{
            set.add(s);
        }

        return s;
    }
}
