package ProblemSolving.DP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DownToZero {
  static int[] sols = new int[1000000 + 5];

  static void precalculate() {
    sols[0] = 0;
    sols[1] = 1;
    for (int i = 2; i <= 1000000; i++) {
      int minSol = sols[i - 1];
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0) minSol = Math.min(minSol, sols[Math.max(j, i / j)]);
      }
      sols[i] = minSol + 1;
    }
  }


  static int downToZero(int n) {
    return sols[n];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    precalculate();
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(scanner.nextLine().trim());

    for (int qItr = 0; qItr < q; qItr++) {
      int n = Integer.parseInt(scanner.nextLine().trim());

      int result = downToZero(n);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
  }
}
