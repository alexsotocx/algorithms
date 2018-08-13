package chapter2;

import datastructures.DoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E2_3Test {

  @Test
  public void findKnthElement() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    linkedList.append(6);

    assertEquals(new Integer(5), new E2_3().findKnthElement(linkedList.getFirst(), 2));
    assertEquals(new Integer(6), new E2_3().findKnthElement(linkedList.getFirst(), 1));
    assertEquals(new Integer(4), new E2_3().findKnthElement(linkedList.getFirst(), 3));
  }
}