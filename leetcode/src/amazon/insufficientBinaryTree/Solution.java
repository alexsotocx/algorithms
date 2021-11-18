package amazon.insufficientBinaryTree;

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
  private class Res {
    TreeNode node;
    int maxSum;

    public Res(TreeNode node, int maxSum) {
      this.node = node;
      this.maxSum = maxSum;
    }
  }

  public TreeNode sufficientSubset(TreeNode root, int limit) {
    if (root == null) return null;
    Res r = this.helper(root, limit, 0);
    return r.node;
  }

  private Res helper(TreeNode root, int limit, int sumUntilHere) {
    int s = sumUntilHere + root.val;
    int max = Integer.MIN_VALUE;
    if (root.left == null && root.right == null) {
      if (s < limit) return new Res(null, s);
      return new Res(root, s);
    }


    if (root.left != null) {
      Res sL = helper(root.left, limit, s);
      if (sL.maxSum < limit) root.left = null;
      max = sL.maxSum;
    }

    if (root.right != null) {
      Res sL = helper(root.right, limit, s);
      if (sL.maxSum < limit) root.right = null;
      max = Math.max(sL.maxSum, max);
    }

    if (max < limit) return new Res(null, max);

    return new Res(root, max);
  }
}
