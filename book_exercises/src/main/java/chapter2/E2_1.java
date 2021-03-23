package chapter2;

import datastructures.DoubleLinkedList;

import java.util.HashSet;

public class E2_1 {
  DoubleLinkedList<Integer> removeDup(DoubleLinkedList<Integer> list) {
    HashSet<Integer> set = new HashSet<>();
    DoubleLinkedList<Integer>.Link<Integer> link = list.getFirst();
    while (link != null) {
      if (set.contains(link.data)) list.delete(link);
      set.add(link.data);
      link = link.next;
    }
    return list;
  }


}
