package Month30Challenge.SecondWeek;

class Node {
  int data;
  Node next;
  Node min;

  public Node() {
  }

  public Node(int data) {
    this.data = data;
  }
}

public class MinStack {
  Node top;

  /**
   * initialize your data structure here.
   */
  public MinStack() {

  }

  public void push(int x) {
    Node newNode = new Node(x);
    newNode.min = newNode;
    if (top != null && x > top.min.data) {
      newNode.min = top.min;
    }
    newNode.next = top;
    top = newNode;
  }

  public void pop() {
    if (top != null) {
      top = top.next;
    }
  }

  public int top() {
    if (top != null) {
      return top.data;
    }
    return 0;
  }

  public int getMin() {
    return top.min.data;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
