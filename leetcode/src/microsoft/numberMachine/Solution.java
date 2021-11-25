package microsoft.numberMachine;

// you can also use imports, for example:

import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class InvalidNumberException extends Exception {
  int num;

  InvalidNumberException(int num) {
    super();
    this.num = num;

  }

  public String getMessage() {
    return "Number " + num + " not between valid ranges";
  }
}

class NotFilledStackException extends Exception {
  String op;
  int currentSize;
  int expectedSize;

  NotFilledStackException(String op, int currentSize, int exceptedSize) {
    super();
    this.op = op;
    this.currentSize = currentSize;
    this.expectedSize = exceptedSize;
  }

  public String getMessage() {
    return "Stack not filled enough for operation " + op + ", current Size " + currentSize + " Expected size " + expectedSize;
  }
}

class Solution {
  private Stack<Integer> stack;
  final int LOWER_LIMIT = 0;
  final int UPPER_LIMIT = (1 << 20) - 1;


  private boolean isNumber(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private void handleNumber(int num) throws InvalidNumberException {
    if (num >= LOWER_LIMIT && num <= UPPER_LIMIT) {
      stack.push(num);
    } else {
      throw new InvalidNumberException(num);
    }
  }

  private void handlePlus() throws NotFilledStackException, InvalidNumberException {
    if (stack.size() < 2) throw new NotFilledStackException("+", stack.size(), 2);
    int right = stack.pop();
    int left = stack.pop();
    this.handleNumber(right + left);
    System.out.println("PLUS " + right + " + " + left);
  }

  private void handleMinus() throws NotFilledStackException, InvalidNumberException {
    if (stack.size() < 2) throw new NotFilledStackException("-", stack.size(), 2);
    int right = stack.pop();
    int left = stack.pop();
    this.handleNumber(right - left);
  }

  private void handlePop() throws NotFilledStackException {
    if (stack.isEmpty()) throw new NotFilledStackException("POP", stack.size(), 1);
    stack.pop();
  }

  private void handleDup() throws NotFilledStackException, InvalidNumberException {
    if (stack.isEmpty()) throw new NotFilledStackException("DUP", stack.size(), 1);
    this.handleNumber(stack.peek());
  }

  public int solution(String S) {
    try {
      stack = new Stack<>();
      String[] operands = S.split(" ");
      for (String op : operands) {
        if (isNumber(op)) {
          this.handleNumber(Integer.parseInt(op));
        } else {
          if (op.equals("+")) {
            this.handlePlus();
          } else if (op.equals("-")) {
            this.handleMinus();
          } else if (op.equals("DUP")) {
            this.handleDup();
          } else if (op.equals("POP")) {
            this.handlePop();
          }
        }
      }
      return stack.peek();
    } catch (Exception e) {
      return -1;
    }

  }
}
