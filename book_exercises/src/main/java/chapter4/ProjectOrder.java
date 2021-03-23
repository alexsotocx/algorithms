package chapter4;

import datastructures.Graph;
import datastructures.GraphNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ProjectOrder<T> {
  private final int VISITED = 2;
  private final int IN_PROGRESS = 1;
  private final int NOT_VISITED = 0;

  private Graph<T> graph;
  private HashMap<T, Integer> visited;
  private Deque<T> order;

  public ProjectOrder(Graph<T> graph) {
    this.graph = graph;
  }

  public Deque<T> findOrder() {
    this.visited = new HashMap<>();
    this.order = new LinkedList<>();
    for (T u : graph.getNodes()) {
      if (!visited.containsKey(u)) dfs(u);
    }
    return order;
  }

  private void dfs(T u) {
    this.visited.put(u, IN_PROGRESS);

    for (GraphNode<T> v : graph.getAdjacent(u)) {
      if (!visited.containsKey(v.id)) dfs(v.id);
      else if (visited.get(v.id) == IN_PROGRESS) throw new Error("Cycle found, cant find order");
    }

    this.visited.put(u, VISITED);
    this.order.push(u);
  }
}
