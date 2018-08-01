package datastructures;

import java.util.ArrayList;

public class AdjacencyList {
  ArrayList<ArrayList<Integer>> connections;
  int numNodes;

  public AdjacencyList() {
    connections = new ArrayList<>();
  }

  public AdjacencyList(int numNodes) {
    this.numNodes = numNodes;
    connections = new ArrayList<>(numNodes);
    for (int i = 0; i < numNodes; i++) connections.add(i, new ArrayList<>());
  }

  public ArrayList<Integer> getConnectionsFor(int v) {
    if (v > numNodes) return null;
    return connections.get(v);
  }

  public int addNode() {
    connections.add(new ArrayList<>());
    numNodes++;
    return numNodes - 1;
  }

  public void addConnection(int s, int e) {
    if (connections.get(s) == null) connections.set(s, new ArrayList<>());
    connections.get(s).add(e);
  }

  public int Size() {
    return numNodes;
  }
}
