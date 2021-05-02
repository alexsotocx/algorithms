package easy;

import java.util.TreeSet;

class MaxStack {
  static int count = 0;

  private class Node implements Comparable<Node> {

    int val;
    Node next;
    Node prev;
    int insertedSize;

    public int compareTo(Node o) {
      if (val != o.val) return Integer.compare(o.val, val);
      return Integer.compare(o.insertedSize, insertedSize);
    }

    Node(int val) {
      this.insertedSize = MaxStack.count++;
      this.val = val;
    }
  }

  Node head;
  TreeSet<Node> nodes;

  /**
   * initialize your data structure here.
   */
  public MaxStack() {
    nodes = new TreeSet<>();
  }

  public void push(int x) {
    Node newNode = new Node(x);
    nodes.add(newNode);
    if (head != null) {
      newNode.next = head;
      head.prev = newNode;
    }
    head = newNode;
  }

  public int pop() {
    nodes.remove(head);
    int val = head.val;
    head = head.next;
    if (head != null)
      head.prev = null;
    return val;
  }

  public int top() {
    return head.val;
  }

  public int peekMax() {
    return nodes.first().val;
  }

  public int popMax() {
    Node max = nodes.first();
    nodes.remove(max);
    if (max == head) return this.pop();
    else {
      max.prev.next = max.next;
      if (max.next != null)
        max.next.prev = max.prev;
    }
    return max.val;
  }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
