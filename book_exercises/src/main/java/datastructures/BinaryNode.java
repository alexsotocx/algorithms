package datastructures;

public class BinaryNode<T> {
  public BinaryNode<T> right, left, parent;
  public T data;
  public int height = -1;

  public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
    this.right = right;
    this.left = left;
    this.data = data;
  }

  public BinaryNode(T data) {
    this.data = data;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }
}
