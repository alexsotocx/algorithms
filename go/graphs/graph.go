package graphs

type node struct {
	vertex    int
	weight    int
	inDegree  int
	outDegree int
}

type Graph struct {
	adjacencyList []*node
}

func New() *Graph {
	return &Graph{
		adjacencyList: make([]*node, 0),
	}
}

func (graph *Graph) AddNode(vertex, weight int) {
	graph.adjacencyList = append(graph.adjacencyList, &node{vertex: vertex, weight: weight})
}
