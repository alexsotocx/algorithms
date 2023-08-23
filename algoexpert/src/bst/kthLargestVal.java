package bst;

public class kthLargestVal {
  int k = 0;
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  private Integer findKthLargestValueInBstHelper(BST tree) {
    if (tree == null) return null;
    Integer right = findKthLargestValueInBstHelper(tree.right);
    if (right != null) return right;

    this.k--;
    if (k == 0) return tree.value;

    Integer left = findKthLargestValueInBstHelper(tree.left);
    return left;
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    this.k = k;
    return findKthLargestValueInBstHelper(tree);
  }
}
