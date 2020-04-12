package Month30Challenge.SecondWeek;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class PathResult {
  int maxDeep;
  int maxPath;

  public PathResult(int maxDeep, int maxPath) {
    this.maxDeep = maxDeep;
    this.maxPath = maxPath;
  }
}

public class DiameterOfTree {
  public int diameterOfBinaryTree(TreeNode root) {
    int diameter = findDiameter(root).maxPath;
    return diameter > 0 ? diameter - 1 : 0;
  }

  private PathResult findDiameter(TreeNode currentRoot) {
    if (currentRoot == null) return new PathResult(0, 0);
    PathResult left = findDiameter(currentRoot.left);
    PathResult right = findDiameter(currentRoot.right);
    int pathIncludingSelf = 1 + left.maxDeep + right.maxDeep;
    int maxPath = Math.max(pathIncludingSelf, Math.max(left.maxPath, right.maxPath));
    int deep = 1 + Math.max(left.maxDeep, right.maxDeep);

    return new PathResult(deep, maxPath);
  }
}
