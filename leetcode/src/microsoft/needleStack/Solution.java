package microsoft.needleStack;

class Solution {

  public int[] precalculatePreSuf(String s) {
    int[] b = new int[s.length()];
    int i= 1, j = 0;
    b[0] = 0;
    while(i < s.length()) {
      while(j >= 0 && s.charAt(j) != s.charAt(i)) {
        if (j - 1 < 0) {
          i++;
          j = 0;
          break;
        }
        j = b[j - 1];
      }
      if (s.charAt(j) == s.charAt(i)) {
        b[i] = j + 1;
        i++;
        j++;
      }
    }
    return b;
  }

  public int kmp(String target, String pattern ) {
    int[] pre = this.precalculatePreSuf(pattern);
    int i = 0;
    int j = 0;
    while(i < target.length()) {
      if (target.charAt(i) == target.charAt(j)) {
        j++;
        i++;
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
    return -1;
  }
}
