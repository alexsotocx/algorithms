from typing import List
from dataclasses import dataclass
from AdjacencyList import AdjacencyList

WHITE = 0
GRAY = 1
BLACK = 2

@dataclass
class DFSResult:
  distance: List[int]
  colors: List[int]
  ancestor: List[int]
  time: List[int]

class DFSContainer:
  def __init__(self, adj: AdjacencyList):
    self._adj = adj

  def __initialize_dfs_result(self):
    self._result = DFSResult(
        [0 for x in range(self._adj.size())],
        [WHITE for x in range(self._adj.size())],
        [None for x in range(self._adj.size())],
        [0 for x in range(self._adj.size())],
    )

  def dfs(self, start: int) -> DFSResult:
    self.__initialize_dfs_result()
    self._time = 0
    for i in range(self._adj.size()):
      not_visited = self._result.colors[i] == WHITE
      if not_visited:
        self.__dfs(i)

    return self._result

  def __dfs(self, start):
    self._time = self._time + 1
    self._result.distance[start] = self._time
    self._result.colors[start] = GRAY
    for edge in self._adj.edges(start):
      not_visited = self._result.colors[edge.vertex] == WHITE
      if not_visited:
        self._result.ancestor[edge.vertex] = start
        self.__dfs(edge.vertex)
    self._time = self._time + 1
    self._result.time[start] = self._time
    self._result.colors[start] = GRAY


ad = AdjacencyList(6)
ad.add_vertex(0, 1)
ad.add_vertex(0, 5)
ad.add_vertex(1, 2)
ad.add_vertex(1, 3)
ad.add_vertex(3, 4)
ad.add_vertex(2, 4)
ad.add_vertex(4, 5)

print(DFSContainer(ad).dfs(0))
