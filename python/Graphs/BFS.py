from dataclasses import dataclass

@dataclass
class Edge:
	vertex: int
	weight: int


class AdjacencyList:
	def __init__(self, nodes_number: int):
		adjacency = []
		for i in range(nodes_number):
			adjacency.append([])
		self._adjacencyList = adjacency


	def add_vertex(self, u: int, v: int, weight: int):
		self._adjacencyList[u].append(Edge(v, weight))


	def edges_from(self, u: int):
		return self._adjacencyList[u]

x = AdjacencyList(5)
x.add_vertex(1, 2, 1)
print((x.edges_from(1)))