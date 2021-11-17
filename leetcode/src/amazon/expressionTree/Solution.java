package amazon.expressionTree;

import java.util.HashMap;
import java.util.Stack;

abstract class Node {
  public abstract int evaluate();
};

interface IntFunction {
  int run(int a, int b);
}

class OperatorNode extends Node {
  Node left, right;
  String operator;

  private static final HashMap<String, IntFunction> functions = new HashMap<>();

  static {
    functions.put("+", (int a, int b) -> a + b);
    functions.put("-", (int a, int b) -> a - b);
    functions.put("/", (int a, int b) -> a / b);
    functions.put("*", (int a, int b) -> a * b);
  }

  public OperatorNode(String operator, Node left, Node right) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }

  public static void addOperator(String operator, IntFunction f) {
    functions.put(operator, f);
  }


  public int evaluate() {
    return functions.get(this.operator).run(left.evaluate(), right.evaluate());
  }
}

class NumberNode extends Node {
  int val;

  public NumberNode(String s) {
    this.val = Integer.parseInt(s);
  }

  public int evaluate() {
    return val;
  }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
  private boolean isAnOperator(String s) {
    try {
      Integer.parseInt(s);
      return false;
    } catch (NumberFormatException e) {
      return true;
    }
  }

  Node buildTree(String[] postfix) {
    Stack<Node> nodes = new Stack<>();
    for (String s : postfix) {
      if (isAnOperator(s)) {
        Node right = nodes.pop();
        Node left = nodes.pop();
        nodes.push(new OperatorNode(s, left, right));
      } else {
        nodes.push(new NumberNode(s));
      }
    }
    return nodes.peek();
  }
}


