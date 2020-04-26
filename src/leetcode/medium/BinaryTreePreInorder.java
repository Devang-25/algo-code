package leetcode.medium;

import util.Tree.TreeNode;

public class BinaryTreePreInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    private TreeNode buildTreeUtil(int pleft, int pright,int ileft, int iright, int[] preorder, int[] inorder){

        if(pleft > pright){
            return null;
        }

        TreeNode node = new TreeNode(preorder[pleft]);
        int index = -1;
        for(int i=ileft;i<=iright;i++){
            if(inorder[i] == preorder[pleft]){
                index = i;
                break;
            }
        }
        node.left = buildTreeUtil(pleft+1,pleft+index-ileft,ileft,index-1, preorder, inorder);
        node.right = buildTreeUtil(pleft+index-ileft+1,pright,index+1,iright,preorder,inorder);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreePreInorder bp = new BinaryTreePreInorder();
        bp.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
