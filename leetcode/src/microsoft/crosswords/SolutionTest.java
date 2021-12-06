package microsoft.crosswords;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void findWords() {
    char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
    String[] words = new String[]{"oath", "pea", "eat", "rain"};
    System.out.println(new Solution().findWords(board, words));
  }
}
