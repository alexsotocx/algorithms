package stacks.medium;

import java.util.Stack;

public class MatchingBrackets {
  public static boolean balancedBrackets(String str) {
    Stack<Character> st = new Stack<>();
    for(char c: str.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') st.add(c);
      else if (c == ')') {
        if (st.isEmpty() || st.pop() != '(') return false;
      }
      else if (c == ']') {
        if (st.isEmpty() || st.pop() != '[') return false;
      }
      else if (c == '}') {
        if (st.isEmpty() || st.pop() != '{') return false;
      }
    }
    return st.isEmpty();
  }
}
