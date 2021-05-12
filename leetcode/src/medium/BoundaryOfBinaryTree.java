package medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
  ArrayList<Integer> sol = new ArrayList<>();

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root.left == null && root.right == null) {
      sol.add(root.val);
      return sol;
    }
    sol.add(root.val);
    findLeftBoundary(root.left);
    findLeafs(root);
    findRightBoundary(root.right);
    return sol;
  }

  private void findLeftBoundary(TreeNode root) {
    if (root == null) return;
    if (root.left != null) {
      sol.add(root.val);
      findLeftBoundary(root.left);
    } else if (root.right != null) {
      sol.add(root.val);
      findLeftBoundary(root.right);
    }
  }

  private void findRightBoundary(TreeNode root) {
    if (root == null) return;
    if (root.right != null) {
      findRightBoundary(root.right);
      sol.add(root.val);
    } else if (root.left != null) {
      findRightBoundary(root.left);
      sol.add(root.val);
    }
  }

  private void findLeafs(TreeNode root) {
    if(root == null) return;
    findLeafs(root.left);
    if (root.left == null && root.right == null) sol.add(root.val);
    findLeafs(root.right);
  }
}
