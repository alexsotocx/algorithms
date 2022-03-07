package Month30Challenge.march.firstweek.arithmeticslices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void numberOfArithmeticSlices() {
    assertEquals(4, new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4,8,12}));
  }
}
