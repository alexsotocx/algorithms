package microsoft.needleStack;

class Solution {

  public int[] precalculatePreSuf(String s) {
    int[] b = new int[s.length()];
    int i = 1, j = 0;
    b[0] = 0;
    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(j)) {
        b[i++] = ++j;
      } else {
        j--;
        if (j < 0) {
          b[i] = 0;
          j = 0;
          i++;
        } else {
          j = b[j];
        }
      }

    }
    return b;
  }

  public int kmp(String target, String pattern) {
    int[] pre = this.precalculatePreSuf(pattern);
    int i = 0;
    int j = 0;
    while (i < target.length()) {
      if (target.charAt(i) == pattern.charAt(j)) {
        j++;
        i++;
        if (j == pattern.length()) {
          return i - j;
        }
      } else {
        j--;
        if (j < 0) {
          j = 0;
          i++;
        } else {
          j = pre[j];
        }
      }
    }
    return -1;
  }

  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    return kmp(haystack, needle);
  }
}
