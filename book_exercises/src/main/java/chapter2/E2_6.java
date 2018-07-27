package chapter2;

import datastructures.LNode;

public class E2_6 {
  boolean isPalindrome(LNode head) {
    LNode p1 = head, p2 = p1;
    if (p1 == null || p1.next == null) return true;
    if (p1.next.next == null && p1.value == p1.next.value) return true;
    LNode stackp = null;
    int size = 0;
    while (p2 != null && p2.next != null) {
      stackp = new LNode(p1.value, stackp);
      p1 = p1.next;
      p2 = p2.next.next;
      size++;
    }
    if (size % 2 == 0) p1 = p1.next;
    while (size-- > 0) {
      if (stackp.value != p1.value) return false;
      p1 = p1.next;
      stackp = stackp.next;
    }

    return p1 == null;
  }
}
