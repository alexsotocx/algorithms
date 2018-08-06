package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class E3_3<T> {
  private int eStackCapacity;
  private ArrayList<Stack<T>> stacks;

  public E3_3(int eStackCapacity) {
    this.eStackCapacity = eStackCapacity;
    stacks = new ArrayList<>();
  }

  public void push(T data) {
    checkForIncrease();
    currentStack().push(data);
  }

  private void checkForIncrease() {
    if (currentStack() == null) {
      stacks.add(new Stack<>());
      return;
    }
    if (currentStack().size() >= eStackCapacity) stacks.add(new Stack<>());
  }

  public T pop() {
    if (currentStack() == null) return null;
    if (currentStack().size() == 0) stacks.remove(stacks.size() - 1);
    if (currentStack() == null) return null;
    return currentStack().pop();
  }

  private Stack<T> currentStack() {
    if (stacks.size() == 0) return null;
    return stacks.get(stacks.size() - 1);
  }
}
