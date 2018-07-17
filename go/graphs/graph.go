package graphs

type node struct {
	vertex    int
	weight    int
	inDegree  int
	outDegree int
}

type Graph struct {
	adjacencyList [][]*node
}

func New(n int) *Graph {
	return &Graph{
		adjacencyList: make([][]*node, n),
	}
}

func (graph *Graph) AddNode(nd, vertex, weight int) {
	adj := graph.adjacencyList[nd]
	adj = append(adj, &node{vertex: vertex, weight: weight})
}
