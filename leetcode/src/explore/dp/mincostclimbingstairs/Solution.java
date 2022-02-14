package explore.dp.mincostclimbingstairs;

class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int[] totalCost = new int[cost.length + 1];
    for(int i = 2; i < cost.length + 1; i++) {
      totalCost[i] = Math.min(totalCost[i - 1] + cost[i - 1], totalCost[i - 2] +  cost[i - 2]);
    }
    return totalCost[cost.length];
  }
}
