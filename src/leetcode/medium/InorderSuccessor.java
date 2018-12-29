package medium;

import util.Tree.TreeNode;

/**
 * Created by mns on 12/19/18.
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode fallBack = null;
        TreeNode curr = root;

        while(curr.val != p.val){
            if(p.val < curr.val){
                fallBack = curr;
                curr = curr.left;
            }else if(p.val > curr.val){
                curr = curr.right;
            }
        }

        if(curr.right != null){
            return leftMost(curr.right);
        }

        return fallBack;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root!=null){
            if(p.val<root.val){
                ans = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ans;
    }

    private TreeNode leftMost(TreeNode root){
        TreeNode ptr = root;
        while(ptr.left != null){
            ptr = ptr.left;
        }
        return ptr;
    }
}
