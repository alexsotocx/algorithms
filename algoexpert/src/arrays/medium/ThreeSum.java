package arrays.medium;

import java.util.*;

public class ThreeSum {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);
    ArrayList<Integer[]> response = new ArrayList<Integer[]>();

    for(int i = 0; i < array.length; i++) {
      int c = array[i];
      int left = i + 1;
      int right = array.length - 1;

      while(left < right) {
        int s = c + array[left] + array[right];
        if (s == targetSum) {
          response.add(new Integer[]{c, array[left], array[right]});
          left++;
          right--;
        }
        else if (s < targetSum) left++;
        else right--;
      }
    }

    return response;
  }
}
