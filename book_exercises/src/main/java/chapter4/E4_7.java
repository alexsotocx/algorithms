package chapter4;

import datastructures.AdjacencyList;

import java.util.Stack;

public class E4_7 {
  Stack<Character> buildOrder(AdjacencyList adjacencyList) {
    Stack<Character> order = new Stack<>();
    boolean[] visited = new boolean[adjacencyList.Size()];
    for (int i = 0; i < adjacencyList.Size(); i++)
      if (!visited[i]) dfs(i, visited, adjacencyList, order);
    return order;
  }

  private void dfs(int start, boolean[] visited, AdjacencyList adjacencyList, Stack<Character> order) {
    visited[start] = true;
    for (int v : adjacencyList.getConnectionsFor(start)) {
      if (!visited[v]) dfs(v, visited, adjacencyList, order);
    }

    order.push((char) ('a' + start));
  }
}
