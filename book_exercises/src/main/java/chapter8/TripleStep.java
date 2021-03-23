package chapter8;

public class TripleStep {
  long calculate(int n) {
    long[] waysToN = new long[n + 1];
    waysToN[0] = 1;
    waysToN[1] = 1;
    for (int i = 2; i <= n; i++) {
      waysToN[i] = waysToN[i - 1];
      if (i - 2 >= 0) waysToN[i] += waysToN[i - 2];
      if (i - 3 >= 0) waysToN[i] += waysToN[i - 3];
    }

    return waysToN[n];
  }
}
