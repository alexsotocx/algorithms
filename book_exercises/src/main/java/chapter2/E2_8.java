package chapter2;

import datastructures.LNode;

public class E2_8 {
  boolean findCycle(LNode head) {
    LNode p1 = head;
    LNode p2 = p1.next;
    while (p1 != null && p2 != null) {
      if (p1 == p2) return true;
      p1 = p1.next;
      p2 = p2.next;
      if (p2 != null) p2 = p2.next;
    }
    return false;
  }
}
