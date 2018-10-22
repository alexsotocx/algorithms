package ProblemSolving.Recursion;

import java.util.HashMap;

public class DividingStones2 {
  static HashMap<Long, Long> memo;
  // Complete the stoneDivision function below.
  static long stoneDivision(long n, long[] s) {
    memo = new HashMap<>();
    helperStone(n, s);
    return memo.get(n);
  }

  static long helperStone(long n, long[] s) {
    if(memo.containsKey(n)) return memo.get(n);
    long maxx = 0;
    for(long x: s) {
      if(n % x == 0 && x != n) {
        maxx = Math.max(maxx, 1 + n/x * helperStone(x, s));
      }
    }

    memo.put(n, maxx);
    return maxx;
  }
}
