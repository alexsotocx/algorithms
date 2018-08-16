import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class LoanSomeCarBuyer {
  public static class Depreciation {
    double val;
    int month;

    public Depreciation(int month, double val) {
      this.val = val;
      this.month = month;
    }

    public String toString() {
      return "Month " + month + " val = " + val;
    }
  }

  public static void main(String args[]) throws IOException {
    int m, n;
    double dP, p;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      if (m < 0) break;
      dP = Double.parseDouble(st.nextToken());
      p = Double.parseDouble(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      Depreciation[] dep = new Depreciation[n];
      int i = 0;
      while (n-- > 0) {
        st = new StringTokenizer(br.readLine());
        dep[i++] = new Depreciation(Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken()));
      }

      double depVal = (p + dP) * (1 - dep[0].val);
      double mPayment = p / m;
      int month = 0;
      int j = 0;
      Depreciation current = dep[0];
      while (Double.compare(p, depVal) >= 1 && month <= m) {
        month++;
        if (j + 1 < dep.length && dep[j+1].month == month) current = dep[++j];
        depVal -= depVal * current.val;
        p -= mPayment;
      }
      if (month == 1)
        System.out.println("1 month");
      else
        System.out.println(month + " months");
    }
  }
}
