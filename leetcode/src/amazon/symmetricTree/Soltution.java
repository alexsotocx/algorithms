package amazon.symmetricTree;

import java.util.ArrayList;

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
  private ArrayList<Object> traverse;

  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
  }
}
