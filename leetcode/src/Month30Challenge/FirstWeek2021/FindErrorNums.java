package Month30Challenge.FirstWeek2021;

import java.util.HashSet;

public class FindErrorNums {
  public int[] findErrorNums(int[] nums) {
    HashSet<Integer> numbers = new HashSet();
    for (int i = 1; i <= nums.length; numbers.add(i++)) ;
    int missing = 0;
    int repeated = 0;
    for (int num : nums) {
      if (numbers.contains(num))
        numbers.remove(num);
      else
        repeated = num;
    }
    for (int x : numbers) missing = x; // should be just one

    return new int[]{repeated, missing};
  }
}
