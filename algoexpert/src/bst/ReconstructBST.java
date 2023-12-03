package bst;

import java.util.ArrayList;
import java.util.Stack;

public class ReconstructBST {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    Stack<BST> nodeStack = new Stack<>();
    BST head = new BST(preOrderTraversalValues.get(0));
    nodeStack.push(head);

    for (int i = 1; i < preOrderTraversalValues.size(); i++) {
      BST currentHead = nodeStack.peek();
      BST newNode = new BST(preOrderTraversalValues.get(i));
      if (newNode.value < currentHead.value) {
        currentHead.left = newNode;
      } else {
        BST currentNode = nodeStack.peek();
        while(!nodeStack.isEmpty() && nodeStack.peek().value <= newNode.value) {
          currentNode = nodeStack.pop();
        }
        currentNode.right = newNode;
      }

      nodeStack.push(newNode);
    }


    return head;
  }
}
