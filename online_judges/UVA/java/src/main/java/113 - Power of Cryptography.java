import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PowerOfCryptography113 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1, s2;
    while ((s1 = br.readLine()) != null && (s2 = br.readLine()) != null) {
      double n = Double.parseDouble(s1);
      double p = Double.parseDouble(s2);
      double logk = (1.0D / n) * Math.log(p);
      System.out.println(Math.round(Math.exp(logk)));
    }
  }
}