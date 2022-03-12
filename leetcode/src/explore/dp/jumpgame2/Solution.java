package explore.dp.jumpgame2;

import java.util.Arrays;

class Solution {
  public int jump(int[] nums) {
    int max = nums[0];
    int[] minSteps= new int[nums.length];
    Arrays.fill(minSteps, Integer.MAX_VALUE);
    minSteps[0] = 0;

    for(int i = 0; i < nums.length; i++) {
      for (int j = 1; j <= nums[i] && j + i < nums.length; j++) {
        if (minSteps[j+i] <= minSteps[i] + 1) continue;
        minSteps[j+i] = minSteps[i] + 1;
      }
    }
    return minSteps[nums.length - 1];
  }
}
