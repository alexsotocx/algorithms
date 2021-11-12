package amazon.earliestAcq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void earliestAcq() {
    int[][] in = new int[][]{
      {0, 2, 0},{7, 4, 3},{2, 2, 1},{1, 0, 1},{5, 4, 1},{6, 3, 2},{8, 3, 1},{3, 0, 4},
    };
    assertEquals(new Solution().earliestAcq(in, 5), 6);
  }
}
