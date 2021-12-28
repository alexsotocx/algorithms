package amazon.infixBinaryExpression;

import java.util.HashMap;
import java.util.Stack;

class Node {
  char val;
  Node left;
  Node right;

  Node() {
    this.val = ' ';
  }

  Node(char val) {
    this.val = val;
  }

  Node(char val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  private static final HashMap<Character, Integer> priority = new HashMap<>();

  static {
    priority.put('+', 1);
    priority.put('-', 1);
    priority.put('*', 2);
    priority.put('/', 2);
  }

  private char[] convertToPosfix(String s) {
    Stack<Character> st = new Stack<>();
    st.push('#');
    StringBuilder posFixExpression = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') posFixExpression.append(c);
      else if (c == '(') st.push(c);
      else if (c == ')') {
        while (st.peek() != '#' && st.peek() != '(') {
          posFixExpression.append(st.pop());
        }
        st.pop();
      } else {
        int p = priority.getOrDefault(c, 0);
        while (st.peek() != '#' && p <= priority.getOrDefault(st.peek(), 0)) {
          posFixExpression.append(st.pop());
        }
        st.push(c);
      }
    }
    while (st.peek() != '#') posFixExpression.append(st.pop());
    return posFixExpression.toString().toCharArray();
  }

  public Node expTree(String s) {
    char[] exp = convertToPosfix(s);
    Stack<Node> tree = new Stack<>();
    for (char c : exp) {
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        Node b = tree.pop();
        Node a = tree.pop();
        tree.push(new Node(c, a, b));
      } else {
        tree.push(new Node(c));
      }
    }
    return tree.peek();
  }
}
