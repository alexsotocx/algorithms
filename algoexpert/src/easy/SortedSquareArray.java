package easy;

public class SortedSquareArray {
  public int[] sortedSquaredArray(int[] array) {
    int[] res = new int[array.length];
    int pointerStart = 0;
    int pointerEnd = array.length - 1;
    int pResult = array.length - 1;
    while (pointerStart <= pointerEnd) {
      if (array[pointerStart] * array[pointerStart] > array[pointerEnd] * array[pointerEnd]) {
        res[pResult--] = array[pointerStart] * array[pointerStart];
        pointerStart++;
      } else {
        res[pResult--] = array[pointerEnd] * array[pointerEnd];
        pointerEnd--;
      }
    }
    return res;
  }
}
