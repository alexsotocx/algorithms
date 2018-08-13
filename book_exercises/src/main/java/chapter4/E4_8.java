package chapter4;

import datastructures.BNode;

public class E4_8 {
  BNode<Integer> findCommonAncestor(BNode<Integer> n1, BNode<Integer> n2, BNode<Integer> root) {
    if (n1 == root || n2 == root) return root;
    boolean n1LeftSide = find(n1, root.left);
    boolean n2LeftSide = find(n2, root.left);
    if ((n1LeftSide && !n2LeftSide) || (n2LeftSide && !n1LeftSide)) return root;
    return n1LeftSide ? findCommonAncestor(n1, n2, root.left) : findCommonAncestor(n1, n2, root.right);
  }

  private boolean find(BNode node, BNode current) {
    if (current == null) return false;
    if (current == node) return true;
    return find(node, current.left) || find(node, current.right);
  }
}
