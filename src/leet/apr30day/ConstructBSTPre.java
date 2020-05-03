package leet.apr30day;

import java.util.ArrayDeque;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class TreeNodeMeta {
  private int min;
  private int max;
  private TreeNode treeNode;

  TreeNodeMeta(TreeNode t, int min, int max) {
    this.treeNode = t;
    this.min = min;
    this.max = max;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public TreeNode getTreeNode() {
    return treeNode;
  }
}

public class ConstructBSTPre {

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[0]);
    ArrayDeque<TreeNodeMeta> st = new ArrayDeque<>();
    st.offerLast(new TreeNodeMeta(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    for (int i = 1; i < preorder.length; i++) {
      TreeNode newNode = new TreeNode(preorder[i]);
      while (preorder[i] > st.peekLast().getTreeNode().val && preorder[i] > st.peekLast().getMax()) {
        st.pollLast();
      }

      TreeNodeMeta parent = st.getLast();
      if (preorder[i] < parent.getTreeNode().val) {
        parent.getTreeNode().left = newNode;
        st.offerLast(new TreeNodeMeta(newNode, parent.getMin(), parent.getTreeNode().val));
      } else {
        parent.getTreeNode().right = newNode;
        st.offerLast(new TreeNodeMeta(newNode, parent.getTreeNode().val, parent.getMax()));
      }
    }

    return root;
  }

}
