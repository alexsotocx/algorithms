package explore.dp.maxmulsub;

class Solution {
  public int maxProduct(int[] nums) {
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int result = nums[0];

    for(int i = 1; i< nums.length; i++) {
      if(nums[i] == 0) {
        minSoFar = 1;
        maxSoFar = 1;
        result = Math.max(result, 0);
        continue;
      }
      int temp = maxSoFar;
      maxSoFar = Math.max(temp * nums[i], Math.max(nums[i], minSoFar * nums[i]));
      minSoFar = Math.min(temp * nums[i], Math.min(nums[i], minSoFar * nums[i]));
      result = Math.max(result, Math.max(maxSoFar, minSoFar));
    }

    return result;
  }
}
