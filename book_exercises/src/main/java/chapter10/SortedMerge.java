package chapter10;

public class SortedMerge {
  public int[] sort(int[] a, int[] b, int lastValidElementPosition) {
    int aIterator = lastValidElementPosition;
    int bIterator = b.length - 1;
    int currentPosition = a.length - 1;
    while(aIterator >= 0  && bIterator >= 0) {
      if(a[aIterator] >= b[bIterator]) {
        a[currentPosition] = a[aIterator];
        aIterator--;
      } else {
        a[currentPosition] = b[bIterator];
        bIterator--;
      }
      currentPosition--;
    }
    while(currentPosition >= 0) {
      if (bIterator < 0) {
        a[currentPosition] = a[aIterator--];
      } else {
        a[currentPosition] = b[bIterator--];
      }
      currentPosition--;
    }
    return a;
  }
}
