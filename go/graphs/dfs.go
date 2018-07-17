package graphs

func (graph *Graph) Dfs(start int, visit func(n node)) {
	graph.dfs(start, visit, make([]bool, len(graph.adjacencyList)))
}

func (graph *Graph) dfs(start int, visit func(n node), visited []bool) {
	visited[start] = true
	for _, nd := range graph.adjacencyList[start] {
		if !visited[nd.vertex] {
			graph.dfs(nd.vertex, visit, visited)
		}
	}
}
