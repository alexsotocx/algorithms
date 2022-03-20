package explore.dp.maxsumcircular;

class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    int max = nums[0];
    int currentSum = nums[0];
    int n = nums.length;
    int started = 0;
    for(int i = 1; i< n * 2; i++) {
      int next = i % n;
      if (next == started) break;
      if (currentSum < 0) {
        currentSum = 0;
        started = i;
      }
      currentSum += nums[next];
      max = Math.max(max, currentSum);
    }
    return max;
  }
}
