public class TurretDefense {
  public int getDifference(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  public int firstMiss(int[] xs, int[] ys, int[] times) {
    int startX = 0, startY = 0, time = 0;
    for(int i = 0; i < times.length; i++) {
      int difference = this.getDifference(startX, startY, xs[i], ys[i]);
      if((difference + time) <= times[i]) {
        time = times[i];
        startX = xs[i];
        startY = ys[i];
      } else {
        return i;
      }
    }
    return -1;
  }
}
