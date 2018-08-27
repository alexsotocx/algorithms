package InterviewPrepartionKit.HashMaps;

import java.util.HashMap;
import java.util.List;

public class CountTriplets {
  long countTriplets(List<Long> arr, long r) {
    HashMap<Long, Long> t1 = new HashMap<>();
    HashMap<Long, Long> t2 = new HashMap<>();
    long c = 0;
    for (long v : arr) {
      if (t2.containsKey(v)) c += t2.get(v);
      if (t1.containsKey(v)) t2.put(v * r, t2.getOrDefault(v * r, 0L) + t1.get(v));
      t1.put(v * r, t1.getOrDefault(v * r, 0L) + 1);
    }
    return c;
  }
}
