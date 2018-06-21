package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

  @Test
  public void insert() {
    Stack<Integer> stack =  new Stack<>();
    stack.insert(1);
    stack.insert(2);
    stack.insert(3);
    assertStack(stack, new int[] {3, 2, 1});
  }

  @Test
  public void first() {
    Stack<Integer> stack =  new Stack<>();
    stack.insert(1);

    assertEquals(stack.first().longValue(), 1);
    assertFalse("stack must not be empty", stack.isEmpty());
  }

  @Test
  public void removeFirst() {
    Stack<Integer> stack =  new Stack<>();
    stack.insert(1);

    assertEquals(stack.removeFirst().longValue(), 1);
    assertTrue("stack must be empty", stack.isEmpty());
  }

  @Test
  public void isEmpty() {
    Stack<Integer> stack =  new Stack<>();
    assertTrue("stack must be empty", stack.isEmpty());
  }

  private void assertStack(Stack<Integer> q, int[] expected) {
    for(int data : expected)
      assertEquals(q.removeFirst().longValue(), data);
    assertTrue("stack is empty after loops", q.isEmpty());
  }
}