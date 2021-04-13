package easy;

public class SquaresOfASortedArray {
  public int[] sortedSquares(int[] nums) {
    int[] squares = new int[nums.length];
    int i = 0, j = nums.length - 1, k = nums.length - 1;
    while (i != j) {
      int x = Math.abs(nums[i]);
      int y = Math.abs(nums[j]);
      if (x > y) {
        i++;
        squares[k] = x * x;
      } else {
        squares[k] = y * y;
        j--;
      }
      k--;
    }
    squares[k] = nums[i] * nums[i];
    return squares;
  }
}
