package leetcode.medium;

import util.Tree.TreeNode;

public class BinaryTreePostInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(0,postorder.length-1,0,inorder.length-1,postorder,inorder);
    }

    private TreeNode buildTreeUtil(int pleft, int pright,int ileft, int iright, int[] postorder, int[] inorder){

        if(pleft > pright){
            return null;
        }

        TreeNode node = new TreeNode(postorder[pright]);
        int index = -1;
        for(int i=ileft;i<=iright;i++){
            if(inorder[i] == postorder[pright]){
                index = i;
                break;
            }
        }
        node.left = buildTreeUtil(pleft,pright-(iright-index)-1,ileft,index-1, postorder, inorder);
        node.right = buildTreeUtil(pright-iright+index,pright-1,index+1,iright,postorder,inorder);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreePostInorder bp = new BinaryTreePostInorder();
        TreeNode t = bp.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println();
    }
}
