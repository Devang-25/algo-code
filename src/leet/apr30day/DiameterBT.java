package leet.apr30day;

public class DiameterBT {

  public class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int x) {
      val = x;
    }
  }

  public class MaxDiameter {
    MaxDiameter(int x) {
      this.x = x;
    }

    int x;
  }

  private int diameterOfBinaryTreeUtil(TreeNode root, MaxDiameter md) {
    if (root == null) {
      return 0;
    }

    int left = diameterOfBinaryTreeUtil(root.left, md);
    int right = diameterOfBinaryTreeUtil(root.right, md);

    int max = 1 + Math.max(left, right);
    md.x = Math.max(md.x, left + right + 1);

    return max;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    MaxDiameter md = new MaxDiameter(0);
    diameterOfBinaryTreeUtil(root, md);
    return md.x - 1;
  }

  public static void main(String[] args) {

  }
}
