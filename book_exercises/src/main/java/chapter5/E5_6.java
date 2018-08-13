package chapter5;

public class E5_6 {
  int minConversion(int a, int b) {
    return countSetBits(a ^ b);
  }

  private int countSetBits(int x) {
    int count = 0;
    while (x != 0) {
      count += x & 1;
      x >>= 1;
    }
    return count;
  }
}
