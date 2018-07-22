package chapter1;

public class Exercise1_7 {
  int[][] transpose(int[][] mat, int m, int n) {
    int[][] mprima = new int[n][];
    for (int i = 0; i < n; i++) mprima[i] = new int[m];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        mprima[i][j] = mat[m - j - 1][i];
      }
    }
    return mprima;
  }
}
