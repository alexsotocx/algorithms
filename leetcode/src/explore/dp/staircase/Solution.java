package explore.dp.staircase;

class Solution {
  public int climbStairs(int n) {
    int[] ways = new int[n + 1];
    ways[0] = 1;
    int[] steps = new int[]{1, 2};
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < steps.length && i  - steps[j] >= 0; j++) {
        ways[i] += ways[i - steps[j]];
      }
    }
    return ways[n];
  }
}
