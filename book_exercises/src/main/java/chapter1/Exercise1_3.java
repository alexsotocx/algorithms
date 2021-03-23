package chapter1;

/*
Given a char array replace all the spaces for %20, the array will have enough capacity to handle the extra characters
 */
public class Exercise1_3 {
  static final char[] space = {'%', '2', '0'};
  private char[] url;
  private int fns;

  public Exercise1_3(String url, int fns) {
    this.url = url.toCharArray();
    this.fns = fns;
  }

  public String convert() {
    int j = url.length - 1;
    fns--; // Last available character
    while (fns >= 0) {
      if (url[fns] == ' ') {
        j -= space.length - 1;
        add(space, url, j);
      } else {
        add(url[fns], url, j);
      }
      fns--;
      j--;

    }
    return new String(url);
  }

  private void add(char[] seq, char[] target, int j) {
    for (char c : seq) {
      target[j] = c;
      j++;
    }
  }

  private void add(char c, char[] target, int j) {
    target[j] = c;
  }
}
