package HackerRank.Arrays;

public class TwoDArrays {
  private static int[] di = new int[]{0, 0, 0, 1, 2, 2, 2};
  private static int[] dj = new int[]{0, 1, 2, 1, 1, 0, 2};

  private static int calculateHourglass(int i, int j, int[][] arr) {
    int sum = 0;
    for (int k = 0; k < di.length; k++) {
      int dy = di[k] + i;
      int dx = dj[k] + j;
      if (dy < 0 || dy >= 6 || dx < 0 || dx >= 6) return Integer.MIN_VALUE;
      sum += arr[dy][dx];
    }
    return sum;
  }

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++)
        maxSum = Math.max(calculateHourglass(i, j, arr), maxSum);
    }
    return maxSum;
  }
}
