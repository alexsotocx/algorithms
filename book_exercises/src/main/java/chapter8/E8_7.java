package chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class E8_7 {
  private String toPermute;
  private ArrayList<String> permutations;
  private boolean[] visited;
  private HashSet<String> alreadyAdded;

  public E8_7(String toPermute) {
    this.toPermute = toPermute;
  }

  public ArrayList<String> getPermutations() {
    permutations = new ArrayList<>();
    visited = new boolean[toPermute.length()];
    alreadyAdded = new HashSet<>();
    generatePermutations(new LinkedList<>());
    return permutations;
  }

  private void generatePermutations(LinkedList<Character> qTemp) {
    if (qTemp.size() == toPermute.length()) {
      String per = createPermutation(qTemp);
      if (alreadyAdded.add(per))
        permutations.add(createPermutation(qTemp));
    } else {
      for (int i = 0; i < toPermute.length(); i++) {
        if (visited[i]) continue;
        visited[i] = true;
        qTemp.addLast(toPermute.charAt(i));
        generatePermutations(qTemp);
        visited[i] = false;
        qTemp.removeLast();
      }
    }
  }

  private String createPermutation(Queue<Character> q) {
    StringBuilder sb = new StringBuilder();
    for (Character c : q) sb.append(c);
    return sb.toString();
  }
}
