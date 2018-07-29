package chapter3;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class E3_5Test {

  @Test
  public void Test() {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(8);
    stack.push(4);
    stack.push(1);
    stack.push(2);

    new E3_5().sortStack(stack);
    for(int e : new int[]{1, 2, 3, 4, 8}) assertEquals(e, stack.pop().intValue());

    stack = new Stack<>();
    stack.push(3);
    stack.push(3);
    stack.push(4);
    stack.push(1);
    stack.push(2);

    new E3_5().sortStack(stack);
    for(int e : new int[]{1, 2, 3, 3, 4}) assertEquals(e, stack.pop().intValue());

    stack = new Stack<>();
    stack.push(3);

    new E3_5().sortStack(stack);
    for(int e : new int[]{3}) assertEquals(e, stack.pop().intValue());

    stack = new Stack<>();

    new E3_5().sortStack(stack);
    for(int e : new int[]{}) assertEquals(e, stack.pop().intValue());
  }
}