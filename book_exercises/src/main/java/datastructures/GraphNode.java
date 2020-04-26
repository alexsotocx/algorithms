package datastructures;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
  public T id;
  private List<GraphNode<T>> nodes;

  public GraphNode(T id) {
    this.nodes = new ArrayList<>();
    this.id = id;
  }

  public List<GraphNode<T>> getAdjacent() {
    return this.nodes;
  }

  public void addVertex(GraphNode<T> vertex) {
    nodes.add(vertex);
  }
}
