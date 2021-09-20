package google

func maxAB(a, b int) int {
	if a > b {
		return a
	}
	return b
}

const min = -1 * (1 << 30)

var max int

func maxPathSum(root *TreeNode) int {
	max = min
	sumPath(root)
	return max
}

func sumPath(root *TreeNode) int {
	sumRoot := root.Val
	var sumLeft, sumRight int
	localMax := sumRoot
	if root.Right != nil {
		sumRight = sumPath(root.Right)
		localMax = maxAB(localMax, sumRoot+sumRight)
	}
	if root.Left != nil {
		sumLeft = sumPath(root.Left)
		localMax = maxAB(localMax, sumRoot+sumLeft)
	}

	max = maxAB(max, sumRoot+sumLeft+sumRight)
	max = maxAB(max, localMax)
	return localMax
}
