package chapter1;

/*
Given a char array replace all the spaces for %20, the array will have enough capacity to handle the extra characters
 */
public class Exercise1_3 {

  void urify(int n, char[] uri) {
    int i = n - 1; // Stores the last real element;
    int j = uri.length - 1; // Stores the last element of the array, probably a space
    while (i < j) {
      if (uri[i] == ' ') {
        addSpace(j, uri);
        j -= 3;
        i--;
      } else {
        uri[j--] = uri[i--];
      }
    }
  }

  private void addSpace(int p, char[] uri) {
    uri[p] = '0';
    uri[p - 1] = '2';
    uri[p - 2] = '%';
  }
}
