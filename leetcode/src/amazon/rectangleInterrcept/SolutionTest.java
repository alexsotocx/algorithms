package amazon.rectangleInterrcept;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @Test
  void isRectangleOverlap() {
    int[] rec1 = new int[]{0, 0, 2, 2};
    int[] rec2 = new int[]{1, 1, 3, 3};

    assertTrue(new Solution().isRectangleOverlap(rec1, rec2));
  }
}
