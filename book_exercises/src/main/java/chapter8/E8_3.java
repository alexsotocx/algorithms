package chapter8;

public class E8_3 {
  int findMagicNumber(int[] a) {
    int low = 0, hi = a.length - 1;
    while (low < hi) {
      int mid = (low + hi) / 2;
      if (mid == a[mid]) return mid;
      if (mid <= a[mid]) hi = mid - 1;
      else low = mid + 1;
    }
    if(a[hi] == hi) return hi;
    if(a[low] == low) return low;
    return -1;
  }
}
