package explore.dp.fib;

class Solution {
  public int fib(int n) {
    if (n == 1) return 1;
    if (n == 0) return 0;
    int a = 0;
    int b = 1;
    int t = b;

    for (int i = 2; i <= n; i++) {
      t = b;
      b = a + b;
      a = t;
    }
    return b;
  }
}
