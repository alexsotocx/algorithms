import java.util.HashSet;
import java.util.PriorityQueue;

class UglyNumbers136 {
  public static void main(String[] args) {
    long[] sol = new long[1500];
    PriorityQueue<Long> temp = new PriorityQueue<>();
    HashSet<Long> v = new HashSet<>();
    temp.add(1L);
    v.add(1L);
    for (int i = 0; i < 1500; i++) {
      long u;
      sol[i] = temp.poll();
      if (v.add(u = sol[i] * 2)) temp.add(u);
      if (v.add(u = sol[i] * 3)) temp.add(u);
      if (v.add(u = sol[i] * 5)) temp.add(u);
    }
    System.out.println("The 1500'th ugly number is " + sol[1499] + ".");
  }
}