package stacks.medium;

public class MinMaxStack {
  // Feel free to add new properties and methods to the class.
  static class Node {
    int value;
    int maxAtTop;
    int minAtTop;
    Node prev = null;

    public Node(int v, int max, int min) {
      value = v;
      maxAtTop = max;
      minAtTop = min;
    }
  }

  static class MinMaxStackImplementation {
    Node top = null;

    public int peek() {
      return top.value;
    }

    public int pop() {
      Node oldTop = top;
      top = top.prev;
      return oldTop.value;
    }

    public void push(Integer number) {
      Node newNode = new Node(number, number, number);
      if (top == null) {
        top = newNode;
        return;
      }

      newNode.maxAtTop = Math.max(number, top.maxAtTop);
      newNode.minAtTop = Math.min(number, top.minAtTop);
      newNode.prev = top;
      top = newNode;
    }

    public int getMin() {
      return top.minAtTop;
    }

    public int getMax() {
      return top.maxAtTop;
    }
  }
}
