package chapter4;

import datastructures.AdjacencyList;

public class E4_1 {
  boolean isConnected(int nodeStart, int nodeEnd, AdjacencyList adjacencyList) {
    boolean[] visited = new boolean[adjacencyList.Size()];
    dfs(nodeStart, adjacencyList, visited);
    return visited[nodeEnd];
  }

  void dfs(int startNode, AdjacencyList adjacencyList, boolean[] visited) {
    visited[startNode] = true;
    for (int v : adjacencyList.getConnectionsFor(startNode)) {
      if (!visited[v]) dfs(v, adjacencyList, visited);
    }
  }
}
