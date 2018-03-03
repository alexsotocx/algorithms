package datastructures;

public class Queue<T> {
  private DoubleLinkedList<T> linkedList = new DoubleLinkedList<>();
  public void insert(T data) {
    linkedList.append(data);
  }

  public T first() {
    return linkedList.getFirst().data;
  }

  public T removeFirst() {
    return linkedList.deleteFirst().data;
  }

  public boolean isEmpty() {
    return linkedList.isEmpty();
  }
}
