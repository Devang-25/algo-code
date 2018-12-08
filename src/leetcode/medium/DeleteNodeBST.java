package medium;

import util.Tree.TreeNode;

/**
 * Created by mns on 11/29/18.
 */
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if( key == root.val){
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode curr = root.right, parent = null;
                while (curr.left != null){
                    parent = curr;
                    curr = curr.left;
                }
                if(parent != null){
                    parent.left = curr.right;
                }
                curr.left = root.left;

                if(curr != root.right){
                    curr.right = root.right;
                }
                return curr;
            }
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }

        return root;
    }


}
