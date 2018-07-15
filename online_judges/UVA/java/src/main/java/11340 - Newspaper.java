import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Newspaper11340 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      HashMap<Character, Integer> dicVal = new HashMap<>();
      int k = Integer.parseInt(br.readLine());
      while (k-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        char c = st.nextToken().charAt(0);
        int v = Integer.parseInt(st.nextToken());
        dicVal.put(c, v);
      }
      k = Integer.parseInt(br.readLine());
      long sum = 0;
      while (k-- > 0) {
        for (char c : br.readLine().toCharArray()) {
          sum += dicVal.getOrDefault(c, 0);
        }
      }
      System.out.printf("%.2f$\n", (sum * 1.0) / (100.0));
    }
  }
}