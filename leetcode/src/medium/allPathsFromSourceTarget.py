from typing import List


class Solution:
    def backtrack(self, graph: List[List[int]], pos: int, path: List[int]):
        if (pos == len(graph) - 1):
            self.paths.append(path.copy())
            return

        self.visited[pos] = True
        for t in graph[pos]:
            if not self.visited[t]:
                path.append(t)
                self.backtrack(graph, t, path)
                path.pop()
        self.visited[pos] = False

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        n = len(graph)
        self.visited = [False for _ in range(n)]
        self.paths: List[List[int]] = []
        self.backtrack(graph, 0, [0])
        return self.paths
