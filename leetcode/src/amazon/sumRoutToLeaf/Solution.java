package amazon.sumRoutToLeaf;


// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  private int total = 0;

  public int sumRootToLeaf(TreeNode root) {
    total = 0;
    this.helper(root, 0);
    return total;
  }

  private void helper(TreeNode root, int v) {
    if (root == null) return;
    v <<= 1;
    v += root.val;
    if (root.left == null && root.right == null) {
      total += v;
      return;
    }
    helper(root.left, v);
    helper(root.right, v);
    return;
  }
}
