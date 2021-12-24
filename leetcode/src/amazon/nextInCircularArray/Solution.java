package amazon.nextInCircularArray;

import java.util.Stack;

class Solution {
  private void greater(int[] nums, Stack<Integer> st, int[] res) {
    int n = nums.length;
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && st.peek() <= nums[i]) st.pop();
      if (st.isEmpty()) res[i] = -1;
      else res[i] = st.peek();
      st.push(nums[i]);
    }
  }

  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> st = new Stack<>();
    int n = nums.length;
    final int[] res = new int[n];
    greater(nums, st, res);
    // Second time
    greater(nums, st, res);

    return res;
  }
}
