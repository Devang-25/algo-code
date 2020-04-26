package leetcode.medium;

import util.Tree.TreeNode;

/**
 * Created by mns on 11/29/18.
 */
public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode [] result = new TreeNode[]{null,null};
        splitBSTUtil(root,V,result);
        return result;
    }

    private void splitBSTUtil(TreeNode curr, int v, TreeNode[] result){

        if(curr == null){
            return;
        }

        if(curr.val <= v) {
            result[0]=insertIntoBST(result[0], curr.val);
        }else{
            result[1]=insertIntoBST(result[1],curr.val);
        }

        splitBSTUtil(curr.left,v,result);
        splitBSTUtil(curr.right,v,result);
    }

    private TreeNode insertIntoBST(TreeNode root, int val){

        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }else if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}

