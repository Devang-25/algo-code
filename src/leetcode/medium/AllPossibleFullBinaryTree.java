package leetcode.medium;

import util.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class AllPossibleFullBinaryTree {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        return result;
    }

    private void util(TreeNode root , int n, List<TreeNode> result){
        if(n == 0){
            result.add(null);
        }

        for(int i=0;i<n;i+=2){

        }
    }
    public static void main(String [] args){

    }
}