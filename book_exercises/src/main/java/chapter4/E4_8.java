package chapter4;

import datastructures.BinaryTreeNode;

public class E4_8 {
  BinaryTreeNode<Integer> findCommonAncestor(BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2, BinaryTreeNode<Integer> root) {
    if (n1 == root || n2 == root) return root;
    boolean n1LeftSide = find(n1, root.left);
    boolean n2LeftSide = find(n2, root.left);
    if ((n1LeftSide && !n2LeftSide) || (n2LeftSide && !n1LeftSide)) return root;
    return n1LeftSide ? findCommonAncestor(n1, n2, root.left) : findCommonAncestor(n1, n2, root.right);
  }

  private boolean find(BinaryTreeNode node, BinaryTreeNode current) {
    if (current == null) return false;
    if (current == node) return true;
    return find(node, current.left) || find(node, current.right);
  }
}
