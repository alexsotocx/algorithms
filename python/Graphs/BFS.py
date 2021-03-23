from typing import List
from dataclasses import dataclass
from collections import deque
from AdjacencyList import AdjacencyList

INF = 1 << 31
WHITE = 0
GRAY = 1
BLACK = 2

@dataclass
class BFSResult:
    distance: List[int]
    colors: List[int]
    ancestor: List[int]


def bfs(start: int, adjL: AdjacencyList):
    q = deque()
    result = BFSResult(
        [INF for x in range(adjL.size())],
        [WHITE for x in range(adjL.size())],
        [None for x in range(adjL.size())]
    )
    result.distance[start] = 0
    q.append(start)
    while q:
        u = q.popleft()
        for v in adjL.edges(u):
            if result.colors[v.vertex] == WHITE:
                result.distance[v.vertex] = result.distance[u] + 1
                result.colors[v.vertex] = GRAY
                result.ancestor[v.vertex] = u
                q.append(v.vertex)
        result.colors[u] = BLACK

    return result


ad = AdjacencyList(6)
ad.add_vertex(0, 1)
ad.add_vertex(0, 5)
ad.add_vertex(1, 2)
ad.add_vertex(1, 3)
ad.add_vertex(3, 4)
ad.add_vertex(2, 4)
ad.add_vertex(4, 5)

print(bfs(0, ad))
