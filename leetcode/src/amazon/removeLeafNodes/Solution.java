package amazon.removeLeafNodes;

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
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    boolean allRemoved = removeTarget(root, target);
    if (allRemoved) return null;
    return root;
  }

  private boolean removeTarget(TreeNode root, int target) {
    if (root == null) return true;
    boolean left = removeTarget(root.left, target);
    boolean right = removeTarget(root.right, target);
    if (left) root.left = null;
    if (right) root.right = null;
    return left && right && target == root.val;
  }
}
