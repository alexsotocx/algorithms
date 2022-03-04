package explore.dp.coinchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void coinChange() {
    int[] coins = new int[]{1, 2, 5};
    assertEquals(3, new Solution().coinChange(coins, 11));
  }
}
