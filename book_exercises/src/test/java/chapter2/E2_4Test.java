package chapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E2_4Test {

  @Test
  public void partition() {
    E2_4Node first = new E2_4Node(3);
    E2_4Node second = new E2_4Node(10);
    E2_4Node third = new E2_4Node(5);
    E2_4Node fourth = new E2_4Node(4);
    first.next = second;
    second.next = third;
    third.next = fourth;

    E2_4Node result = new E2_4().partition(5, first);
    for (int v : new int[]{3, 4, 10, 5}) {
      assertEquals(v, result.value);
      result = result.next;
    }
  }
}