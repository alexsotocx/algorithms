package datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph<T> {
  private HashMap<T, GraphNode<T>> graph = new HashMap<>();

  public void addNode(T v) {
    if (graph.containsKey(v)) return;
    graph.put(v, new GraphNode<>(v));
  }

  public void addConnection(T u, T v) {
    if (!graph.containsKey(u)) addNode(u);
    if (!graph.containsKey(v)) addNode(v);
    graph.get(u).addVertex(graph.get(v));
  }

  public List<GraphNode<T>> getAdjacent(T id) {
    return graph.get(id).getAdjacent();
  }

  public Set<T> getNodes() {
    return graph.keySet();
  }
}
