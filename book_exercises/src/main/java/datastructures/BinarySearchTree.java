package datastructures;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
  private BinaryNode<T> root;

  private static class ParentChild<T> {
    private BinaryNode<T> parent;
    private BinaryNode<T> child;

    public ParentChild(BinaryNode<T> parent, BinaryNode<T> child) {
      this.parent = parent;
      this.child = child;
    }
  }

  public void add(T data) {
    if (root == null) {
      root = new BinaryNode<>(data);
      return;
    }
    BinaryNode<T> current = root;
    while (true) {
      if (current.data.compareTo(data) > 0) {
        if (current.left == null) {
          current.left = new BinaryNode<>(data);
          break;
        }
        current = current.left;
      } else {
        if (current.right == null) {
          current.right = new BinaryNode<>(data);
          break;
        }
        current = current.right;
      }
    }
  }

  public void print() {
    inOrder(root);
  }

  public ArrayList<T> nodes() {
    ArrayList<T> arrayList = new ArrayList<>();
    inOrder(arrayList, root);
    return arrayList;
  }

  private void inOrder(ArrayList<T> out, BinaryNode<T> node) {
    if (node != null) {
      inOrder(out, node.left);
      out.add(node.data);
      inOrder(out, node.right);
    }
  }

  private void inOrder(BinaryNode<T> node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.data);
      inOrder(node.right);
    }
  }


  public boolean hasKey(T data) {
    ParentChild<T> result = findNode(data);
    return result.child != null;
  }

  public void remove(T data) {
    ParentChild<T> result = findNode(data);
    if (result.child == null) return; //No result
    if (result.child.isLeaf()) deleteLeaf(result.parent, result.child);
    else {
      if (result.child.right != null) replaceNodeWith(smaller(result.child, result.child.right), result.child);
      else replaceNodeWith(greater(result.child, result.child.left), result.child);
    }
  }

  private void replaceNodeWith(ParentChild<T> parentChild, BinaryNode<T> child) {
    deleteLeaf(parentChild.parent, parentChild.child);
    child.data = parentChild.child.data;
  }

  private void deleteLeaf(BinaryNode<T> parent, BinaryNode<T> child) {
    if (parent == null) root = null;
    else if (child == parent.left) parent.left = null;
    else parent.right = null;
  }

  private ParentChild<T> findNode(T data) {
    BinaryNode<T> current = root;
    BinaryNode<T> parent = null;
    while (current != null) {
      if (data == current.data) break;
      if (data.compareTo(current.data) > 0) {
        parent = current;
        current = current.right;
      } else {
        parent = current;
        current = current.left;
      }
    }
    return new ParentChild<>(parent, current);
  }

  private ParentChild<T> smaller(BinaryNode<T> parent, BinaryNode<T> node) {
    BinaryNode<T> child = node;
    while (child.left != null) {
      parent = child;
      child = child.left;
    }
    return new ParentChild<>(parent, child);
  }

  private ParentChild<T> greater(BinaryNode<T> parent, BinaryNode<T> node) {
    BinaryNode<T> child = node;
    while (child.right != null) {
      parent = child;
      child = child.right;
    }
    return new ParentChild<>(parent, child);
  }
}
