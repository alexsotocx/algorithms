package microsoft.schuffe;

class Solution {
  public int[] shuffle(int[] nums, int n) {
    int p1 = 0;
    int p2 = n;
    int tmp1 = nums[0];
    while (p1 < n) {
      int t = nums[2 * p1 + 1];
      nums[2 * p1 + 1] = nums[p2];
      nums[2 * p1] = tmp1;

      tmp1 = t;
      p2++;
      p1++;
    }
    return nums;
  }
}
