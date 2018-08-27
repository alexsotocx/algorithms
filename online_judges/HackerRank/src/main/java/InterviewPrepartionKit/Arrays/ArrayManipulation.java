package InterviewPrepartionKit.Arrays;

public class ArrayManipulation {
  long arrayManipulation(int n, int[][] queries) {
    long max = Integer.MIN_VALUE;
    long[] arr = new long[n + 2];
    for (int[] q : queries) {
      arr[q[0]] += q[2];
      arr[q[1] + 1] -= q[2];
    }
    for (int i = 1; i < n + 2; i++)
      max = Math.max(max, arr[i] += arr[i - 1]);
    return max;
  }
}
