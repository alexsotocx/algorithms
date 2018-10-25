package ProblemSolving.Recursion;

import java.util.*;

public class KFactorization {

  static ArrayList<ArrayList<Long>> solutions = new ArrayList<>();

  static void solve(long n, long[] factors, ArrayList<Long> currentSol) {
    if(n == 1) {
      solutions.add(new ArrayList<>(currentSol));
    } else {
      for(long factor: factors) {
        if(n % factor == 0) {
          currentSol.add(factor);
          solve(n / factor, factors, currentSol);
          currentSol.remove(currentSol.size() - 1);
        }
      }
    }
  }

  static public void main( String args[] ) {
    solve(64, new long[]{2, 4, 8, 16}, new ArrayList<Long>());
    int minSize = 1 << 30;
    int minPos = 0;
    for(int i = 0; i < solutions.size();i++) {
      if(minSize > solutions.get(i).size()) {
        minSize = solutions.get(i).size();
        minPos = i;
      }
    }
    long c = 1;
    System.out.println(c);
    for(long f : solutions.get(minPos)) {
      c *= f;
      System.out.println(c);

    }
    System.out.println( "Practice makes Perfect!" );
  }
}


/*
12 3
2 3 4

(a) 1  ->  2  ->  4  ->  12
       x2     x2     x3

(b) 1  ->  4  ->  12
       x4     x3

(c) 1  ->  3  ->  12
       x3     x4   22

1 3 12

12



*/
