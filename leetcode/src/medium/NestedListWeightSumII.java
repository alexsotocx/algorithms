package medium;


import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // Set this NestedInteger to hold a single integer.
  public void setInteger(int value);

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(NestedInteger ni);

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

class NestedListWeightSumII {
  int maxDepth = 1;
  int[] valuesPerDepth = new int[51];

  public int depthSumInverse(List<NestedInteger> nestedList) {
    for (NestedInteger n : nestedList) {
      loop(1, n);
    }
    int total = 0;
    for (int i = 1; i <= maxDepth; i++) {
      total += (maxDepth - i + 1) * valuesPerDepth[i];
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
