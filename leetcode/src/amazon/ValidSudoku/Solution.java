package amazon.ValidSudoku;

import java.util.stream.IntStream;

class Solution {
  private boolean validRow(int row, char[][] board) {
    boolean[] visited = new boolean[10];
    for (char x : board[row]) {
      if (x == '.') continue;
      if (visited[(int) x - '0']) return false;
      visited[x - '0'] = true;
    }
    return true;
  }

  private boolean validColumn(int column, char[][] board) {
    boolean[] visited = new boolean[10];
    for (char[] row : board) {
      char x = row[column];
      if (x == '.') continue;
      if (visited[x - '0']) return false;
      visited[x - '0'] = true;
    }
    return true;
  }

  private boolean validateSquare(int r, int c, char[][] board) {
    boolean[] visited = new boolean[10];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char x = board[r + i][c + j];
        if (x == '.') continue;
        if (visited[x - '0']) return false;
        visited[x - '0'] = true;
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    boolean allRowsValid = IntStream.range(0, 9).allMatch(i -> validRow(i, board));
    if (!allRowsValid) return false;
    boolean allColumns = IntStream.range(0, 9).allMatch(i -> validColumn(i, board));
    if (!allColumns) return false;
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        if (!validateSquare(i, j, board)) return false;
      }
    }
    return true;
  }
}
/**
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 */
