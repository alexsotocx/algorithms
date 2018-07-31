package datastructures;

import java.util.ArrayList;

public class AdjacencyList {
  ArrayList<ArrayList<Integer>> connections;
  int numberConnections;

  public AdjacencyList() {
    connections = new ArrayList<>();
  }

  public AdjacencyList(int numberConnections) {
    this.numberConnections = numberConnections;
    connections = new ArrayList<>(numberConnections);
    for (int i = 0; i < numberConnections; i++) connections.add(i, new ArrayList<>());
  }

  public ArrayList<Integer> getConnectionsFor(int v) {
    if (v > numberConnections) return null;
    return connections.get(v);
  }

  public int addNode() {
    connections.add(new ArrayList<>());
    numberConnections++;
    return numberConnections - 1;
  }

  public void addConnection(int s, int e) {
    if (connections.get(s) == null) connections.set(s, new ArrayList<>());
    connections.get(s).add(e);
  }

  public int Size() {
    return numberConnections;
  }
}
