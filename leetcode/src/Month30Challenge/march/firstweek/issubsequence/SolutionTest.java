package Month30Challenge.march.firstweek.issubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void isSubsequence() {
    assertFalse(new Solution().isSubsequence("aaa", "aa"));
  }
}
