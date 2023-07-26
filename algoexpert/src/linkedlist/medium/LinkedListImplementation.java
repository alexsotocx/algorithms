package linkedlist.medium;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImplementation {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      if (node.next != null || node.prev != null) this.remove(node);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }
    }

    public void setTail(Node node) {
      if (node.next != null || node.prev != null) this.remove(node);
      if (tail == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
      }
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert.next != null || nodeToInsert.prev != null) this.remove(nodeToInsert);
      if (node == head) {
        this.setHead(nodeToInsert);
        return;
      }
      Node prev = node.prev;
      node.prev = nodeToInsert;
      nodeToInsert.next = node;
      prev.next = nodeToInsert;
      nodeToInsert.prev = prev;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      if (nodeToInsert.next != null || nodeToInsert.prev != null) this.remove(nodeToInsert);
      if (node == tail) {
        this.setTail(nodeToInsert);
        return;
      }
      Node next = node.next;
      node.next = nodeToInsert;
      nodeToInsert.prev = node;
      next.prev = nodeToInsert;
      nodeToInsert.next = next;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      Node pointer = head;
      while(position > 1) {
        pointer = pointer.next;
        position--;
      }
      this.insertBefore(pointer, nodeToInsert);
    }

    private List<Node> findNodesWithValue(int value) {
      Node pointer = head;
      List<Node> nodes = new ArrayList<>();
      while(pointer != null) {
        if (pointer.value == value) nodes.add(pointer);
        pointer = pointer.next;
      }
      return nodes;
    }

    public void removeNodesWithValue(int value) {
      for(Node node: this.findNodesWithValue(value)) this.remove(node);
    }

    public void remove(Node node) {
      if (head == tail && head == node) {
        head = null;
        tail = null;
      }
      else if (node == head) {
        if (head.next != null) head.next.prev = null;
        head = head.next;
      } else if (node == tail) {
        if (tail.prev != null) tail.prev.next = null;
        tail = tail.prev;
      } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      }
      node.next = null;
      node.prev = null;
    }

    public boolean containsNodeWithValue(int value) {
      return !this.findNodesWithValue(value).isEmpty();
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
