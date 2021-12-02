package microsoft.needleStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void precalculatePreSuf() {
    String p = "aabaabaaa";
    assertArrayEquals(new int[]{0, 1, 0, 1,2,3,4,5, 2}, new Solution().precalculatePreSuf(p));
  }

  @Test
  void strStr() {
  }
}
