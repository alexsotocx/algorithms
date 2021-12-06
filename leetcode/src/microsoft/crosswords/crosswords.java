package microsoft.crosswords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

  class TrieNode {
    String word;
    TrieNode[] nodes;
    public TrieNode() {
      nodes = new TrieNode[26];
    }
  }

  private TrieNode createTrie(String words[]) {
    TrieNode head = new TrieNode();
    TrieNode current;
    for (String w : words) {
      current = head;
      for (int i = 0; i < w.length(); i++) {
        char c = w.charAt(i);
        if (current.nodes[c - 'a'] == null) current.nodes[c - 'a'] = new TrieNode();
        current = current.nodes[c - 'a'];
      }
      current.word = w;
    }
    return head;
  }

  static final int[] dx = new int[]{0, 1, 0, -1};
  static final int[] dy = new int[]{1, 0, -1, 0};

  private void dfs(char[][] board, int sx, int sy, TrieNode head, HashSet<String> words) {
    TrieNode currentNode = head.nodes[board[sx][sy] - 'a'];
    if (currentNode == null) return;
    if (currentNode.word != null) words.add(currentNode.word);
    char tmp = board[sx][sy];
    board[sx][sy] = 0;
    for (int i = 0; i < dx.length; i++) {
      int px = sx + dx[i];
      int py = sy + dy[i];
      boolean isInside = px >= 0 && px < board.length && py >= 0 && py < board[px].length;
      if (!isInside || board[px][py] == 0) continue;
      dfs(board, px, py, currentNode, words);
    }
    board[sx][sy] = tmp;
  }

  public List<String> findWords(char[][] board, String[] words) {
    HashSet<String> foundWords = new HashSet<>();
    TrieNode head = createTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(board, i, j, head, foundWords);
      }
    }

    return new ArrayList<>(foundWords);
  }
}
