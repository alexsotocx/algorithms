package random.processTaskUsingServers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  class Task {
    int inQueueAt;
    int startedProcessingAt;
    int duration;

    public Task(int inQueueAt, int duration) {
      this.inQueueAt = inQueueAt;
      this.duration = duration;
    }

    int finishingTime() {
      return duration + startedProcessingAt;
    }
  }

  class Server {
    int id;
    int weight;
    Task task;

    public Server(int id, int weight) {
      this.weight = weight;
      this.id = id;
    }

    public Task getTask() {
      return task;
    }

    public void setTask(Task task) {
      this.task = task;
    }
  }

  class ServerManager {
    PriorityQueue<Server> availableServers;
    PriorityQueue<Server> processingServers;
    Queue<Task> waitingTasks;
    int[] history;

    public ServerManager(ArrayList<Server> availableServers, int taskCount) {
      this.availableServers = new PriorityQueue<>((o1, o2) -> {
        if (o1.weight != o2.weight) return Integer.compare(o1.weight, o2.weight);
        return Integer.compare(o1.id, o2.id);
      });

      this.processingServers = new PriorityQueue<>((o1, o2) -> {
        final Task task = o1.getTask();
        final Task task2 = o2.getTask();
        if (task.finishingTime() == task2.finishingTime()) return Integer.compare(task.inQueueAt, task2.inQueueAt);
        return Integer.compare(task.finishingTime(), task2.finishingTime());
      });

      this.availableServers.addAll(availableServers);
      this.waitingTasks = new LinkedList<>();

      history = new int[taskCount];
    }

    public void addTask(int currentTime, int taskDuration) {
      processTaskUntil(currentTime);
      this.waitingTasks.add(new Task(currentTime, taskDuration));
      flushWaitingTask(currentTime);
    }

    public void finishProcessing() {
      while (!processingServers.isEmpty()) {
        int taskDuration = processingServers.peek().getTask().finishingTime();
        this.processTaskUntil(taskDuration);
        flushWaitingTask(taskDuration);
      }
    }

    private void processTaskUntil(int time) {
      while (!processingServers.isEmpty() && processingServers.peek().getTask().finishingTime() <= time) {
        Server s = processingServers.poll();
        s.setTask(null);
        this.availableServers.add(s);
      }
    }

    private void flushWaitingTask(int time) {
      while (!waitingTasks.isEmpty() && !this.availableServers.isEmpty())
        setTaskToServer(time, waitingTasks.poll());
    }


    private void setTaskToServer(int time, Task t) {
      Server s = this.availableServers.poll();
      t.startedProcessingAt = time;
      s.setTask(t);
      history[t.inQueueAt] = s.id;
      this.processingServers.add(s);
    }
  }

  public int[] assignTasks(int[] servers, int[] tasks) {
    ArrayList<Server> serverInstances = new ArrayList<>();
    for (int i = 0; i < servers.length; i++) {
      serverInstances.add(new Server(i, servers[i]));
    }
    ServerManager manager = new ServerManager(serverInstances, tasks.length);
    for (int i = 0; i < tasks.length; i++) {
      manager.addTask(i, tasks[i]);
    }
    manager.finishProcessing();
    return manager.history;
  }
}
