package easy;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
  private long sum = 0;
  int size;
  Queue<Integer> values;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    this.size = size;
    values = new LinkedList<Integer>();
  }

  public double next(int val) {
    values.add(val);
    if (values.size() > size) {
      sum -= values.poll();
    }
    sum += val;
    return sum * 1.0 / values.size();
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
