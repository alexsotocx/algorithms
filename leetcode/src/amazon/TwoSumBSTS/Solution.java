package amazon.TwoSumBSTS;

import java.util.HashSet;

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
  HashSet<Integer> leftTree;

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    leftTree = new HashSet<>();
    traverse(root1);
    return traverseFound(root2, target);
  }

  private boolean traverseFound(TreeNode root, int target) {
    if (root == null) return false;
    return leftTree.contains(target - root.val) || traverseFound(root.left, target) || traverseFound(root.right, target);
  }

  private void traverse(TreeNode root) {
    if (root == null) return;
    leftTree.add(root.val);
    traverse(root.left);
    traverse(root.right);
  }
}
