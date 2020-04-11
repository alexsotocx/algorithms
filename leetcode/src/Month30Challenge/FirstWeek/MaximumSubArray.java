package Month30Challenge.FirstWeek;

public class MaximumSubArray {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int i = 0;
    while (i < nums.length) {
      int sum = 0;
      while (sum >= 0 && i < nums.length) {
        sum += nums[i++];
        max = Integer.max(max, sum);
      }
    }
    return max;
  }
}
