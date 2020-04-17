package mockinterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CPUOrchestator {
  public int orchestator(ArrayList<Integer> foreground, ArrayList<Integer> background, int memory) {
    HashMap<Integer, Integer> countForeground = countNumbers(foreground, memory);
    HashMap<Integer, Integer> countBackground = countNumbers(background, memory);
    ArrayList<Integer> uniqueForeground = new ArrayList<>(countForeground.keySet());
    Collections.sort(uniqueForeground);
    int maxCount = 0;
    int maxMemory = 0;
    for (Integer bMemory : countBackground.keySet()) {
      int index = Collections.binarySearch(uniqueForeground, (memory - bMemory));
      if (index == -1) continue;
      int fMemory = index > 0 ? uniqueForeground.get(index) : uniqueForeground.get(-1 * (index + 2));
      int runMemory = bMemory + fMemory;
      if (runMemory > maxMemory) {
        maxMemory = runMemory;
        maxCount = countBackground.get(bMemory) * countForeground.get(fMemory);
      } else if (runMemory == maxMemory) {
        maxCount += countBackground.get(bMemory) * countForeground.get(fMemory);
      }
    }
    return maxCount;
  }

  private HashMap<Integer, Integer> countNumbers(ArrayList<Integer> array, int memory) {
    HashMap<Integer, Integer> count = new HashMap<>();
    for (Integer c : array) {
      if (memory < c) continue;
      count.put(c, count.getOrDefault(c, 0) + 1);
    }
    return count;
  }
}
