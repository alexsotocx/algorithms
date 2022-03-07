package Month30Challenge.march.firstweek.arithmeticslices;

class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int total = 0;
    for (int i = 0; i <= nums.length - 3; ) {
      int diff = nums[i + 1] - nums[i];
      int l = 2;
      for (int j = i + 2; j < nums.length && nums[j] - nums[j - 1] == diff; j++) l++;
      if (l < 3) i++;
      else {
        i += l - 1;
        l -= 2;
        total += (l * (l + 1)) / 2;
      }
    }
    return total;
  }
}
