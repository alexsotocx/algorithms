import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DivisionNLogonia {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k, n,m;
    StringBuilder out = new StringBuilder();
    while((k = Integer.parseInt(br.readLine())) != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      while(k-- > 0) {
        int x, y;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        if(x == n || y == m)  out.append("divisa\n");
        else if(x > n && y > m) out.append("NE\n");
        else if(x < n && y > m) out.append("NO\n");
        else if(x < n && y < m) out.append("SO\n");
        else if(x > n && y < m) out.append("SE\n");
      }
    }
    System.out.print(out);
  }
}