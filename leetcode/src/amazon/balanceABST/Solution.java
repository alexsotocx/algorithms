package amazon.balanceABST;

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
  ArrayList<Integer> inOrderT;

  public TreeNode balanceBST(TreeNode root) {
    inOrderT = new ArrayList<>();
    inOrder(root);
    return balance(0, inOrderT.size() - 1);
  }

  private TreeNode balance(int l, int h) {
    if (l > h) return null;
    if (l == h) return new TreeNode(inOrderT.get(l));
    int mid = l + (h - l) / 2;
    TreeNode root = new TreeNode(inOrderT.get(mid));
    root.left = balance(l, mid - 1);
    root.right = balance(mid + 1, h);
    return root;
  }

  private void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(node.left);
    inOrderT.add(node.val);
    inOrder(node.right);
  }
}
