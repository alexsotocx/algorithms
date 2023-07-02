package easy;

import java.util.*;

class Program {
  // O(N) T / O(N) S
  public static int[] twoNumberSum(int[] array, int targetSum) {
    if (array.length <= 1 ) return new int[0];
    HashSet<Integer> viewed = new HashSet<>();
    viewed.add(array[0]);

    for(int i = 1 ; i < array.length; i++) {
      int c = array[i];
      int b = targetSum - c;
      if (viewed.contains(b)) return new int[]{c, b};
      viewed.add(c);
    }

    return new int[0];
  }
}

