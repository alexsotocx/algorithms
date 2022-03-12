package explore.dp.jumpgame2;

import java.util.Arrays;

class Solution {
  public int jump(int[] nums) {
    int[] minSteps= new int[nums.length];
    Arrays.fill(minSteps, Integer.MAX_VALUE);
    minSteps[0] = 0;

    for(int i = 0; i < nums.length; i++) {
      for (int j = Math.min(nums.length - 1, i + nums[i]); j > i; j--) {
        if (minSteps[j] <= minSteps[i] + 1) break;
        minSteps[j] = minSteps[i] + 1;
      }
    }
    return minSteps[nums.length - 1];
  }
}
