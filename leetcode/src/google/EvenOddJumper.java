package google;

import java.util.HashSet;
import java.util.TreeSet;

public class EvenOddJumper {
  static class Pair {
    int index, value;

    public Pair(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Pair{" +
        "index=" + index +
        ", value=" + value +
        '}';
    }
  }

  public int oddEvenJumps(int[] arr) {
    HashSet<Integer> evenGoodJumpers = new HashSet<>();
    HashSet<Integer> oddGoodJumpers = new HashSet<>();
    TreeSet<Pair> orderHigh = new TreeSet<>((o1, o2) -> {
      if (o1.value != o2.value) return Integer.compare(o1.value, o2.value);
      return Integer.compare(o1.index, o2.index);
    });

    TreeSet<Pair> orderLow = new TreeSet<>((o1, o2) -> {
      if (o1.value != o2.value) return Integer.compare(o1.value, o2.value);
      return Integer.compare(o2.index, o1.index);
    });

    int n = arr.length - 1;
    evenGoodJumpers.add(n);
    oddGoodJumpers.add(n);
    orderHigh.add(new Pair(n, arr[n]));
    orderLow.add(new Pair(n, arr[n]));

    for (int i = n - 1; i >= 0; i--) {
      Pair current = new Pair(i, arr[i]);
      Pair higher = orderHigh.higher(current);
      Pair lower = orderLow.lower(current);
      // odd jump
      if (higher != null && arr[i] <= higher.value) {
        if (evenGoodJumpers.contains(higher.index)) {
          oddGoodJumpers.add(i);
        }
      }
      // even
      if (lower != null && arr[i] >= lower.value) {
        if (oddGoodJumpers.contains(lower.index)) {
          evenGoodJumpers.add(i);
        }
      }
      orderHigh.add(current);
      orderLow.add(current);
    }

    return oddGoodJumpers.size();
  }
}
