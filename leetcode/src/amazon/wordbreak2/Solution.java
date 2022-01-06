package amazon.wordbreak2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

  public List<String> wordBreak(String s, List<String> wordDict) {
    TrieNode root = buildTrie(wordDict);
    canBeSplit(s, root, 0, new LinkedList<>());
    return valid;
  }

  private List<String> valid = new LinkedList<>();

  private void canBeSplit(String s, TrieNode dict, int pos, LinkedList<String> currentString) {
    if (pos == s.length()) {
      StringBuilder st = new StringBuilder();
      Iterator<String> iterator = currentString.iterator();
      while (iterator.hasNext()) {
        st.append(iterator.next());
        if (iterator.hasNext()) st.append(' ');
      }
      valid.add(st.toString());
      return;
    }
    TrieNode current = dict;
    for (int i = pos; i < s.length(); i++) {
      int n = s.charAt(i) - 'a';
      if (current.nodes[n] == null) break;
      current = current.nodes[n];
      if (current.word != null) {
        currentString.addLast(current.word);
        canBeSplit(s, dict, i + 1, currentString);
        currentString.removeLast();
      }
    }
  }
}
