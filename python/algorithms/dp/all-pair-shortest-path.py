from typing import List


class FloydW:
    def calculate(self, graph: List[List[List[int]]]) -> List[List[int]]:
        dp = [[-1 for _ in range(len(graph))] for _ in range(len(graph))]

        for u in range(len(graph)):
            dp[u][u]=0
            for j in graph[u]:
                v, w = j
                dp[u][v] = w

        for k in range(len(graph)):
            for u in range(len(graph)):
                for v in range(len(graph)):
                    if (dp[u][k] != -1 and dp[k][v] != -1):
                        w = dp[u][v] if dp[u][v] != -1 else 1<<60
                        dp[u][v] = min(w, dp[u][k] + dp[k][v])
        return dp


graph = [
        [],
        [(2, 5), (3, 9)],
        [(3, 1)],
        [(4, 2)],
        [(2, 3)]
]

d = FloydW().calculate(graph=graph)

assert d[1][4] == 8
assert d[1][3] == 6
assert d[3][2] == 5
assert d[3][1] == -1
