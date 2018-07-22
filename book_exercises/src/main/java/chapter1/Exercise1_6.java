package chapter1;

public class Exercise1_6 {
  String compress(String s) {
    int i = 0, n = s.length();
    StringBuilder st = new StringBuilder();
    while (i < n) {
      char temp = s.charAt(i);
      int c = 0;
      while (i < n && temp == s.charAt(i)) {
        c++;
        i++;
      }
      st.append(temp).append(c);
    }
    String compressedString = st.toString();
    if (s.length() <= compressedString.length()) return s;
    return compressedString;
  }
}
