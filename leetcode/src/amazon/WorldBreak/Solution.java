package amazon.WorldBreak;


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

  public boolean wordBreak(String s, List<String> wordDict) {
    TrieNode root = buildTrie(wordDict);
    return canBeSplit(s, 0, root, new LinkedList<>());
  }

  private boolean canBeSplit(String s, int pos, TrieNode dict, LinkedList<String> phrase) {
    if (pos == s.length()) {
      return true;
    }
    TrieNode current = dict;
    for (int i = pos; i < s.length(); i++) {
      int n = s.charAt(i) - 'a';
      if (current.nodes[n] == null) break;
      current = current.nodes[n];
      if (current.word != null) {
        phrase.addLast(current.word);
        if (canBeSplit(s, i + 1, dict, phrase)) return true;
        phrase.removeLast();
      }
    }
    return false;
  }
}
