package leetcode.medium;

public class BinaryTreeLCS {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    private int max;
    public int longestConsecutive2(TreeNode root) {
        if(root == null){
            return 0;
        }
        max = 0;
        longestConsecutiveUtil(root,1);
        return max;
    }

    private void longestConsecutiveUtil(TreeNode root, int agg){
        max = Math.max(max,agg);
        if(root == null){
            return;
        }
        longestConsecutiveUtil(root.left, root.left!= null && root.val == root.left.val-1? agg+1:1);
        longestConsecutiveUtil(root.right, root.right!=null &&root.val == root.right.val-1? agg+1:1);

    }
}
