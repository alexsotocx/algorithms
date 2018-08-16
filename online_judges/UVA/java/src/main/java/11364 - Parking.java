import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Parking {
  public static void main(String args[]) throws IOException {
    int c, n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    c = Integer.parseInt(br.readLine());

    while(c-- > 0) {
      n = Integer.parseInt(br.readLine());
      int pos[] = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int i = 0;
      while(st.hasMoreTokens()) {
        pos[i++] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(pos);
      int dis = pos[n-1] - pos[0];
      for(i = 1; i < n; i++) dis += pos[i] - pos[i - 1];
      System.out.println(dis);
    }
  }
}