from Edge import Edge
from typing import List

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
