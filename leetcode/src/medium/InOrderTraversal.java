package medium;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
  ArrayList<Integer> traversal = new ArrayList<Integer>();

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return traversal;
    inorderTraversal(root.left);
    traversal.add(root.val);
    inorderTraversal(root.right);
    return traversal;
  }
}
