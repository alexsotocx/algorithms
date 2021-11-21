package amazon.MinStack;

class MinStack {
  private class Node {
    int val;
    Node min;
    Node next;

    public Node(int val, Node min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

  private Node top;

  public MinStack() {

  }

  public void push(int val) {
    Node n = new Node(val, null, top);
    n.min = n;
    if (top != null) {
      if (top.min.val < val) n.min = top.min;
    }
    top = n;
  }

  public void pop() {
    int val = top.val;
    top = top.next;
  }

  public int top() {
    return top.val;
  }

  public int getMin() {
    return top.min.val;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
