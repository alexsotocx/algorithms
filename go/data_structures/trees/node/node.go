package node

import "github.com/alexsotocx/algorithms/go/interfaces"

type Node struct {
	LeftChildren  *Node
	RightChildren *Node
	Data          interfaces.Comparable
}

func New(data interfaces.Comparable) *Node {
	node := new(Node)
	node.Data = data
	return node
}
