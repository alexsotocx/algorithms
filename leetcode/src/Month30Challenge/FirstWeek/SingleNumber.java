package Month30Challenge.FirstWeek;

import java.util.HashSet;

class SingleNumber {
  public int singleNumber(int[] nums) {
    HashSet<Integer> numbers = new HashSet<>();
    for (int c : nums) {
      if (numbers.contains(c)) numbers.remove(c);
      else numbers.add(c);
    }
    return numbers.iterator().next();
  }
}
