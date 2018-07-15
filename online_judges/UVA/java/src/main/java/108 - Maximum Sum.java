import java.util.Scanner;

class MaximumSum108 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int[][] m = new int[n][n];
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          m[i][j] = sc.nextInt();
          if (i - 1 >= 0) m[i][j] += m[i - 1][j];
          if (j - 1 >= 0) m[i][j] += m[i][j - 1];
          if (i - 1 >= 0 && j - 1 >= 0) m[i][j] -= m[i - 1][j - 1];
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int k = i; k < n; k++) {
            for (int l = j; l < n; l++) {
              int subRect = m[k][l];
              if (i > 0) subRect -= m[i - 1][l];
              if (j > 0) subRect -= m[k][j - 1];
              if (i > 0 && j > 0) subRect += m[i - 1][j - 1];
              max = Math.max(max, subRect);
            }
          }
        }
      }


      System.out.println(max);
    }
  }
}