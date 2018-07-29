package chapter3;

import datastructures.StackNode;

public class E3_2 {
  StackNode<Integer> top;

  public void push(Integer data) {
    StackNode<Integer> temp = new StackNode<>(data, top);
    if (top == null) temp.min = temp;
    else temp.min = top.min.value < data ? top.min : temp;
    top = temp;
  }

  public Integer pop() {
    if (top == null) return null;
    StackNode<Integer> temp = top;
    top = top.next;
    return temp.value;
  }


  public Integer min() {
    return top == null ? null : top.min.value;
  }
}
