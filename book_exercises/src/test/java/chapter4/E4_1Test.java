package chapter4;

import datastructures.AdjacencyList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E4_1Test {

  @Test
  public void isConnected() {
    AdjacencyList adjacencyList = new AdjacencyList(7);
    adjacencyList.addConnection(0, 1);
    adjacencyList.addConnection(1, 2);
    adjacencyList.addConnection(2, 0);
    adjacencyList.addConnection(2, 3);
    adjacencyList.addConnection(3, 2);

    adjacencyList.addConnection(6, 5);
    adjacencyList.addConnection(5, 4);
    adjacencyList.addConnection(4, 6);

    assertTrue(new E4_1().isConnected(0, 3, adjacencyList));
    assertTrue(new E4_1().isConnected(1, 2, adjacencyList));
    assertTrue(new E4_1().isConnected(2, 1, adjacencyList));
    assertTrue(new E4_1().isConnected(2, 3, adjacencyList));
    assertTrue(new E4_1().isConnected(3, 2, adjacencyList));
    assertTrue(new E4_1().isConnected(6, 4, adjacencyList));
    assertTrue(new E4_1().isConnected(4, 6, adjacencyList));

    assertTrue(new E4_1().isConnected(1, 1, adjacencyList));

    assertFalse(new E4_1().isConnected(1, 6, adjacencyList));
    assertFalse(new E4_1().isConnected(4, 3, adjacencyList));
  }
}