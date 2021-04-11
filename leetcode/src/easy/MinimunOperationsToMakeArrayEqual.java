package easy;

public class MinimunOperationsToMakeArrayEqual {
  public int minOperations(int n) {
    if ((n % 2) == 0) {
      return (int) Math.pow((n - 2) / 2, 2) + n - 1;
    } else {
      int x = n / 2;
      return x * x + x;
    }
  }
}
