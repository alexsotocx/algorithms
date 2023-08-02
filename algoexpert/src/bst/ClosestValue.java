package bst;

public class ClosestValue {
  public static int findClosestValueInBst(BST tree, int target) {
    int closest = tree.value;
    BST pointer = tree;
    while (pointer != null) {
      if (Math.abs(closest - target) > Math.abs(pointer.value - target)) {
        closest = pointer.value;
      }
      if (target < pointer.value) {
        pointer = pointer.left;
      } else {
        pointer = pointer.right;
      }
    }

    return closest;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
