package datastructures;

public class BNode<T> {
  public BNode<T> right, left, parent;
  public T data;
  public int height = -1;

  public BNode(T data, BNode left, BNode right) {
    this.right = right;
    this.left = left;
    this.data = data;
  }

  public BNode(T data) {
    this.data = data;
  }
}
