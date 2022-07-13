from typing import Dict


class EditDistance:
    # Cost of transforming s1 into s2
    def calculate(self, s1: str, s2: str, cost: Dict):
        dp = [[0 for _ in range(len(s2) + 1)] for _ in range(len(s1)+1)]
        for i in range(len(s2) + 1):
            dp[len(s1)][i] = (len(s2) - i) * cost["insert"]
        for i in range(len(s1) + 1):
            dp[i][len(s2)] = (len(s1) - i) * cost["insert"]


        for i in range(len(s1) - 1, -1, -1):
            for j in range(len(s2) - 1, -1, -1):
                dp[i][j] = min(
                    dp[i+1][j+1] if s1[i] == s2[j] else 1 << 63,  # Equal
                    dp[i+1][j] + cost["insert"],
                    dp[i][j+1] + cost["delete"],
                    dp[i+1][j+1] + cost["replace"]
                )
        return dp[0][0]

assert EditDistance().calculate("ecfbefdcfca", "badfcbebbf", {"insert": 1, "delete": 1, "replace": 1}) == 9