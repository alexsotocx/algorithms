package chapter4;

import datastructures.BNode;

import java.util.HashMap;
import java.util.HashSet;

public class E4_12 {
  private HashMap<BNode<Integer>, HashSet<Integer>> memo;

  public int sumPath(int x, BNode<Integer> root) {
    memo = new HashMap<>();
    return sumPathHelper(x, root, 0);
  }

  private int sumPathHelper(int x, BNode<Integer> root, int sum) {
    if (root == null) return 0;
    if (!memo.containsKey(root)) memo.put(root, new HashSet<>());
    HashSet<Integer> set = memo.get(root);
    if (set.contains(sum)) return 0; // Already Visited
    set.add(sum);
    int data = root.data;
    int sumWith = sum + data == x ? 1 : 0;
    sumWith += sumPathHelper(x, root.left, sum + data);
    sumWith += sumPathHelper(x, root.right, sum + data);
    int sumWithout = sumPathHelper(x, root.left, data);
    sumWithout += sumPathHelper(x, root.right, data);
    return sumWith + sumWithout;
  }
}
