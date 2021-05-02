package medium;


import java.util.Stack;

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

class BSTIterator {

  Stack<TreeNode> stack;


  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    goToLeft(root);

  }

  private void goToLeft(TreeNode root) {
    TreeNode x = root;
    while (x != null) {
      stack.add(x);
      x = x.left;
    }
  }

  public int next() {
    TreeNode nextNode = stack.pop();
    goToLeft(nextNode.right);
    return nextNode.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
