package linkedlist.easy;

public class RemoveDuplicates {
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    LinkedList pointer = linkedList;
    while(pointer != null) {
      while(pointer.next != null && pointer.next.value == pointer.value) {
        pointer.next = pointer.next.next;
      }
      pointer = pointer.next;
    }
    return linkedList;
  }
}
