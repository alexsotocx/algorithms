package amazon.earliestAcq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
  private class UnionFind {
    int[] parent;
    int groups;
    UnionFind(int n) {
      groups = n;
      parent = new int[n];
      IntStream.range(0, n).forEach(i-> parent[i] = i);
    }

    int find(int i) {
      parent[i] = parent[i] == i ? parent[i] : find(parent[i]);
      return parent[i];
    }

    int join(int i, int j) {
      int pi = this.find(i);
      int pj = this.find(j);
      if (pi == pj) return pi;
      parent[pi] = pj;
      groups--;
      return pj;
    }

    int size() {
      return groups;
    }
  }
  public int earliestAcq(int[][] logs, int n) {
    UnionFind uf = new UnionFind(n);
    Arrays.sort(logs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });
    for(int[] log : logs) {
      uf.join(log[1], log[2]);
      if (uf.size() == 1) {
        return log[0];
      }
    }
    return -1;
  }
}
