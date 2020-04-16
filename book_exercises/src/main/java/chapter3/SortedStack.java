package chapter3;

import java.util.Deque;
import java.util.LinkedList;

public class SortedStack {
  Deque<Integer> stack = new LinkedList<>();
  Deque<Integer> temporal = new LinkedList<>();

  void push(int data) {
    if(stack.isEmpty()) stack.push(data);
    else {
      while(!stack.isEmpty() && stack.peek() > data) {
        temporal.push(stack.pop());
      }
      stack.push(data);
      shift();
    }
  }

  void shift() {
    while(!temporal.isEmpty()) stack.push(temporal.pop());
  }

  int pop() {
    return stack.pop();
  }

  Integer peek() {
    return stack.isEmpty() ? null : stack.peekFirst();
  }
}
