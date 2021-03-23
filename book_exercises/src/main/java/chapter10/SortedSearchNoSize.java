package chapter10;

public class SortedSearchNoSize {
  private int data[];

  public SortedSearchNoSize(int container[]) {
    data = container;
  }

  public int search(int element) {
    int hi = 1 << 29;
    int lo = 0;
    while (hi != lo) {
      int mid = (hi + lo) / 2;
      int midElement = getElementAt(mid);
      if (midElement == -1) hi = mid - 1;
      else if (midElement == element) return mid;
      else if (midElement > element) hi = mid - 1;
      else lo = mid + 1;
    }
    return -1;
  }

  public int getElementAt(int index) {
    if (index < data.length) return data[index];
    return -1;
  }
}
