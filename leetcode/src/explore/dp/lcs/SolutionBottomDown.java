package explore.dp.lcs;

class SolutionBottomDown {
  public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();
    int[][] memo = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        int s = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
        memo[i][j] = Math.max(s + memo[i - 1][j - 1], Math.max(memo[i - 1][j], memo[i][j - 1]));
      }
    }
    return memo[n][m];
  }
}
