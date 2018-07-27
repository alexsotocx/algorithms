package datastructures;


public class LNode {
  public int value;
  public LNode next;

  public LNode() {
  }

  public LNode(int value) {
    this.value = value;
  }

  public LNode(int value, LNode next) {
    this.value = value;
    this.next = next;
  }
}
