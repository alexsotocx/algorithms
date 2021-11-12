package amazon.reverse2k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void reverseStr() {
    String x = "abcdefg";
    assertEquals(new Solution().reverseStr(x, 8), "gfedcba");
  }
}
