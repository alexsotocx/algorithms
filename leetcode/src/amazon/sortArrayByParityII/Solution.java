package amazon.sortArrayByParityII;

class Solution {
  private void swap(int i, int j, int[] nums) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  public int[] sortArrayByParityII(int[] nums) {
    int i = 1;
    int j = nums.length - 1;
    while (i < j) {
      if ((nums[i] % 2) == (nums[0] % 2)) i++;
      else {
        swap(i, j, nums);
        j--;
      }
    }
    for (i = nums[0] % 2 == 1 ? 0 : 1; i < nums.length / 2; i += 2) {
      swap(i, nums.length - 1 - i, nums);
    }

    return nums;
  }
}
