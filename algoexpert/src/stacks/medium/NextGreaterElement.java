package stacks.medium;

import java.util.*;

public class NextGreaterElement {
  public int[] nextGreaterElement(int[] array) {
    Stack<Integer> st = new Stack<>();
    int[] res = new int[array.length];
    Arrays.fill(res, -1);

    for(int i = array.length - 1; i >= 0; i--) {
      while(!st.isEmpty() && st.peek() <= array[i]) st.pop();
      res[i] = st.isEmpty() ?  -1 : st.peek();
      st.add(array[i]);
    }

    for(int i = array.length - 1; i >= 0; i--) {
      while(!st.isEmpty() && st.peek() <= array[i]) st.pop();
      res[i] = st.isEmpty() ?  -1 : st.peek();
      st.add(array[i]);
    }

    return res;
  }
}
