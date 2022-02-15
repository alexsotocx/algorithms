package explore.dp.maximumScore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void maximumScore() {
    int[] nums = new int[] {1,2,3};
    int[] muls =  new int[]{3,2,1};
    assertEquals(14, new Solution().maximumScore(nums, muls));
  }
}
