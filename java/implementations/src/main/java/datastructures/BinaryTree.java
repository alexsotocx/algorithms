package datastructures;

import java.util.ArrayList;
import java.util.List;

abstract class BinaryTree<T> {
  private Node<T> root;
  private int size = 0;

  public abstract boolean insert(T data);
  public abstract boolean delete(T data);

  public List<T> preOrder() {
    List<T> list = new ArrayList<>();
    preOrder(root, list);
    return list;
  }
  public List<T> inOrder() {
    List<T> list = new ArrayList<>();
    inOrder(root, list);
    return list;
  }

  public List<T> posOrder() {
    List<T> list = new ArrayList<>();
    postOrder(root, list);
    return list;
  }

  private void preOrder(Node<T> node, List<T> results) {
    if (node != null) {
      results.add(node.data);
      preOrder(node.leftChild, results);
      preOrder(node.rightChild, results);
    }
  }

  private void inOrder(Node<T> node, List<T> results) {
    if (node != null) {
      inOrder(node.leftChild, results);
      results.add(node.data);
      inOrder(node.rightChild, results);
    }
  }

  private void postOrder(Node<T> node, List<T> results) {
    if (node != null) {
      postOrder(node.leftChild, results);
      postOrder(node.rightChild, results);
      results.add(node.data);
    }
  }


  public class Node<T> {
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T data) {
      this.data = data;
    }
  }
}
