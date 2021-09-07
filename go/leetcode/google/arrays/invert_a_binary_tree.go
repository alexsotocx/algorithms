package google

//  Definition for a binary tree node.
type treeNode struct {
	Val   int
	Left  *treeNode
	Right *treeNode
}

func InvertTree(root *treeNode) *treeNode {
	if root == nil {
		return nil
	}
	InvertTree(root.Left)
	InvertTree(root.Right)
	root.Left, root.Right = root.Right, root.Left
	return root
}
