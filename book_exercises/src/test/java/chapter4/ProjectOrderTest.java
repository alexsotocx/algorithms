package chapter4;

import datastructures.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProjectOrderTest {

  @Test
  void findOrder() {
    Graph<Character> graph = new Graph<>();
    graph.addNode('a');
    graph.addNode('b');
    graph.addNode('c');
    graph.addNode('d');
    graph.addNode('e');
    graph.addNode('f');
    graph.addConnection('a', 'd');
    graph.addConnection('f', 'b');
    graph.addConnection('b', 'd');
    graph.addConnection('f', 'a');
    graph.addConnection('d', 'c');

    System.out.println(new ProjectOrder<>(graph).findOrder());
    graph.addConnection('c', 'f');
    Assertions.assertThrows(Error.class, () -> new ProjectOrder<>(graph).findOrder());
  }
}
