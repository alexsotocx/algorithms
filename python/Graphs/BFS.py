from dataclasses import dataclass

@dataclass
class Edge<T, W>:
	vertex: T
	weight: W


class AdjancencyList:
	def __init__(nodes_number: int):
		adjancencyList = []
		for i in range(nodes_number):
			adjacencyList.append([])
		
		self._adjacencyList = adjacencyList
		
		
	def self.add_vertex(u: int, v: int, weight: int = 1):
		self.adjancecyList[u].append(v)
		
class BFS:
	def __init__(graph: AdjancencyList):
