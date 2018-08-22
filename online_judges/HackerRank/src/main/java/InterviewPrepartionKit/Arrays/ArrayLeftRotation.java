package InterviewPrepartionKit.Arrays;

public class ArrayLeftRotation {

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int k = a.length - d, n = a.length;
    int[] ret = new int[n];
    for (int i = 0; i < n; i++)
      ret[(i + k) % n] = a[i];
    return ret;
  }
}

