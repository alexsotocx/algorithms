package chapter4;

import datastructures.BNode;

public class E4_2 {
  BNode<Integer> convertToTree(int[] a) {
    return convert(0, a.length - 1, a);
  }

  private BNode<Integer> convert(int lo, int hi, int[] a) {
    if (lo == hi) return new BNode<>(a[lo]);
    if (lo > hi) return null;
    int mid = (lo + hi) / 2;
    return new BNode<>(a[mid], convert(lo, mid - 1, a), convert(mid + 1, hi, a));
  }
}
