package chapter2;

import datastructures.DoubleLinkedList;

public class E2_3 {
  Integer findKnthElement(DoubleLinkedList<Integer>.Link<Integer> head, int k) {
    DoubleLinkedList<Integer>.Link<Integer> p2 = head, p1 = head;
    while (k-- > 0) {
      if (p1.next == null) return null;
      p1 = p1.next;
    }

    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }

    return p2.data;
  }
}
