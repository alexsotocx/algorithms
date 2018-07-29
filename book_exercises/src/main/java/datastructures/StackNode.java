package datastructures;

public class StackNode<T> {
  public T value;
  public StackNode<T> next;
  public StackNode<T> min;

  public StackNode() {
  }

  public StackNode(T value) {
    this.value = value;
  }

  public StackNode(T value, StackNode<T> next) {
    this.value = value;
    this.next = next;
  }
}
