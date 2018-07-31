package chapter4;

import datastructures.BinaryTreeNode;

public class E4_4 {
  boolean isBalanced(BinaryTreeNode<Integer> root) {
    calculateHeight(root);
    return checkBalance(root);
  }

  private int calculateHeight(BinaryTreeNode current) {
    if (current == null) return 0;
    //if (current.height != -1) return current.height;
    return current.height = 1 + Math.max(calculateHeight(current.left), calculateHeight(current.right));
  }

  private boolean checkBalance(BinaryTreeNode current) {
    if (current == null) return true;
    if (!checkBalance(current.left)) return false;
    if (!checkBalance(current.right)) return false;
    int hl = current.left == null ? 0 : current.left.height;
    int hr = current.right == null ? 0 : current.right.height;
    return Math.abs(hl - hr) <= 1;
  }


}
