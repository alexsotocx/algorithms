import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ThreePlusOne {
  private static HashMap<Long, Integer> memo = new HashMap<>();

  private static int calculate(long start) {
    if (memo.containsKey(start)) return memo.get(start);
    Queue<Long> s = new LinkedList<>();
    s.offer(start);
    int a;
    long n = start;
    while (true) {
      if (memo.containsKey(n)){
        a = memo.get(n);
        break;
      }
      if (n % 2 == 0) n /= 2;
      else n = 3 * n + 1;
      s.offer(n);
    }
    while (!s.isEmpty()) {
      int size = s.size();
      n = s.poll();
      memo.put(n, size - 1 + a);
    }
    return memo.get(start);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s;
    memo.put(1L, 1);
    StringBuilder out = new StringBuilder();
    while ((s=br.readLine())!=null) {
      StringTokenizer st=new StringTokenizer(s);
        int low = Integer.parseInt(st.nextToken());
        int hi = Integer.parseInt(st.nextToken());
        int ti = Math.min(low, hi);
        int tj = Math.max(low, hi);
        int max = Integer.MIN_VALUE;
        for (int i = ti; i <= tj; i++) {
          max = Math.max(max, calculate(i));
        }

      out.append(low).append(' ').append(hi).append(' ').append(max).append('\n');
      }
    System.out.print(out);
  }

}