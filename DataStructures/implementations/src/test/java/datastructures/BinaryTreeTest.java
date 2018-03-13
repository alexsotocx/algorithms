package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

class DummyTree<T> extends BinaryTree<T> {

  @Override
  public boolean insert(T data) {
    return true;
  }

  @Override
  public boolean delete(T data) {
    return false;
  }
}

public class BinaryTreeTest {

  @Test
  public void preOrder() {
  }

  @Test
  public void inOrder() {
  }

  @Test
  public void posOrder() {
  }
}