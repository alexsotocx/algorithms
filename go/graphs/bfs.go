package graphs

import "github.com/alexsotocx/algorithms/go/data_structures/linked_list/queue"

func (graph *Graph) Bfs(start int, visit func(n node)) {
	graph.bfs(start, visit, make([]int, len(graph.adjacencyList)))
}

func (graph *Graph) bfs(start int, visit func(n node), distance []int) []int {
	for i := range distance {
		distance[i] = -1
	}
	q := queue.New()
	q.PushBack(start)
	distance[start] = 0
	for !q.IsEmpty() {
		s, _ := q.DeleteHead()
		sn := s.(int)
		for _, v := range graph.adjacencyList[sn] {
			if distance[v.vertex] == -1 {
				distance[v.vertex] = distance[sn] + 1
				visit(*v)
				q.PushBack(v.vertex)
			}
		}
	}
	return distance
}
