package amazon.brackets;

import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') st.push(c);
      else {
        if (st.isEmpty()) return false;
        char top = st.pop();
        boolean closedParentesis = (top == '(' && c == ')');
        boolean closedSqBracket = (top == '[' && c == ']');
        boolean closedBracket = (top == '{' && c == '}');
        if (!(closedBracket || closedSqBracket || closedParentesis)) return false;
      }


    }
    return st.isEmpty();
  }
}
