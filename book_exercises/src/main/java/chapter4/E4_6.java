package chapter4;

import datastructures.BinaryNode;

public class E4_6 {
  BinaryNode<Integer> nextSucccesor(BinaryNode<Integer> node) {
    if (node == null || (node.parent == null && node.right == null)) return null;
    if (node.right != null) {
      node = node.right;
      while (node.left != null) node = node.left;
      return node;
    }
    BinaryNode<Integer> temp = node;
    while (temp.parent != null) {
      if (temp.parent.data < node.data)
        temp = temp.parent;
      else
        return temp.parent;
    }
    return temp;
  }
}
