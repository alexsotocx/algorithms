package chapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E2_5_1Test {

  @Test
  public void sumList() {
    E2_5Node h1first = new E2_5Node(7);
    E2_5Node h1second = new E2_5Node(1);
    E2_5Node h1third = new E2_5Node(6);
    h1first.next = h1second;
    h1second.next = h1third;

    E2_5Node h2first = new E2_5Node(5);
    E2_5Node h2second = new E2_5Node(9);
    E2_5Node h2third = new E2_5Node(2);
    h2first.next = h2second;
    h2second.next = h2third;
    E2_5Node result = new E2_5_1().sumList(h1first, h2first);
    for (int v : new int[]{2, 1, 9}) {
      assertEquals(v, result.value);
      result = result.next;
    }
  }
}