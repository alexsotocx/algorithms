package chapter4;

import datastructures.BinaryNode;

public class NextInOrderSuccessor<T extends Comparable<T>> {
  BinaryNode<T> findNextInOrderSuccessor(BinaryNode<T> current) {
    if (current.right != null) {
      current = current.right;
      while (current.left != null) current = current.left;
      return current;
    }
    BinaryNode<T> val = current;
    current = current.parent;
    while (current != null && current.data.compareTo(val.data) < 0)
      current = current.parent;
    return current;
  }
}
