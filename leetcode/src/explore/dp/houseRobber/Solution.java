package explore.dp.houseRobber;

class Solution {
  public int rob(int[] nums) {
    int[] max = new int[nums.length];
    max[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (i < 2){
        max[i] = Math.max(nums[i], nums[i - 1]);
      } else {
        max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
      }
    }
    return max[nums.length - 1];
  }
}
