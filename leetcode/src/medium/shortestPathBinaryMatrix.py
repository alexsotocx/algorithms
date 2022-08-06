import queue
from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        q = queue.SimpleQueue()
        q.put_nowait((0, 0, 1))
        inf = 1 << 30
        n = len(grid)
        distance = [[inf for _ in range(n)] for _ in range(n)]
        distance[0][0] = 1
        while not q.empty():
            x, y, d = q.get_nowait()
            for i in range(-1, 2):
                for j in range(-1, 2):
                    dy = y + j
                    dx = x + i
                    inside = 0 <= dx < n and 0 <= dy < n
                    if inside and grid[dx][dy] != 1 and distance[dx][dy] == inf:
                        distance[dx][dy] = d + 1
                        q.put_nowait((dx, dy, d + 1))
        return distance[n-1][n-1] if distance[n-1][n-1] != inf else -1
