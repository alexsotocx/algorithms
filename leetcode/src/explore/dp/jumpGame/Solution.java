package explore.dp.jumpGame;

class Solution {
  public boolean canJump(int[] nums) {
    int max = nums[0];
    for(int i = 1; i < nums.length; i++) {
      if (i > max) return false;
      max = Math.max(i + nums[i], max);
    }
    return true;
  }
}
