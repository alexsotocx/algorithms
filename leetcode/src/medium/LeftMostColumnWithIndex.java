package medium;

import java.util.List;


// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
  public int get(int row, int col);

  public List<Integer> dimensions();
};

class LeftMostColumnWithIndex {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dimensions = binaryMatrix.dimensions();
    int rows = dimensions.get(0);
    int cols = dimensions.get(1);
    int ans = -1;
    for (int i = 0; i < rows; i++) {
      int columnsToSearch = ans == -1 ? cols : ans;
      int min = leftMostOneIndex(binaryMatrix, i, columnsToSearch);
      if (ans == -1 || min != -1 && ans > min) ans = min;
    }
    return ans;
  }

  private int leftMostOneIndex(BinaryMatrix binaryMatrix, int row, int maxColumns) {
    int ans = -1;
    int lo = 0;
    int hi = maxColumns - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int midVal = binaryMatrix.get(row, mid);
      if (midVal == 0) lo = mid + 1;
      else {
        if (ans == -1 || mid < ans) ans = mid;
        hi = mid - 1;
      }
    }
    return ans;
  }
}
