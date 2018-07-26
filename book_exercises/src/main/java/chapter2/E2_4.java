package chapter2;

class E2_4Node {
  int value;
  E2_4Node next;

  public E2_4Node(int value) {
    this.value = value;
  }
}

public class E2_4 {
  E2_4Node partition(int p, E2_4Node head) {
    E2_4Node lessThan = null, moreThan = null, headLess = null, headMore = null;
    for (E2_4Node current = head; current != null; current = current.next) {
      if (current.value < p) lessThan = addToPartition(lessThan, current.value);
      else moreThan = addToPartition(moreThan, current.value);
      if (headLess == null) headLess = lessThan;
      if (headMore == null) headMore = moreThan;
    }

    lessThan.next = headMore;
    return headLess;
  }

  private E2_4Node addToPartition(E2_4Node node, int value) {
    if (node == null) return new E2_4Node(value);
    return node.next = new E2_4Node(value);
  }
}
