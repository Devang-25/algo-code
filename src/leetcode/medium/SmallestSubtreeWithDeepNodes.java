package leetcode.medium;

import util.Tree.BinaryTree;
import util.Tree.TreeNode;

public class SmallestSubtreeWithDeepNodes {
    TreeNode result ;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        result = null;
        int height = getHeight(root);
        util(root,height,0);
        return result;
    }

    private boolean util(TreeNode node, int height, int curr){
        if(node == null){
            if(curr == height){
                return true;
            }
            return false;
        }

        boolean left = util(node.left,height,curr+1);
        boolean right = util(node.right,height,curr+1);

        if(left && right || curr == height-1){
            result = node;
        }

        return left || right;
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1+ Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        SmallestSubtreeWithDeepNodes sm = new SmallestSubtreeWithDeepNodes();
        TreeNode tn = BinaryTree.createTree("3,5,1,6,2,0,8,10,,7,4,22");
        TreeNode result = sm.subtreeWithAllDeepest(tn);
        System.out.println(result);
    }
}
