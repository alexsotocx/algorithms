package explore.dp.houserober2;

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    int[] max = new int[nums.length];
    max[0] = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      if (i < 2){
        max[i] = Math.max(nums[i], nums[i - 1]);
      } else {
        max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
      }
    }

    int n = max[nums.length - 2];
    max[1] = nums[1];
    for (int i = 2; i < nums.length; i++) {
      if (i <= 2){
        max[i] = Math.max(nums[i], nums[i - 1]);
      } else {
        max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
      }
    }
    int m = max[nums.length - 1];
    return Math.max(n, m);
  }
}
