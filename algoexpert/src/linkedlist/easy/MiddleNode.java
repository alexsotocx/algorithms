package linkedlist.easy;

public class MiddleNode {
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList middleNode(LinkedList linkedList) {
    if (linkedList.next == null) return linkedList;
    LinkedList pointer = linkedList;
    LinkedList fastPointer = linkedList;
    while(fastPointer.next != null) {
      pointer = pointer.next;
      fastPointer = fastPointer.next;

      if (fastPointer.next != null) {
        fastPointer = fastPointer.next;
      }
    }
    return pointer;
  }
}
