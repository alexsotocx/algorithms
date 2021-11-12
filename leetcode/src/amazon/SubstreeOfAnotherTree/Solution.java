package amazon.SubstreeOfAnotherTree;

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
  public boolean helper(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) return true;
    if (root == null || subRoot == null) return false;
    return root.val == subRoot.val && helper(root.left, subRoot.left) && helper(root.right, subRoot.right);

  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) return true;
    if (root == null || subRoot == null) return false;
    return helper(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
}
