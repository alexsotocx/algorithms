import java.util.Collections;
import java.util.LinkedList;

public class BusinessTasks {

  public String getTask(String[] list, int n) {
    LinkedList<String> deque = new LinkedList<String>();
    Collections.addAll(deque, list);
    int iterator = (n % (deque.size()));
    while (deque.size() != 1) {
      if (iterator == 0) {
        deque.removeLast();
        iterator = (n % deque.size());
      } else {
        deque.offer(deque.removeFirst());
        iterator--;
      }

    }
    return deque.peek();
  }
}
