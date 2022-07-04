package StudyPlan.med;

class Solution {
  public boolean isMonotonic(int[] nums) {
    boolean increasing = true;
    boolean decreasing = true;
    for (int i = 0 ;i < nums.length - 1 && (increasing || decreasing); i++) {
      decreasing =  decreasing  && nums[i] >= nums[i+1];
      increasing =  increasing  && nums[i] <= nums[i+1];
    }
    return increasing || decreasing;
  }
}
