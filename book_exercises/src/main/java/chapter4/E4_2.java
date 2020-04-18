package chapter4;

import datastructures.BinaryNode;

public class E4_2 {
  BinaryNode<Integer> convertToTree(int[] a) {
    return convert(0, a.length - 1, a);
  }

  private BinaryNode<Integer> convert(int lo, int hi, int[] a) {
    if (lo == hi) return new BinaryNode<>(a[lo]);
    if (lo > hi) return null;
    int mid = (lo + hi) / 2;
    return new BinaryNode<>(a[mid], convert(lo, mid - 1, a), convert(mid + 1, hi, a));
  }
}
