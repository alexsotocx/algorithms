package microsoft.needleStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void precalculatePreSuf() {

  }

  @Test
  void strStr() {
    assertEquals(2, new Solution().strStr("hello", "ll"));
    assertEquals(-1, new Solution().strStr("aaaaa", "bba"));
    assertEquals(12, new Solution().strStr("aaaaabbcbbcabba", "bba"));
    assertEquals(0, new Solution().strStr("", ""));
  }
}
