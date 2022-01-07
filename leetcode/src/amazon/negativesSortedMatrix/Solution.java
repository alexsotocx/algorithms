package amazon.negativesSortedMatrix;

class Solution {
  public int countNegatives(int[][] grid) {
    int row = 0;
    int column = grid[0].length - 1;
    int count = 0;
    while (row < grid.length && column >= 0) {
      if (grid[row][column] < 0) {
        count += grid.length - row;
        column--;
      } else {
        row++;
      }
    }
    return count;
  }
}
