package microsoft.reverseWords;

class Solution {
  private void reverseWord(char[] chars, int s, int e) {
    if (e < s) return;
    int mid = s + (e - s) / 2;
    for (int i = 0; s + i <= mid; i++) {
      char temp = chars[s + i];
      chars[s + i] = chars[e - i];
      chars[e - i] = temp;
    }
  }

  public String reverseWords(String wo) {
    char[] words = wo.toCharArray();
    int s = 0;
    for (int i = 0; i < words.length; i++) {
      if (words[i] == ' ') {
        reverseWord(words, s, i - 1);
        s = i + 1;
      }
    }
    if (s != words.length) reverseWord(words, s, words.length - 1);
    return new String(words);
  }
}
