package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedStackTest {
  @Test
  public void Test() {
    SortedStack stack = new SortedStack();
    stack.push(3);
    stack.push(8);
    stack.push(4);
    stack.push(1);
    stack.push(2);

    assertEquals(Integer.valueOf(8), stack.peek());
    for (int e : new int[]{8, 4, 3, 2, 1}) assertEquals(e, stack.pop());
  }
}
