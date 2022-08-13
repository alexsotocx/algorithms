from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        if obstacleGrid[m - 1][n - 1] == 1 or obstacleGrid[0][0] == 1:
            return 0

        dp = [[0 for i in range(n)] for j in range(m)]

        dp[0][0] = 1
        for i in range(0, m):
            for j in range(0, n):
                if i == 0 == j:
                    continue
                if obstacleGrid[i][j] == 1:
                    continue
                top = dp[i-1][j] if i > 0 else 0
                left = dp[i][j - 1] if j > 0 else 0
                dp[i][j] = top + left
        return dp[m - 1][n-1]

