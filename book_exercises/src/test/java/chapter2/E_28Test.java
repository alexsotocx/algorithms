package chapter2;

import datastructures.LNode;
import org.junit.Assert;
import org.junit.Test;

public class E_28Test {

  @Test
  public void findCycle() {
    LNode first = new LNode(1);
    LNode second = new LNode(2);
    LNode third = new LNode(3);
    LNode fourth = new LNode(4);
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;

    Assert.assertTrue(new E2_8().findCycle(first));
  }
}