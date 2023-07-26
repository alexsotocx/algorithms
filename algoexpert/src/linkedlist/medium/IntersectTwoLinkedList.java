package linkedlist.medium;

public class IntersectTwoLinkedList {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  private int findLinkedListLength(LinkedList list) {
    int c = 0;
    LinkedList pointer = list;
    while(pointer != null) {
      c++;
      pointer = pointer.next;
    }
    return c;
  }

  private LinkedList advance(LinkedList list, int count) {
    LinkedList pointer = list;
    for (int i = 0; i < count ; i++) {
      pointer = pointer.next;
    }
    return pointer;
  }

  public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    int length1 = this.findLinkedListLength(linkedListOne);
    int length2 = this.findLinkedListLength(linkedListTwo);
    LinkedList bigger = length1 > length2 ? linkedListOne : linkedListTwo;
    LinkedList shorter = length1 > length2 ? linkedListTwo : linkedListOne;
    int diffLength = Math.abs(length1 - length2);
    bigger = this.advance(bigger, diffLength);

    while(bigger != null && shorter != null) {
      if (bigger == shorter) return bigger;
      bigger = bigger.next;
      shorter = shorter.next;
    }

    return null;
  }
}
