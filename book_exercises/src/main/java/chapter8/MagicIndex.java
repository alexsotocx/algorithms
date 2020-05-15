package chapter8;

public class MagicIndex {
  boolean hasMagicIndex(int[] arr) {
    int low = 0;
    int hi = arr.length - 1;
    while (low != hi) {
      int mid = (low + hi) / 2;
      if (mid == arr[mid]) return true;
      else if (mid < arr[mid]) hi = mid - 1;
      else low = mid + 1;
    }
    if (arr[low] == low) return true;
    return arr[hi] == hi;
  }
}
