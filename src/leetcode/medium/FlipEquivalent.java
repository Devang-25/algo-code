package medium;

import util.Tree.TreeNode;

/**
 * Created by mns on 12/27/18.
 */
public class FlipEquivalent {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        return root1.val == root2.val &&
                ((flipEquiv(root1.left,  root2.left) && flipEquiv(root1.right,root2.right)) ||
                (flipEquiv(root1.left,  root2.right) && flipEquiv(root1.right,root2.left)));
    }
}
