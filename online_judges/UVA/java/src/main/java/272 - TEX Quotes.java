import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TexQuotes272 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringBuilder out = new StringBuilder();
    boolean left = true;
    while ((line = br.readLine()) != null) {
      String[] split = line.split("((?<=\")|(?=\"))", -1);
      for (String s : split) {
        if (s.equals("")) continue;
        if (s.equals("\"")) {
          if (left) {
            left = false;
            out.append("``");
          } else {
            out.append("''");
            left = true;
          }
        } else {
          out.append(s);
        }
      }
      out.append('\n');
    }

    System.out.print(out);
  }
}