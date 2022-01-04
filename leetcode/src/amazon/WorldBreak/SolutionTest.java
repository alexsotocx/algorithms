package amazon.WorldBreak;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @Test
  void wordBreak() {
    String s = "leetcode";
    ArrayList<String> w = new ArrayList<>();
    w.add("leet");
    w.add("code");
    assertTrue(new Solution().wordBreak(s, w));
  }
}
