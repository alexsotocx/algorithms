package amazon.longestSub;

import java.util.Arrays;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) return 0;

    int max = 1;
    int start = 0;
    int[] h = new int[257];
    Arrays.fill(h, Integer.MIN_VALUE);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int last = h[c];
      if (last >= start) {
        max = Math.max(max, i - start);
        start = last + 1;
      }
      h[c] = i;
    }
    max = Math.max(max, s.length() - start);
    return max;
  }
}
