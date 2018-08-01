package datastructures;

public class BinaryTreeNode<T> {
  public BinaryTreeNode<T> right, left, parent;
  public T data;
  public int height = -1;

  public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right) {
    this.right = right;
    this.left = left;
    this.data = data;
  }

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}
