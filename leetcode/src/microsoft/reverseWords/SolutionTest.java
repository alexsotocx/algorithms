package microsoft.reverseWords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void reverseWords() {
    assertEquals("s'teL ekat edoCteeL tsetnoc", new Solution().reverseWords("Let's take LeetCode contest"));
    assertEquals("tsetnoc", new Solution().reverseWords("contest"));
    assertEquals(" tsetnoc ", new Solution().reverseWords(" contest "));
    assertEquals("   ", new Solution().reverseWords("   "));
  }
}
