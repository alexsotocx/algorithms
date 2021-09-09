package google

//  Definition for a Node.
type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyNode(actualNode *Node, saveList map[*Node]*Node) *Node {
	if actualNode == nil {
		return nil
	}
	if n, ok := saveList[actualNode]; ok {
		return n
	}
	n := &Node{Val: actualNode.Val}
	saveList[actualNode] = n
	n.Next = copyNode(actualNode.Next, saveList)
	n.Random = copyNode(actualNode.Random, saveList)
	return n
}

func copyRandomList(head *Node) *Node {
	oldNewMap := make(map[*Node]*Node)

	return copyNode(head, oldNewMap)
}
