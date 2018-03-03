package datastructures;

public class Stack<T> {
  private DoubleLinkedList<T> linkedList = new DoubleLinkedList<>();
  public void insert(T data) {
    linkedList.append(data);
  }

  public T first() {
    return linkedList.getLast().data;
  }

  public T removeFirst() {
    return linkedList.deleteLast().data;
  }

  public boolean isEmpty() {
    return linkedList.isEmpty();
  }
}
