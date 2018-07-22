package chapter1;

public class Exercise1_7 {
  int[][] transpose(int[][] mat, int m, int n) {
    int[][] mprima = new int[n][];
    for (int i = 0; i < n; i++) mprima[i] = new int[m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < m; j++) {
        mprima[n - i - 1][j] = mat[m - j - 1][n - i - 1];
      }
    }
    return mprima;
  }
}
