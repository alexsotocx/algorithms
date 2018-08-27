package InterviewPrepartionKit.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {
  List<Integer> freqQuery(List<int[]> queries) {
    List<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> hf = new HashMap<>();
    HashMap<Integer, Integer> hn = new HashMap<>();

    for (int[] q : queries) {
      int qn = q[0], num = q[1];

      if (qn == 3) {
        if (hf.getOrDefault(num, 0) != 0) result.add(1);
        else result.add(0);
        continue;
      }

      int count = hn.getOrDefault(num, 0);
      if (count != 0) {
        hf.put(count, hf.get(count) - 1);
      } else if (qn == 2) {
        continue;
      }

      if (qn == 1) count++;
      else count--;

      hn.put(num, count);
      hf.put(count, hf.getOrDefault(count, 0) + 1);
    }
    return result;
  }
}
