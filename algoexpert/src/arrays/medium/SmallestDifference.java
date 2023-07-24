package arrays.medium;
import java.util.*;

public class SmallestDifference {

  public static int distance(int a, int b) {
    return a > b ? a - b : b - a;
  }

  public static int binarySearch(int[] array, int target) {
    int lo = 0;
    int hi = array.length - 1;
    while (hi > lo) {
      int mid = lo + (hi - lo) / 2;
      if (array[mid] == target) return mid;
      else if (target < array[mid]) hi = mid -1;
      else lo = mid + 1;
    }

    return hi;

  }


  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    int closest = 0;
    int closest2 = 0;
    int d = 1<<30;

    for(int n: arrayTwo) {
      int foundIndex = binarySearch(arrayOne, n);
      for (int i = foundIndex - 1; i <= foundIndex + 1; i++) {
        int index = Math.min(arrayOne.length - 1, Math.max(0, i));
        if (distance(arrayOne[index], n) <  d) {
          closest = arrayOne[index];
          closest2 = n;
          d = distance(arrayOne[index], n);
        }
      }
    }

    return new int[]{closest, closest2};
  }
}
