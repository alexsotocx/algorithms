package explore.dp.maximum1square;

class Solution {
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    int max = 0;
    for (int i = 0; i < m; i++) dp[0][i] = matrix[0][i] == '1' ? max = 1 : 0;
    for (int i = 0; i < n; i++) dp[i][0] = matrix[i][0] == '1' ? max = 1 : 0;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == '0') continue;
        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
        max = Math.max(max, dp[i][j]);
      }
    }
    return max*max;
  }
}
