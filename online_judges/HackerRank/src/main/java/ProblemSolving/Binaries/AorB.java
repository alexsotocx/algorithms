package ProblemSolving.Binaries;
import java.util.*;

public class AorB {
  static class ReturnContainer {
    static char a,b;
    static int c;

    ReturnContainer(char a, char b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }
  static ReturnContainer calculate(byte a, byte b, byte c) {
    byte ret = 0;
    for(byte x = 8; x > 0; x >>= 1){
      if((c & x) != 0 && ((a & x) == 0 && (b & x) == 0)){
        ret++;
        b |= x;
        continue;
      }
      if((c & x) == 0 && ((a & x) != 0 || (b & x) != 0)){
        if((a & x) != 0) {
          a &= ~x;
          ret++;
        }
        if((b & x) != 0) {
          b &= ~x;
          ret++;
        }
      }
    }
    return new ReturnContainer(dectohex(a), dectohex(b), ret);
  }

  static ReturnContainer optimice(byte a, byte b, byte c, int k) {
    for(byte x = 8; x > 0 && k > 0; x >>= 1){
      if((c & x) != 0){
        if((a & x) != 0 && (b & x) != 0 && k >= 1) {
          k--;
          a &= ~x;
          continue;
        }
        if((a & x) != 0 && (b & x) == 0 && k >= 2) {
          k -= 2;
          a &= ~x;
          b |= x;
        }
      }
    }
    return new ReturnContainer(dectohex(a), dectohex(b), k);
  }

  static byte hextodec(char x) {
    if(x <= '9') return (byte)(x - '0');
    return (byte)(x - 'A'  + 10);
  }

  static char dectohex(int x) {
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
    char[] sa = new char[max];
    char[] sb = new char[max];
    for(int i = 0; i < max  && k >= 0; i++) {
      ReturnContainer temp = calculate(getPos(a, i, max), getPos(b, i, max), getPos(c, i, max));
      sa[i] = temp.a;
      sb[i] = temp.b;
      k -= temp.c;
    }

    if(k < 0) System.out.println(-1);
    else {
      for(int i = 0; i < max  && k > 0; i++) {
        ReturnContainer temp = optimice(hextodec(sa[i]), hextodec(sb[i]), getPos(c, i, max), k);
        sa[i] = temp.a;
        sb[i] = temp.b;
        k = temp.c;
      }
      String answerA = new String(sa).replaceAll("^0+", "");
      String answerB = new String(sb).replaceAll("^0+", "");
      if(answerA.isEmpty()) answerA = "0";
      if(answerB.isEmpty()) answerB = "0";
      System.out.println(answerA);
      System.out.println(answerB);
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
