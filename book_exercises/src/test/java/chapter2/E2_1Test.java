package chapter2;

import datastructures.DoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class E2_1Test {

  @Test
  public void removeDup() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(2);
    linkedList.append(4);

    new E2_1().removeDup(linkedList);
    Integer[] result = new Integer[]{1, 2, 3, 4};
    int i = 0;
    for (DoubleLinkedList<Integer>.Link<Integer> integerLink : linkedList) {
      assertEquals(result[i++], integerLink.data);
    }

  }
}