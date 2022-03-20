package explore.dp.maxsubarraysum;

class Solution {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int currentSum = nums[0];
    for(int i = 1; i< nums.length; i++) {
      if (currentSum < 0) currentSum = 0;
      currentSum += nums[i];
      max = Math.max(max, currentSum);
    }
    return max;
  }
}
