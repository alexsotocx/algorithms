package Month30Challenge.FirstWeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class HappyNumber {
  public boolean isHappy(int n) {
    if (n == 0) return false;
    HashSet<Integer> isThere = new HashSet<>();
    do {
      ArrayList<Integer> digits = getDigits(n);
      int setNumber = sumDigits(digits);
      if (isThere.contains(setNumber)) return false;
      isThere.add(setNumber);
      n = digits.stream().reduce(0, (subtotal, b) -> subtotal + b*b);
    } while (n != 1);
    return true;
  }

  private int sumDigits(List<Integer> digits) {
    Collections.sort(digits);

    int setNumber = 0;
    int i = 1;
    for(int s : digits) {
      setNumber += s * i;
      i*= 10;
    }
    return setNumber;
  }

  private ArrayList<Integer> getDigits(int n) {
    ArrayList<Integer> result = new ArrayList<>();
    while(n > 0) {
      result.add(n % 10);
      n /= 10;
    }
    return result;
  }
}
