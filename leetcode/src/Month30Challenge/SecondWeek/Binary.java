package Month30Challenge.SecondWeek;

import java.util.HashMap;

public class Binary {

  public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int currentSum = 0, max = 0;
    map.put(0, -1);
    for(int i=0; i< nums.length; i++) {
      currentSum += nums[i] == 0 ? -1 : 1;
      if(map.containsKey(currentSum)) {
        max = Math.max(max, i - map.get(currentSum));
        continue;
      }
      map.put(currentSum, i);
    }
    return max;
  }
}

