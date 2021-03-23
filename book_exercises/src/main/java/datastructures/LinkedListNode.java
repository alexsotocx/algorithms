package datastructures;


public class LinkedListNode {
  public int value;
  public LinkedListNode next;

  public LinkedListNode() {
  }

  public LinkedListNode(int value) {
    this.value = value;
  }

  public LinkedListNode(int value, LinkedListNode next) {
    this.value = value;
    this.next = next;
  }
}
