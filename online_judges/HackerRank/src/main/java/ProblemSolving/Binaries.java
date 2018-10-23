package ProblemSolving;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class xD {
  static class Rets {
    static char a,b;
    static byte c;

    Rets(char a, char b, byte c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }
  static Rets calculate(byte i, byte j, byte k) {
    byte ret = 0;
    for(byte x = 8; x > 0; x >>= 1){
      if((k & x) != 0 && ((i & x) == 0 && (j & x) == 0)){
        ret++;
        j |= x;
        continue;
      }
      if((k & x) == 0 && ((i & x) != 0 || (j & x) != 0)){
        if((i & x) != 0) {
          i &= ~x;
          ret++;
        }
        if((j & x) != 0) {
          j &= ~x;
          ret++;
        }
        continue;
      }
    }
    return new Rets(dectohex(i), dectohex(j), ret);
  }

  static byte hextodec(char x) {
    if(x <= '9') return (byte)(x - '0');
    return (byte)(x - 'A'  + 10);
  }

  static char dectohex(byte x) {
    if(x <= 9) return (char)('0' + x);
    return (char)('A' + x - 10);
  }
  /*
   * Complete the aOrB function below.
   */

  static byte getPos(String x, int pos, int max) {
    if(x.length() >= (max - pos)) return hextodec(x.charAt(x.length() -  (max - pos)));
    return 0;
  }

  static void aOrB(int k, String a, String b, String c) {
    int max = Math.max(a.length(), Math.max(b.length(), c.length()));
    StringBuilder sa, sb;
    sa = new StringBuilder();
    sb = new StringBuilder();
    for(int i = 0; i < max  && k >= 0; i++) {
      Rets temp = calculate(getPos(a, i, max), getPos(b, i, max), getPos(c, i, max));
      sa.append(temp.a);
      sb.append(temp.b);
      k -= temp.c;
    }

    if(k < 0) System.out.println(-1);
    else {
      /*Use other bits to optimice with sa and sb*/
      System.out.println(sa.toString().replaceAll("^0+", ""));
      System.out.println(sb.toString().replaceAll("^0+", ""));
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int q = Integer.parseInt(scanner.nextLine().trim());

    for (int qItr = 0; qItr < q; qItr++) {
      int k = Integer.parseInt(scanner.nextLine().trim());

      String a = scanner.nextLine();

      String b = scanner.nextLine();

      String c = scanner.nextLine();

      aOrB(k, a, b, c);
    }
  }
}
