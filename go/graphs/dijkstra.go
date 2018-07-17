package graphs

import (
	"github.com/alexsotocx/algorithms/go/data_structures/heaps"
	"github.com/alexsotocx/algorithms/go/interfaces"
)

type pair struct {
	numNode, tDistance int
}

func (n pair) Compare(other interfaces.Comparable) int {
	no := other.(pair)
	return n.tDistance - no.tDistance
}

func (n pair) Value() interface{} {
	return n
}

func (graph *Graph) Dijkstra(start int, visit func(n node)) {
	graph.bfs(start, visit, make([]int, len(graph.adjacencyList)))
}

func (graph *Graph) dijkstra(start int, visit func(n node), distance []int) []int {
	for i := range distance {
		distance[i] = 1 << 30
	}
	q := &heaps.PriorityQueue{}
	q.Insert(pair{numNode: start, tDistance: 0})
	distance[start] = 0
	for !q.IsEmpty() {
		s := q.Pop()
		sn := s.(pair)
		if sn.tDistance <= distance[sn.numNode] {
			for _, v := range graph.adjacencyList[sn.numNode] {
				if distance[v.vertex] > sn.tDistance+v.weight {
					distance[v.vertex] = sn.tDistance + v.weight
					visit(*v)
					q.Insert(pair{numNode: v.vertex, tDistance: distance[v.vertex]})
				}
			}
		}
	}
	return distance
}
