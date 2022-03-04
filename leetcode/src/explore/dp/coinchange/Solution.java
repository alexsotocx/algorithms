package explore.dp.coinchange;

import java.util.Arrays;

class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;
    Arrays.sort(coins);
    int[] dp = new int[amount + 1];
    dp[0] = 0;

    for(int i = 1 ; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
      for(int j = 0 ; j < coins.length && coins[j] <= i; j++) {
        if (dp[i - coins[j]] == Integer.MAX_VALUE) continue;
        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}

