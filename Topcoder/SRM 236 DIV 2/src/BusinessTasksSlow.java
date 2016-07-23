import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class BusinessTasksSlow {

  public String getTask(String[] list, int n) {
    Queue<String> queue = new ArrayDeque<String>();
    Collections.addAll(queue, list);
    int iterator = n;
    while (queue.size() != 1) {
      iterator--;
      if (iterator == 0) {
        queue.poll();
        iterator = n;
      } else
        queue.offer(queue.poll());
    }
    return queue.peek();
  }
}
