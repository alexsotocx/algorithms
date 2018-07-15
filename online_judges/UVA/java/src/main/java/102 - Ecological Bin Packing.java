import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EcologicalBinPacking102 {
  static class Bin {
    public int green, white, brown;

    public Bin(int brown, int green, int white) {
      this.green = green;
      this.white = white;
      this.brown = brown;
    }
  }

  static class Solution {
    String id;
    int count;

    public Solution(String id, int count) {
      this.id = id;
      this.count = count;
    }

    Solution min(Solution o) {
      if (count < o.count) return this;
      if (count > o.count) return o;
      if (id.compareTo(o.id) < 0) return this;
      return o;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(line);
      Bin b1 = new Bin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      Bin b2 = new Bin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      Bin b3 = new Bin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      Solution[] solutions = new Solution[]{
          new Solution("BCG", (b2.brown + b3.brown) + (b1.white + b3.white) + (b1.green + b2.green)),
          new Solution("BGC", (b2.brown + b3.brown) + (b1.green + b3.green) + (b1.white + b2.white)),
          new Solution("CBG", (b2.white + b3.white) + (b1.brown + b3.brown) + (b1.green + b2.green)),
          new Solution("CGB", (b2.white + b3.white) + (b1.green + b3.green) + (b1.brown + b2.brown)),
          new Solution("GBC", (b2.green + b3.green) + (b1.brown + b3.brown) + (b1.white + b2.white)),
          new Solution("GCB", (b2.green + b3.green) + (b1.white + b3.white) + (b1.brown + b2.brown))
      };
      Solution min = solutions[0];
      for (Solution solution : solutions) {
        min = min.min(solution);
      }
      System.out.println(min.id + " " + min.count);
    }
  }
}