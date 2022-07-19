package medium.wordsearch;

/*
*
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == word[0] and self.util(board, word, i, j, 0):
                    return True

        return False

    def util(self, board: List[List[str]], word: str, i: int, j: int, pos: int) -> bool:
        if not (0 <= i < len(board) and 0 <= j < len(board[i])):
            return False
        if word[pos] != board[i][j]:
            return False

        if pos == len(word) - 1:
            return True

        temp, board[i][j] = board[i][j], "#"
        tx = [0, 1, 0, -1]
        ty = [1, 0, -1, 0]
        for k in range(4):
            if (self.util(board, word, i + tx[k], j + ty[k], pos + 1)):
                return True

        board[i][j] = temp
        return False


* */
class Solution {
  final int[] tx = new int[]{0, 1, 0, -1};
  final int[] ty = new int[]{1, 0, -1, 0};

  public boolean exist(char[][] board, String word) {
    char[] x = word.toCharArray();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j] == x[0] && this.util(board, x, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean util(char[][] board, char[] word, int i, int j, int pos) {
    boolean inside = ((i >= 0 && i < board.length) && (j >= 0 && j < board[i].length));
    if (!inside) {
      return false;
    }
    if (word[pos] != board[i][j]) {
      return false;
    }

    if (pos == word.length - 1) {
      return true;
    }

    char temp = board[i][j];
    board[i][j] = '#';
    for(int k = 0 ; k < 4; k++) {
      if(this.util(board, word, i + tx[k], j + ty[k], pos + 1)) {
        return true;
      }
    }
    board[i][j] = temp;

    return false;
  }
}
