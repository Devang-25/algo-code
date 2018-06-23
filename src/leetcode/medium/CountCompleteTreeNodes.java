package leetcode.medium;

public class CountCompleteTreeNodes {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = getHeight(root.left);
        int rh= getHeight(root.right);
        if(lh == rh){
            return 1+(int)Math.pow(2,lh)-1 + countNodes(root.right);
        }else if( lh > rh){
            return 1+(int)Math.pow(2,rh)-1 + countNodes(root.left);
        }
        return -1;
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 +  getHeight(root.left);
    }
}
