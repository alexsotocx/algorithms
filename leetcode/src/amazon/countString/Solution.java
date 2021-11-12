package amazon.countString;

import java.util.stream.IntStream;

class Solution {
  private int[] countChars(String s) {
    int[] countC = new int[26];
    for (char c : s.toCharArray())
      countC[c - 'a']++;
    return countC;
  }

  public int countCharacters(String[] words, String chars) {
    int[] countC = this.countChars(chars);
    int res = 0;
    for (String s : words) {
      int[] countS = this.countChars(s);
      if (IntStream.range(0, 26).allMatch((i) -> countS[i] <= countC[i])) {
        res += s.length();
      }
    }
    return res;
  }
}
