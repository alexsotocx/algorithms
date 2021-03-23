package Month30Challenge.FirstWeek;

public class MoveZeroes {
  private int[] nums;

  public void moveZeroes(int[] nums) {
    this.nums = nums;
    moveZeroes(0, nums.length - 1);
  }

  private int moveZeroes(int lo, int hi) {
    if (lo == hi) return nums[lo] == 0 ? 1 : 0;
    int mid = (lo + hi) / 2;
    int lowZeros = moveZeroes(lo, mid);
    int upZeros = moveZeroes(mid + 1, hi);
    if (lowZeros > 0) {
      for (int i = mid + 1; i <= hi - upZeros; i++) {
        swap(i - lowZeros, i);
      }
    }
    return lowZeros + upZeros;
  }

  private void swap(int i, int j) {
    int k = nums[i];
    nums[i] = nums[j];
    nums[j] = k;
  }
}


