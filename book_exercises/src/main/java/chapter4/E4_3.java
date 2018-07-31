package chapter4;

import datastructures.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class E4_3 {
  ArrayList<LinkedList<BinaryTreeNode<Integer>>> getLevels(BinaryTreeNode<Integer> root) {
    Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
    Queue<Integer> ql = new LinkedList<>();
    ArrayList<LinkedList<BinaryTreeNode<Integer>>> levels = new ArrayList<>();
    q.add(root);
    ql.add(0);
    while (!q.isEmpty()) {
      int level = ql.poll();
      BinaryTreeNode<Integer> current = q.poll();
      if (levels.size() == level) levels.add(new LinkedList<>());
      levels.get(level).add(current);
      if (current.left != null) {
        ql.add(level + 1);
        q.add(current.left);
      }

      if (current.right != null) {
        ql.add(level + 1);
        q.add(current.right);
      }
    }

    return levels;
  }
}
