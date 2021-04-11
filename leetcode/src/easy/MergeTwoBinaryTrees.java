package easy;

public class MergeTwoBinaryTrees {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return null;
    TreeNode newNode = new TreeNode(0);
    if (root1 != null) newNode.val += root1.val;
    if (root2 != null) newNode.val += root2.val;
    newNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
    newNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
    return newNode;
  }
}
