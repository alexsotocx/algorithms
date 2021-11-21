package amazon.NumOfTeams;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void numTeams() {
    assertEquals(3, new Solution().numTeams(new int[]{2,5,3,4,1}));
  }
}
