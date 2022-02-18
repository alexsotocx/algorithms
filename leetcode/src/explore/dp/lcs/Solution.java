package explore.dp.lcs;

import java.util.Arrays;

class Solution {
  String a;
  String b;
  int[][] memo;

  private int topDown(int i, int j) {
    if (i < 0 || j < 0) return 0;
    if (memo[i][j] != -1) return memo[i][j];
    int sum = a.charAt(i) == b.charAt(j) ? 1 : 0;
    memo[i][j] = Math.max(sum + topDown(i - 1, j - 1), Math.max(topDown(i - 1, j), topDown(i, j - 1)));
    return memo[i][j];
  }

  public int longestCommonSubsequence(String text1, String text2) {
    a = text1;
    b = text2;
    memo = new int[a.length()][b.length()];
    for(int i  = 0; i< a.length();i++) Arrays.fill(memo[i], -1);
    return topDown(a.length() - 1, b.length() - 1);
  }

}
