package chapter4;

import datastructures.BinaryTreeNode;

public class E4_5 {
  boolean isBST(BinaryTreeNode<Integer> current) {
    if (current == null) return true;
    if (current.left != null && current.left.data > current.data) return false;
    if (current.right != null && current.right.data <= current.data) return false;
    return isBST(current.right) && isBST(current.left);
  }
}
