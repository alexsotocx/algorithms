from typing import List


class Solution:
    def dfs(self, grid: List[List[str]], x: int, y: int):
        if not (x < len(grid) and x >= 0 and y < len(grid[x]) and y >= 0):
            return
        if (grid[x][y] == "0"):
            return

        grid[x][y] = "0"
        self.dfs(grid, x - 1, y)
        self.dfs(grid, x, y + 1)
        self.dfs(grid, x + 1, y)
        self.dfs(grid, x, y - 1)

    def numIslands(self, grid: List[List[str]]) -> int:
        c = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    c += 1
                    self.dfs(grid, i, j)
        return c
