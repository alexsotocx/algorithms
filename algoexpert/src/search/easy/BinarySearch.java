package search.easy;

public class BinarySearch {
  public static int binarySearch(int[] array, int target) {
    int lo = 0;
    int hi = array.length - 1;
    while (hi >= lo) {
      int mid = lo + (hi - lo) /2;
      if (target == array[mid]) return mid;
      if (target < array[mid]) hi = mid - 1;
      else lo = mid + 1;
    }
    return -1;
  }
}
