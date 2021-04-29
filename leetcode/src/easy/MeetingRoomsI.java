package easy;

import java.util.Comparator;
import java.util.TreeSet;

public class MeetingRoomsI {
  public boolean canAttendMeetings(int[][] intervals) {
    TreeSet<int[]> intervalsO = new TreeSet<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] >= o2[1]) return 1;
        if (o1[1] <= o2[0]) return -1;
        return 0;
      }
    });
    for (int[] i : intervals) {
      if (!intervalsO.add(i)) return false;
    }
    return true;
  }
}
