package amazon.longestSub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void lengthOfLongestSubstring() {
    assertEquals(new Solution().lengthOfLongestSubstring("abcabcbb"), 3);
  }
}
