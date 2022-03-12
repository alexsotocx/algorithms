package explore.dp.jumpGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void canJump() {
    int[] nums = new int[]{2,3,1,1,4};
    assertTrue(new Solution().canJump(nums));
  }
}
