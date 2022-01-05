package amazon.WorldBreak;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  private class TrieNode {
    String word;
    TrieNode[] nodes = new TrieNode[26];
  }

  private TrieNode buildTrie(List<String> wordDict) {
    TrieNode root = new TrieNode();
    for (String word : wordDict) {
      TrieNode current = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int pos = c - 'a';
        if (current.nodes[pos] == null) {
          TrieNode tmp = new TrieNode();
          current.nodes[pos] = tmp;
          current = tmp;
        } else {
          current = current.nodes[pos];
        }
      }
      current.word = word;
    }
    return root;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    TrieNode root = buildTrie(wordDict);
    return canBeSplit(s, root);
  }

  private boolean canBeSplit(String s, TrieNode dict) {
    Queue<Integer> lastPos = new LinkedList<>();
    boolean[] visited = new boolean[s.length()];
    lastPos.add(0);
    while (!lastPos.isEmpty()) {
      int pos = lastPos.poll();
      if (pos == s.length()) return true;
      if (visited[pos]) continue;
      TrieNode current = dict;
      for (int i = pos; i < s.length(); i++) {
        int c = s.charAt(i) - 'a';
        if (current.nodes[c] == null) break;
        current = current.nodes[c];
        if (current.word != null) {
          lastPos.add(i + 1);
        }
      }
      visited[pos] = true;
    }
    return false;
  }
}
