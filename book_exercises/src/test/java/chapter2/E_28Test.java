package chapter2;

import datastructures.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class E_28Test {

  @Test
  public void findCycle() {
    LinkedListNode first = new LinkedListNode(1);
    LinkedListNode second = new LinkedListNode(2);
    LinkedListNode third = new LinkedListNode(3);
    LinkedListNode fourth = new LinkedListNode(4);
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;

    Assert.assertTrue(new E2_8().findCycle(first));
  }
}
