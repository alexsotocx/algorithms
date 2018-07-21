package chapter1;

public class Exercise1_5 {
  boolean isOneWay(String a, String b) {
    if (Math.abs(a.length() - b.length()) > 1) return false;
    if (a.length() == b.length()) return checkEqualityOrReplacement(a, b);
    if (a.length() > b.length()) return checkInsertion(a, b);
    return checkInsertion(b, a);
  }

  private boolean checkEqualityOrReplacement(String s1, String s2) {
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) diff++;
    }
    return diff <= 1;
  }

  private boolean checkInsertion(String s1, String s2) {
    int diff = 0;
    int i = 0, j = 0;
    while (i < s1.length() && j < s2.length()) {
      if (s1.charAt(i) == s2.charAt(j)) {
        i++;
        j++;
      } else {
        i++;
        diff++;
      }
    }
    return diff <= 1;
  }
}
