package chapter4;

import datastructures.BinaryTreeNode;

public class E4_2 {
  BinaryTreeNode<Integer> convertToTree(int[] a) {
    return convert(0, a.length - 1, a);
  }

  private BinaryTreeNode<Integer> convert(int lo, int hi, int[] a) {
    if (lo == hi) return new BinaryTreeNode<>(a[lo]);
    if (lo > hi) return null;
    int mid = (lo + hi) / 2;
    return new BinaryTreeNode<>(a[mid], convert(lo, mid - 1, a), convert(mid + 1, hi, a));
  }
}
