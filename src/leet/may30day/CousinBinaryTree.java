package leet.may30day;

public class CousinBinaryTree {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  private class Result {
    TreeNode parentX = null;
    TreeNode parentY = null;
    int depthX = -1;
    int depthY = -1;
  }

  private void isCousinsUtil(TreeNode root, int x, int y, int currHeight, Result r) {
    if (root == null)
      return;

    if (root.left != null) {
      if (root.left.val == x) {
        r.parentX = root;
        r.depthX = currHeight + 1;
      } else if (root.left.val == y) {
        r.parentY = root;
        r.depthY = currHeight + 1;
      } else {
        isCousinsUtil(root.left, x, y, currHeight, r);
      }
    }

    if (root.right != null) {
      if (root.right.val == x) {
        r.parentX = root;
        r.depthX = currHeight + 1;
      } else if (root.right.val == y) {
        r.parentY = root;
        r.depthY = currHeight + 1;
      } else {
        isCousinsUtil(root.right, x, y, currHeight, r);
      }
    }

  }

  public boolean isCousins(TreeNode root, int x, int y) {
    Result r = new Result();
    isCousinsUtil(root, x, y, 0, r);

    if (r.depthX != -1 && r.depthX == r.depthY && r.parentX != r.parentY) {
      return true;
    }

    return false;
  }

}
