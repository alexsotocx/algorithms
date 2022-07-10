from typing import List


class Knapsack:
    def solve(self, w: List[int], v: List[int], maxW: int) -> int:
        dp = [[0 for _ in range(maxW + 1)] for _ in range(len(v))]
        for wi in range(1, maxW+1):
            for j in range(len(v)):
                if (j > 0):
                    dp[j][wi] = dp[j - 1][wi]
                if (wi >= w[j]):
                    dp[j][wi] = max(dp[j][wi], dp[j - 1][wi - w[j]] + v[j])

        return dp[len(w)-1][maxW]


k = Knapsack()
print(k.solve((5, 4, 6, 3), (10, 40, 30, 50), 10))
