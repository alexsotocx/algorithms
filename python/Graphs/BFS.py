from typing import List
from dataclasses import dataclass
from collections import deque, namedtuple
INF = 1 << 31
WHITE = 0
GRAY = 1
BLACK = 2


@dataclass
class Edge:
    vertex: int
    weight: int


@dataclass
class BFSResult:
    distance: List[int]
    colors: List[int]


class AdjacencyList:
    def __init__(self, nodes_number: int):
        adjacency: List[List[Edge]] = []
        for i in range(nodes_number):
            adjacency.append([])
        self._adjacencyList = adjacency

    def add_vertex(self, u: int, v: int, weight: int = 1):
        self._adjacencyList[u].append(Edge(v, weight))

    def edges(self, u: int) -> List[Edge]:
        return self._adjacencyList[u]

    def size(self) -> int:
        return len(self._adjacencyList)


def bfs(start: int, adjL: AdjacencyList):
    q = deque()
    result = BFSResult(
        [INF for x in range(adjL.size())],
        [WHITE for x in range(adjL.size())]
    )
    result.distance[start] = 0

    q.append(start)
    while q:
        u = q.popleft()
        for v in adjL.edges(u):
            if result.colors[v.vertex] == WHITE:
                result.distance[v.vertex] = result.distance[u] + 1
                result.colors[u] = GRAY
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
