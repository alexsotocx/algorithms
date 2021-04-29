package easy;

public class RemoveDuplicatedInSortedArray {
  public int removeDuplicates(int[] nums) {
    int nonDuplicated = 0;
    for (int i = 0; i < nums.length; ) {
      int num = nums[i];
      nums[nonDuplicated++] = num;
      while (i < nums.length && nums[i] == num) i++;
    }
    return nonDuplicated;
  }
}
