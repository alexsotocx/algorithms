package amazon.largestKthOnBST;

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
  int findKthLargest(TreeNode root, int k) {
    return findKthLargestHelper(root, k);
  }

  Integer findKthLargestHelper(TreeNode root, int k) {
    if (root == null) return null;
    Integer right = findKthLargestHelper(root.right, k);
    if (right != null) return right;
    k--;
    if (k == 0) return root.val;
    return findKthLargestHelper(root.left, k);
  }
}
