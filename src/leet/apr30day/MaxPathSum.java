package leet.apr30day;

public class MaxPathSum {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  private int maxPathSumUtil(TreeNode node, int[] res) {
    if (node == null) {
      return 0;
    }

    int leftSum = maxPathSumUtil(node.left, res);
    int rightSum = maxPathSumUtil(node.right, res);

    // int max = IntStream.of(node.val, node.val + leftSum, node.val +
    // rightSum).max().getAsInt();
    // res[0] = IntStream.of(res[0], max, node.val + leftSum +
    // rightSum).max().getAsInt();

    int max = Math.max(node.val, Math.max(node.val + leftSum, node.val + rightSum));
    res[0] = Math.max(res[0], Math.max(max, node.val + leftSum + rightSum));
    return max;
  }

  public int maxPathSum(TreeNode root) {
    int[] res = new int[] { Integer.MIN_VALUE };
    maxPathSumUtil(root, res);
    return res[0];
  }
}
