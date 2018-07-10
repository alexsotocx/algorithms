package graphs

func (graph *Graph) Dfs(start int, visit func(n node)) {
	graph.dfs(start, visit, make([]bool, len(graph.adjacencyList)))
}

func (graph *Graph) dfs(start int, visit func(n node), visited []bool) {

}
