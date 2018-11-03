package ProblemSolving.Implementation;

public class ClimbingTheLeaderboard {
  static int lowerBound(int[] arr, int x) {
    int lo = 0, hi = arr.length - 1;
    while(lo < hi) {
      int mid = (lo + hi)/2;
      if(x < arr[mid]) hi = mid;
      else lo = mid + 1;
    }
    return hi;
  }

  // Complete the climbingLeaderboard function below.
  static int[] climbingLeaderboard(int[] scores, int[] alice) {
    int[] ranks = new int[scores.length];
    int rank = 1;
    int lastScore = scores[0];
    int[] reversedScores = new int[scores.length];
    for(int i = 0; i < scores.length; i++) {
      int sc = scores[i];
      if(sc != lastScore) rank++;
      lastScore = sc;
      ranks[scores.length - 1  - i] = rank;
      reversedScores[scores.length - 1  - i] = scores[i];
    }
    int[] ret = new int[alice.length];
    for(int i = 0; i < alice.length; i++) {
      int p = lowerBound(reversedScores, alice[i]);
      int s = reversedScores[p];
      if(alice[i] >= s) ret[i] = ranks[p];
      else ret[i] = ranks[p] + 1;
    }
    return ret;
  }
}
