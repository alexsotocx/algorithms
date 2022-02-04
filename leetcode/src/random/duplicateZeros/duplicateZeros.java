package random.duplicateZeros;


class Solution {
  private void changeValue(int[] arr, int pos, int val) {
    if (pos < arr.length) arr[pos] = val;
  }
  public void duplicateZeros(int[] arr) {
    int zeros = 0;
    for (int j : arr) {
      if (j == 0) zeros++;
    }
    int dest = arr.length  + zeros - 1;
    int pos = arr.length - 1;
    while (pos < dest) {
      if (arr[pos] == 0) {
        changeValue(arr, dest--, arr[pos]);
      }
      changeValue(arr, dest--, arr[pos--]);
    }
  }
}
