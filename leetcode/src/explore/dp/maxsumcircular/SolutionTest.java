package explore.dp.maxsumcircular;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void maxSubarraySumCircular() {
//    assertEquals(3, new Solution().maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    assertEquals(10, new Solution().maxSubarraySumCircular(new int[]{5,-3,5}));
//    assertEquals(-2, new Solution().maxSubarraySumCircular(new int[]{-3,-2,-3}));
//    assertEquals(3, new Solution().maxSubarraySumCircular(new int[]{1, 1, 1}));
//    assertEquals(1, new Solution().maxSubarraySumCircular(new int[]{1}));
  }
}
