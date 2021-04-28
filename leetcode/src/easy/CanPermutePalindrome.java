package easy;

public class CanPermutePalindrome {
  public boolean canPermutePalindrome(String s) {
    int x = 0;
    for(char c: s.toCharArray()) {
      int pos = 1 << (c - 'a');
      x ^= pos;
    }
    return x == 0 || (x & (x - 1)) == 0;
  }
}
