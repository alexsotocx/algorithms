package chapter2;

import datastructures.LinkedListNode;

public class E2_8 {
  boolean findCycle(LinkedListNode head) {
    LinkedListNode p1 = head;
    LinkedListNode p2 = p1.next;
    while (p1 != null && p2 != null) {
      if (p1 == p2) return true;
      p1 = p1.next;
      p2 = p2.next;
      if (p2 != null) p2 = p2.next;
    }
    return false;
  }
}
