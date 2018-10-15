package InterviewPrepartionKit.Graphs;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the quickestWayUp function below.
  static int quickestWayUp(int[] ladders, int[] snakes) {
    Queue<Integer> next = new LinkedList<>();
    next.add(1);
    int[] distance = new int[101];
    Arrays.fill(distance, -1);
    distance[1] = 0;
    while(!next.isEmpty()) {
      int nextN = next.poll();

      if(ladders[nextN] != -1) {
        distance[ladders[nextN]] = distance[nextN];
        next.add(ladders[nextN]);
        continue;
      }

      if(snakes[nextN] != -1) {
        distance[snakes[nextN]] = distance[nextN];
        next.add(snakes[nextN]);
        continue;
      }
      if(nextN == 100) break;
      for(int i = 1; i <= 6; i++) {
        int v = nextN + i;
        if(v <= 100 && distance[v] == -1) {
          distance[v] = distance[nextN] + 1;
          next.add(v);
        }
      }
    }
    return distance[100];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] ladders = new int[101];
      Arrays.fill(ladders, -1);

      for (int i = 0; i < n; i++) {
        ladders[scanner.nextInt()] = scanner.nextInt();
      }

      int m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] snakes = new int[101];
      Arrays.fill(snakes, -1);

      for (int i = 0; i < m; i++) {
        snakes[scanner.nextInt()] = scanner.nextInt();
      }

      int result = quickestWayUp(ladders, snakes);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
