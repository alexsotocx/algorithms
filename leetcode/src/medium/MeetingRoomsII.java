package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> onGoingMeetings = new PriorityQueue<>();
    int maxConcurrentMeetings = 0;
    for(int[] i: intervals) {
      while(!onGoingMeetings.isEmpty() && i[0] >= onGoingMeetings.peek()) onGoingMeetings.poll();
      onGoingMeetings.add(i[1]);
      maxConcurrentMeetings = Math.max(maxConcurrentMeetings, onGoingMeetings.size());
    }
    return maxConcurrentMeetings;
  }
}
