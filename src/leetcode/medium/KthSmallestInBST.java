package leetcode.medium;

import util.Tree.BinaryTree;
import util.Tree.TreeNode;


public class KthSmallestInBST {

    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        result = null;
        kthSmallestUtil(root,k);
        return result == null ? -1:result.val;
    }

    private int kthSmallestUtil(TreeNode root, int k){
        if(root == null || result != null){
            return 0;
        }
        int left,right;
        left = kthSmallestUtil(root.left,k);
        if(k-left-1 == 0){
            result = root;
        }
        right = kthSmallestUtil(root.right,k-left-1);
        return left+right+1;
    }


    public static void main(String[] args) {
        TreeNode  t = BinaryTree.createTree("3,1,4,,2");
        KthSmallestInBST k = new KthSmallestInBST();
        System.out.println(k.kthSmallest(t,1));
        t = BinaryTree.createTree("5,3,6,2,4,,,1");
        System.out.println(k.kthSmallest(t,3));
    }
}
