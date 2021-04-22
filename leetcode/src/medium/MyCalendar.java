package medium;


  import java.util.TreeSet;

class MyCalendar {
  TreeSet<Interval> booked = new TreeSet<>();

  public MyCalendar() {

  }

  public boolean book(int start, int end) {
    return booked.add(new Interval(start, end));
  }


  private class Interval implements Comparable<Interval> {
    int start, end;
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }


    @Override
    public int compareTo(Interval o) {
      int max = Math.max(o.start, start);
      int min = Math.min(o.end, end);
      if (max < min) return 0;
      return Integer.compare(max, min);
    }

    @Override
    public String toString() {
      return "Interval{" +
        "start=" + start +
        ", end=" + end +
        '}';
    }
  }
}
