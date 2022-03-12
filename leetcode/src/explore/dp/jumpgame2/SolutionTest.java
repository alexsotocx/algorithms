package explore.dp.jumpgame2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void jump() {
    int[] nums = new int[]{2,3,1,1,4};
    assertEquals(2, new Solution().jump(nums));
  }
}
