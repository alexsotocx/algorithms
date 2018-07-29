package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class E3_3Test {

  @Test
  public void Test() {
    E3_3<Integer> stackOfStacks = new E3_3<>(3);
    stackOfStacks.push(1);
    stackOfStacks.push(2);
    stackOfStacks.push(3);
    stackOfStacks.push(4);
    stackOfStacks.push(5);
    stackOfStacks.push(6);
    stackOfStacks.push(7);
    stackOfStacks.push(8);

    assertEquals(stackOfStacks.pop().intValue(), 8);
    assertEquals(stackOfStacks.pop().intValue(), 7);
    assertEquals(stackOfStacks.pop().intValue(), 6);
    assertEquals(stackOfStacks.pop().intValue(), 5);
    assertEquals(stackOfStacks.pop().intValue(), 4);
    assertEquals(stackOfStacks.pop().intValue(), 3);
    assertEquals(stackOfStacks.pop().intValue(), 2);
    assertEquals(stackOfStacks.pop().intValue(), 1);
    assertNull(stackOfStacks.pop());
  }
}