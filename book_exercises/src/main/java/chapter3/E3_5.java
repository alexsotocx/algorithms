package chapter3;

import java.util.Stack;

public class E3_5 {
  void sortStack(Stack<Integer> stack) {
    Stack<Integer> tempStack = new Stack<>();
    while (!stack.empty()) {
      while (!stack.empty() && (tempStack.empty() || stack.peek() >= tempStack.peek())) tempStack.push(stack.pop());
      if (stack.empty()) break;
      Integer temp = stack.pop();
      while (!tempStack.empty() && temp < tempStack.peek()) stack.push(tempStack.pop());
      stack.push(temp);
    }

    while (!tempStack.empty()) stack.push(tempStack.pop());
  }
}
