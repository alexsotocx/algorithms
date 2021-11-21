package amazon.NumOfTeams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void numTeams() {
    assertEquals(3, new Solution().numTeams(new int[]{2, 5, 3, 4, 1}));
  }
}
