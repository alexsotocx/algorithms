package chapter4;

import datastructures.BNode;

public class E4_6 {
  BNode<Integer> nextSucccesor(BNode<Integer> node) {
    if (node == null || (node.parent == null && node.right == null)) return null;
    if (node.right != null) {
      node = node.right;
      while (node.left != null) node = node.left;
      return node;
    }
    BNode<Integer> temp = node;
    while (temp.parent != null) {
      if (temp.parent.data < node.data)
        temp = temp.parent;
      else
        return temp.parent;
    }
    return temp;
  }
}