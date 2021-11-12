package amazon.reverse2k;


class Solution {
  public String reverseStr(String s, int k) {
    char[] data = s.toCharArray();
    for (int i = 0; i < data.length; ) {
      if (i + 2 * k < data.length || i + k <= data.length) {
        for (int j = 0; j < k / 2; j++) {
          char t = data[i + j];
          data[i + j] = data[i + k - j - 1];
          data[i + k - j - 1] = t;
        }
        i += 2 * k;
      } else if (k + i > data.length) {
        for (; i <= (data.length - i) / 2; i++) {
          char t = data[i];
          data[i] = data[data.length - 1 - i];
          data[data.length - 1 - i] = t;
        }
        break;
      }
    }
    return new String(data);
  }
}
