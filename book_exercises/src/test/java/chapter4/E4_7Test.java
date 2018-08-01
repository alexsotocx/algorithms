package chapter4;

import datastructures.AdjacencyList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class E4_7Test {

  @Test
  public void buildOrder() {
    AdjacencyList projects = new AdjacencyList(6);
    projects.addConnection(normalizeChar('a'), normalizeChar('d'));
    projects.addConnection(normalizeChar('f'), normalizeChar('b'));
    projects.addConnection(normalizeChar('b'), normalizeChar('d'));
    projects.addConnection(normalizeChar('f'), normalizeChar('a'));
    projects.addConnection(normalizeChar('d'), normalizeChar('c'));
    projects.addConnection(normalizeChar('c'), normalizeChar('e'));

    Stack<Character> characters = new E4_7().buildOrder(projects);
    char[] output = new char[]{'f', 'b', 'a', 'd', 'c', 'e'};
    int i = 0;
    while (!characters.empty()) Assert.assertEquals(output[i++], characters.pop().charValue());
  }

  private int normalizeChar(char c) {
    return c - 'a';
  }
}