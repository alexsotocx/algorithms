package microsoft.inOrderSuccesor;

import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  private TreeNode next(TreeNode root) {
    if (root == null) return null;
    TreeNode n = root.right;
    while (n != null && n.left != null) n = n.left;
    return n;
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode c = root;
    final Stack<TreeNode> st = new Stack<>();

    st.push(root);
    while (c != null) {
      if (c.val < p.val) {
        c = c.right;
      } else if (c.val == p.val) {
        TreeNode ans = next(c);
        if (ans == null) {
          while (!st.empty()) {
            TreeNode n = st.pop();
            if (n.val > p.val) return n;
          }
        }
        return ans;
      } else {
        c = c.left;
      }
      st.push(c);
    }
    return null;
  }
}
