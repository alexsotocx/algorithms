from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        dp = [[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = grid[0][0]
        for i in range(n):
            for j in range(m):
                if i == 0 == j:
                    continue
                top = dp[i-1][j] if i > 0 else 1 << 20
                left = dp[i][j - 1] if j > 0 else 1 << 20
                dp[i][j] = min(top, left) + grid[i][j]

        return dp[n - 1][m-1]

assert Solution().minPathSum([[1,3,1],[1,5,1],[4,2,1]]) == 7
