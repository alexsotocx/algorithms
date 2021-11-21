package amazon.treeBoundary;


import java.util.ArrayList;
import java.util.List;

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
  ArrayList<Integer> res;

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) return new ArrayList<>();
    res = new ArrayList<>();
    res.add(root.val);
    if (isLeaf(root)) return res;

    calculateLeftBoundary(root.left);
    calculateLeafs(root);
    calculateRightBoundary(root.right);

    return res;
  }

  private void calculateLeftBoundary(TreeNode root) {
    if (root == null) return;
    if (isLeaf(root)) return;
    res.add(root.val);
    if (root.left != null) calculateLeftBoundary(root.left);
    else {
      calculateLeftBoundary(root.right);
    }
  }

  private void calculateRightBoundary(TreeNode root) {
    if (root == null) return;
    if (isLeaf(root)) return;
    if (root.right != null) calculateLeftBoundary(root.right);
    else {
      calculateLeftBoundary(root.left);
    }
    res.add(root.val);
  }

  private void calculateLeafs(TreeNode root) {
    if (root == null) return;
    if (isLeaf(root)) {
      res.add(root.val);
      return;
    }

    calculateLeafs(root.left);
    calculateLeafs(root.right);
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }
}
