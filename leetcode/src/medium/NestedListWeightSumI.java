package medium;


import java.util.List;


class NestedListWeightSumI {
  int maxDepth = 1;
  int[] valuesPerDepth = new int[51];

  public int depthSum(List<NestedInteger> nestedList) {
    for (NestedInteger n : nestedList) {
      loop(1, n);
    }
    int total = 0;
    for (int i = 1; i <= maxDepth; i++) {
      total += i * valuesPerDepth[i];
    }
    return total;
  }


  private void loop(int currentDepth, NestedInteger nested) {
    if (nested.isInteger()) valuesPerDepth[currentDepth] += nested.getInteger();
    else {
      currentDepth++;
      maxDepth = Math.max(currentDepth, maxDepth);
      for (NestedInteger n : nested.getList()) {
        loop(currentDepth, n);
      }
    }
  }
}
