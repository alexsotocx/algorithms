package chapter10;

public class SearchInARotatedArray {
  private int[] data;
  private int zeroIndex;

  public SearchInARotatedArray(int[] data) {
    this.data = data;
    this.zeroIndex = findZeroIndex();
  }

  private int findZeroIndex() {
    int lo = 0;
//    int hi = data.length - 1;
//    while(lo != hi) {
//      int mid = (lo + hi)/ 2;
//      if (mid - 1 >= 0) {
//        if (data[mid - 1] > data[mid]) return mid;
//        data
//      }
//      if (mid + 1 < data.length && )
//    }
    return lo;
  }
}
