package amazon.connectTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};


class Solution {
  private class Pair {
    Node n;
    int level;

    Pair(Node n, int level) {
      this.n = n;
      this.level = level;
    }
  }

  public Node connect(Node root) {
    if (root == null) return null;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));
    ArrayList<ArrayList<Node>> levels = new ArrayList<>();
    while (!q.isEmpty()) {
      Pair c = q.poll();
      ArrayList<Node> currentLevel;
      if (levels.size() == c.level) levels.add(currentLevel = new ArrayList<>());
      else currentLevel = levels.get(levels.size() - 1);
      currentLevel.add(c.n);
      if (c.n.left == null) continue;
      q.add(new Pair(c.n.left, c.level + 1));
      q.add(new Pair(c.n.right, c.level + 1));
    }
    for (ArrayList<Node> level : levels) {
      for (int i = 0; i < level.size() - 1; i++) {
        level.get(i).next = level.get(i + 1);
      }
    }
    return root;
  }
}
