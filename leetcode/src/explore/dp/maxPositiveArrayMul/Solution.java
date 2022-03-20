package explore.dp.maxPositiveArrayMul;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int getMaxLen(int[] nums) {
    int result = 0;
    int positiveSoFar = 0;
    int negativesSoFar = 0;
    Queue<Integer> negatives = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        positiveSoFar = 0;
        negativesSoFar = 0;
        negatives = new LinkedList<>();
        continue;
      }
      if (nums[i] > 0) {
        if (negativesSoFar != 0) negativesSoFar++;
        positiveSoFar++;
      } else {
        negatives.add(i);
        if (negativesSoFar == 0 && positiveSoFar == 0) {
          negativesSoFar++;
        } else if (negativesSoFar > 0 && positiveSoFar > 0) {
          int st = negatives.poll();
          int pTemp = positiveSoFar;
          positiveSoFar = Math.max(negativesSoFar + 1, i - negatives.peek());
          if (i - st > pTemp + 1) negativesSoFar = i - st;
          else {
            negativesSoFar = pTemp + 1;
            while (!negatives.isEmpty() && negatives.peek() < i - pTemp) negatives.poll();
          }
        } else if (negativesSoFar > 0) {
          positiveSoFar = negativesSoFar + 1;
          negativesSoFar = i - negatives.poll();
        } else {
          int t = positiveSoFar;
          positiveSoFar = 0;
          negativesSoFar = t + 1;
        }

      }
      result = Math.max(result, positiveSoFar);

    }
    return result;
  }
}
